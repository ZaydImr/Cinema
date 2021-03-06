package com.cinema.controller;

import com.cinema.models.User;
import com.cinema.services.EmailSenderService;
import com.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ResetPasswordController {

    private final EmailSenderService emailSenderService;

    @Autowired
    private UserService userService;

    @GetMapping("forgot_password")
    public String processForgetPassword(){
        return "reset";
    }

    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value="token") String token,Model model){
        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("token",token);
        if(user == null){
            model.addAttribute("message","Invalid Token");
            return "message";
        }
        return "reset_password";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request,Model model){
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("title","Reset your password");

        if(user == null){
            model.addAttribute("message","Invalid Token");
            return "login";
        }else{
            userService.updatePassword(user,password);
            model.addAttribute("message","You have successfully changed your password.");
        }
        return "login";
    }

}
