package com.huawei.iam.controller;

import com.huawei.iam.property.HelloProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouyibin on 2017/12/28.
 */
@RestController
public class HelloController {

    @Value("${hello.name}")
    private String helloName;

    @Value("${hello.to}")
    private String helloTo;

    @Value("${hello.times}")
    private int helloTimes;

    @Autowired
    private HelloProperty helloProperty;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping(value = "/hello2")
    public String sayHello2(){
        return "Hello world2";
    }

    @RequestMapping(value = {"/hello31","/hello32","/hello3","/hello3.xml"}, method = RequestMethod.GET)
    public String sayHello3(){
        return "hello3";
    }

    @RequestMapping(value = "/helloName", method = RequestMethod.GET)
    public String sayHelloName(){
        return helloName + " " + helloTo + " " + helloTimes;
    }

    @RequestMapping(value = "/helloName2", method = RequestMethod.GET)
    public String sayHelloName2(){
        return helloProperty.getName() + " " + helloProperty.getTo() + " " + helloProperty.getTimes();
    }
}
