package com.bonc.activiti.util;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream; /**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-24 11:10
 */
public class HttpUtils {


    public static void copyImageStream(InputStream inputStream
            , ServletOutputStream outputStream) {
        try {
            IOUtils.copy(inputStream,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
