package com.smart.dancommon.base;

import com.smart.dancommon.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

/**
 * @ClassName MethodResult
 * @Author WeiWei10
 * @Date 2020/8/31 19:28
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class MethodResult<T> implements Serializable {
    private static final long serialVersionUID = 783688038565234784L;
    public boolean result;
    public String message;
    public T data;
    public static MethodResult reject(String message) {
        return new MethodResult(Constants.TAG_FAIL, message, Constants.OBJECT_NULL);
    }

    public static <T> MethodResult<T> resolve(T data){
        return new MethodResult(Constants.TAG_SUCCESS, Constants.STRING_EMPTY, data);
    }

    public static <T> MethodResult<T> resolve(String message, T data){
        return new MethodResult<T>(Constants.TAG_SUCCESS, message, data);
    }
}
