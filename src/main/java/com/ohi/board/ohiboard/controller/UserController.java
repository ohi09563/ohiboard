package com.ohi.board.ohiboard.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/auth/user/save")
        public String userSave(){

        System.out.println("회원가입확인");

        return "layout/user/user-save";

    }

    @GetMapping("/auth/user/login")
    public String userLogin(){


        System.out.println("로그인확인");
        
        return "layout/user/user-login";

    }

    @GetMapping("/user/update")
    public String userUpdate() {
        return "layout/user/user-update";
    }

}
