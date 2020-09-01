package com.smart.dancommon.base;

/**
 * @ClassName Response
 * @Author WeiWei10
 * @Date 2020/8/31 19:04
 * @Version 1.0
 */

import com.smart.dancommon.constant.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import static com.smart.dancommon.constant.Constants.CODE_ALREADY_HANDLED;
import static com.smart.dancommon.constant.Constants.CODE_FAILURED;
import static com.smart.dancommon.constant.Constants.CODE_SUCCESS;

/**
 * 标准返回对象
 */
@Data
@NoArgsConstructor
public class Response<T> implements Serializable {


    private String code;
    private String msg;
    private T data;


    public Response(String code, String msg, T data) {
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
     * @param code
     * @return
     */
    public static final Response failure(String message, Object data, String code) {
        return new Response(code, message, data);
    }

    /**
     * 内部工厂方法，缺省code
     *
     * @param message
     * @param data

     * @return
     */
    public static final Response failure(String message, Object data) {
        return new Response(Constants.CODE_FAILURED, message, data);
    }


    /**
     * 内部工厂方法，缺省消息体
     *
     * @param data
     * @param code
     * @return
     */
    public static final Response failure(Object data, String code) {
        return new Response(code, null, data);
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
        return CODE_SUCCESS.equals(this.getCode());
    }
    public static Response alreadyHandled(){
        return new Response(CODE_ALREADY_HANDLED,"重复操作",null);
    }

}
