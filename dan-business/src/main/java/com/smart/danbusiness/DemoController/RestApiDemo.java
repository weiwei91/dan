package com.smart.danbusiness.DemoController;

import com.smart.dancommon.base.Response;
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
        return Response.success("sucess");
    }

}
