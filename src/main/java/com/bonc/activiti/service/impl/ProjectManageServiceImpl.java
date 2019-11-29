package com.bonc.activiti.service.impl;

import com.bonc.activiti.entity.AudFinalAccount;
import com.bonc.activiti.mapper.ProjectManageMapper;
import com.bonc.activiti.service.ProjectManageService;
import com.bonc.activiti.util.UUIDUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectManageServiceImpl implements ProjectManageService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectManageServiceImpl.class);


    @Autowired
    private ProjectManageMapper projectManageMapper;

    @Override
    public String importProject(MultipartFile file) throws IOException {
        logger.info("Start import ...");
        logger.info("File name is {}", file.getOriginalFilename());
        String fileName = file.getOriginalFilename();
        String msg = null;
        int[] resultCell = new int[]{0, 1, 2, 3, 4, 5};
        List<AudFinalAccount> resultList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            logger.error("上传文件不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        resultList = getSheetVal(sheet, resultCell);
        logger.info("结果是：{}", resultList);
        try {
//            决算审计项目入库
            projectManageMapper.addProject(resultList);
            msg = "数据导入成功";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "数据导入失败";
        }

        logger.info("");
        return msg;
    }


    private List<AudFinalAccount> getSheetVal(Sheet sheet, int[] resultCell) {
        List<AudFinalAccount> informationList = new ArrayList<>();
        int[] resultIndex = new int[resultCell.length];
        AudFinalAccount information;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            information = new AudFinalAccount();
            information.setId(UUIDUtil.createUUID());
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                String temp = getCellVal(row.getCell(i)).toString().trim();
                for (int j = 0; j < resultCell.length; j++) {
                    if (i == resultCell[j]) {
                        switch (i) {
                            case 0:
                                information.setProjectYear(temp);
                                break;
                            case 1:
                                information.setProjectNo(temp);
                                break;
                            case 2:
                                information.setProjectName(temp);
                                break;
                            case 3:
                                information.setProjectType(temp);
                                break;
                            case 4:
                                information.setCompanyNo(temp);
                                break;
                            case 5:
                                information.setCompanyName(temp);
                                break;
                            default:
                                break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            informationList.add(information);
        }
        return informationList;
    }

    public Object getCellVal(Cell cell) {
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }

    @Autowired
    public Object getProject() throws JsonProcessingException {
//        return projectManageMapper.selectProject();
        return "";
    }

    @Override
    public String getString(MultipartFile file) {
        //判断非空
        if (file.isEmpty()) {
            return "上传的文件不能为空";
        }
        try {
            // 测试MultipartFile接口的各个方法
            logger.info("[文件类型ContentType] - [{}]", file.getContentType());
            logger.info("[文件组件名称Name] - [{}]", file.getName());
            logger.info("[文件原名称OriginalFileName] - [{}]", file.getOriginalFilename());
            logger.info("[文件大小] - [{}]", file.getSize());
            //文件路径
            String path = "/Users/jinmin/Documents/FinalAccount-ZH/test/";
            logger.info(this.getClass().getName() + "图片路径：" + path);
            File f = new File(path);
            //如果不存在该路径就创建
            if (!f.exists()) {
                f.mkdir();
            }
            File dir = new File(path + file.getOriginalFilename());
            // 文件写入
            file.transferTo(dir);
            return "上传单个文件成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "上传单个文件失败";
        }
    }
}
