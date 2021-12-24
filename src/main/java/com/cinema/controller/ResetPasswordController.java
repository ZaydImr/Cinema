package com.cinema.controller;

import com.cinema.models.User;
import com.cinema.services.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("")
public class ResetPasswordController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @GetMapping("/forget_password")
    public String processForgetPassword(){
        return "resetPassword";
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        String token  = RandomString.make(30);

        try{
            userService.updateResetPasswordToken(token,email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email,resetPasswordLink);
            model.addAttribute("message","we have sent a reset password link to your email. Please check.");
        }catch (UsernameNotFoundException ex){
            model.addAttribute("error",ex.getMessage());
        } catch (UnsupportedEncodingException | MessagingException e){
            model.addAttribute("error","Error while sending the email");
        }
        return "resetPassword";
    }

    private void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException{
        MimeMessage message  = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("cinemaemailsender@gmail.com","rarieelxzkcoluwx");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                +"<p>You have requested to reset your password.</p>"
                +"<p>Click the link below to change your password : </p>"
                +"<p><a href=\""+link+"\">Change my password</p>"
                +"<br>"
                +"<p>Ignore this email if you do remember your password,"
                +"or you have not made the request.</p>";

        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(message);
    }

    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value="token") String token,Model model){
        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("token",token);
        if(user == null){
            model.addAttribute("message","Invalid Token");
            return "message";
        }
        return "resetPassword";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request,Model model){
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("title","Reset youe password");

        if(user == null){
            model.addAttribute("message","Invalid Token");
            return "message";
        }else{
            userService.updatePassword(user,password);
            model.addAttribute("message","You have successfully changed your password.");
        }
        return "message";
    }

    // Javascript function to validate the match of tow password fields
    /*function checkPasswordMatch(fieldConfirmPassword) {
        if (fieldConfirmPassword.value != $("#password").val()) {
            fieldConfirmPassword.setCustomValidity("Passwords do not match!");
        } else {
            fieldConfirmPassword.setCustomValidity("");
        }
    }*/
}
