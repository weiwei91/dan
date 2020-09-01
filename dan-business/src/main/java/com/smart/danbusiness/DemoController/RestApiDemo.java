package com.smart.danbusiness.DemoController;

import com.smart.dancommon.base.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ClassName RestApiDemo
 * @Author WeiWei10
 * @Date 2020/8/31 20:29
 * @Version 1.0
 */
@RestController
public class RestApiDemo {
    @GetMapping("/getDemo")
    public Response crypt() {
        Response response = Response.success("sucess");
        return response;
    }

    @GetMapping("/getDemo1")
    public Book crypt1() {

        return new Book("123");
    }
    @Data
    @AllArgsConstructor
    class Book{
        String name;
    }

}
