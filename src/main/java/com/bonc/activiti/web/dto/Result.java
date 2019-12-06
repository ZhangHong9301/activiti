package com.bonc.activiti.web.dto;

import com.bonc.activiti.service.enums.ResponseEnum;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 11:31
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -1812865936840508437L;

    public static final Logger LOGGER = LoggerFactory.getLogger(Result.class);

    private Integer code;

    private String msg;

    private Object data;

    public Result(String msg) {
        this.msg = msg;
    }

    public Result(ResponseEnum en) {
        this.code = en.getCode();
        this.msg = en.getMessage();
    }

    public static Result success() {
        return new Result(ResponseEnum.SUCCESS);
    }

    public static Result success(Object data) {
        Result result = new Result(ResponseEnum.SUCCESS);
        result.data = data;
        return result;
    }

    public static Result fail() {
        return new Result(ResponseEnum.FAILURE1);
    }

    public static Result fail(String msg) {
        return new Result(msg);
    }

    public static Result fail(ResponseEnum enums,Object data) {
        Result result = new Result(enums);
        result.setData(data);
        return result;
    }


}
