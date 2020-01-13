package com.hewei.black.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by herui
 * 结果返回集
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BaseResult<T> {
    private int code = 200;
    private boolean success = true;
    private String errorInfo = "default success info";
    private T data = null;

    public BaseResult success() {
        this.success = true;
        this.code = 200;
        this.errorInfo = "default success info";
        return this;
    }

    public BaseResult success(T data) {
        this.success();
        this.data = data;
        return this;
    }

    public BaseResult success(T data, String errorInfo) {
        this.success();
        this.data = data;
        this.errorInfo = errorInfo;
        return this;
    }

    public BaseResult failed() {
        this.success = false;
        this.code = 500;
        this.errorInfo = "default failed info";
        return this;
    }

    public BaseResult failed(String errorInfo) {
        this.success = false;
        this.code = 500;
        this.errorInfo = errorInfo;
        return this;
    }
    public BaseResult failed(String errorInfo,Integer code) {
        this.success = false;
        this.code = code;
        this.errorInfo = errorInfo;
        return this;
    }

    public BaseResult exception(int code, String errorInfo) {
        this.success = false;
        this.code = code;
        this.errorInfo = errorInfo;
        return this;
    }
    public static BaseResult ok(String message){
        BaseResult result = new BaseResult<>();
        result.setCode(200);
        result.setData(message);
        return result;
    }
    public static BaseResult error(String message){
        BaseResult result = new BaseResult<>();
        result.setCode(500);
        result.setData(message);
        return result;
    }


    /**
     * 错误请求针对参数错误的返回
     *
     * @return
     */
    public BaseResult notFound() {
        this.success = false;
        this.code = 404;
        this.errorInfo = "未查询到资源";
        return this;
    }
}
