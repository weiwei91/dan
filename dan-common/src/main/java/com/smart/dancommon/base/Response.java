package com.smart.dancommon.base;

/**
 * @ClassName Response
 * @Author WeiWei10
 * @Date 2020/8/31 19:04
 * @Version 1.0
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;

/**
 * 标准返回对象
 */
@Data
@NoArgsConstructor
public class Response<T> implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(Response.class);

    public static String CODE_SUCCESS = "0";
    public static String CODE_FAILURED = "-1";
    public static String ALREADY_HANDLED = "-2";


    private String code;
    private String msg;
    private T data;


    private Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 内部工厂方法，缺省消息提示
     * @param data
     * @return
     */
    public static final Response success(Object data) {
        return new Response(CODE_SUCCESS, "success", data);
    }

    /**
     * 内部工厂方法，缺省数据体
     * @param message
     * @return
     */
    public static final Response success(String message) {
        return new Response(CODE_SUCCESS, message, null);
    }

    /**
     * 内部工厂方法，完整成功返回
     *
     * @param message
     * @param data
     * @return
     */
    public static final Response success(String message, Object data) {
        return new Response(CODE_SUCCESS, message, data);
    }

    /**
     * 内部工厂方法，缺省消息体与数据体
     *
     * @return
     */
    public static final Response success() {
        return new Response(CODE_SUCCESS, null, null);
    }

    /**
     * 内部工厂方法，缺省数据体
     *
     * @param message
     * @return
     */
    public static final Response failure(String message) {
        return new Response(CODE_FAILURED, message, null);
    }

    /**
     * 内部工厂方法，完整错误消息体
     *
     * @param message
     * @param data
     * @param errorCode
     * @return
     */
    public static final Response failure(String message, Object data, String errorCode) {
        return new Response(errorCode, message, data);
    }


    /**
     * 内部工厂方法，缺省消息体
     *
     * @param data
     * @param errorCode
     * @return
     */
    public static final Response failure(Object data, String errorCode) {
        return new Response(errorCode, null, data);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess(){
        return Response.CODE_SUCCESS.equals(this.getCode());
    }
    public static Response alreadyHandled(){
        return new Response(ALREADY_HANDLED,"重复操作",null);
    }

}
