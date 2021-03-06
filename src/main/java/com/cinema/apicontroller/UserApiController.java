package com.cinema.apicontroller;


import com.cinema.controller.Utility;
import com.cinema.models.User;
import com.cinema.services.EmailSenderService;
import com.cinema.services.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private EmailSenderService emailSenderService;

    public UserApiController(UserService userService,EmailSenderService emailSenderService){
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllFilms(){
        Long count = userService.getCountOfUsers();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> Users = userService.getAll();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") UUID id) {
        User user = null;
        try {
            user = userService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        String encoderPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
        User newUser = userService.addEntity(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateEntity(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable("id") UUID id){
        userService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("forgot_password")
    public void processForgotPassword(HttpServletRequest request, @RequestBody String email ){
        String token  = RandomString.make(30);
        userService.updateResetPasswordToken(token,email);

        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
        sendEmail(email,resetPasswordLink);
    }

    private void sendEmail(String recipientEmail, String link){
        System.out.println("Mail entered...");
        String subject = "Here's the link to reset your password";

        String content = "Hello,\n"
                +"You have requested to reset your password.\n"
                +"Click the link below to change your password :\n\n"
                +link
                +"\n\n"
                +"Ignore this email if you do remember your password,"
                +"or you have not made the request.";

        emailSenderService.sendEmailByUser(recipientEmail,content,subject);
    }


}
