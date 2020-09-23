package com.nmq.es.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niemengquan
 * @create 2020/9/21
 * @modifyUser
 * @modifyDate
 */
@RestController
@Api(value = "ES 搜索服务")
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Search service!";
    }
}
