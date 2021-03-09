package com.reuben.springlearn.aop.jointPoint.controller;

import com.reuben.springlearn.aop.jointPoint.service.JoinPointService;
import com.reuben.springlearn.aop.proxy.CashierStaff;
import com.reuben.springlearn.aop.proxy.CglibProxyDemo;
import com.reuben.springlearn.aop.proxy.JdkProxyDemo;
import com.reuben.springlearn.aop.proxy.WelcomeStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinPointController {

    @Autowired
    private JoinPointService pointService;

    @GetMapping("/welcomeProxy")
    public String welcome(@RequestParam("name")String name){
        if(pointService.addConsumer(name)){
            // 有客人来了.让人进来迎宾
            WelcomeStaff welcomeStaff = CglibProxyDemo.getProxy();
            welcomeStaff.sayHello();
            return "欢迎".concat(name).concat("访问");
        }
        return name.concat("大人,您回来啦!");
    }

    @GetMapping("/vipService")
    public String vipService(@RequestParam("name")String name){
        return name.concat("大人,好好享受吧!");
    }

    @GetMapping("/leave")
    public String leave(@RequestParam("name")String name){
        if(pointService.removeConsumer(name)){
            CashierStaff staff = JdkProxyDemo.getCashierStaff();
            staff.getMoney();
            return "感谢".concat(name).concat("惠顾");
        }
        return name.concat("从哪里进来的,不要跑!");
    }

    @GetMapping("/throw")
    public Boolean throwMethod(@RequestParam("name")String name){
        try{
            return pointService.throwException(name);
        }catch (Exception e){
            return false;
        }

    }
}
