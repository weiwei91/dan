package com.smart.danbusiness.DemoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName Demo
 * @Author WeiWei10
 * @Date 2020/8/31 20:19
 * @Version 1.0
 */
@Controller
public class WebDemo {

    /**
     * 整合前端资源暂时先不管
     */
    @RequestMapping("/")
    public String homePage() {
        return "redirect:index.html";
    }
    @RequestMapping("/template")
    public String homePage2() {
        return "index2";
    }


}
