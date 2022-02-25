package uz.pdp.eticketdemoadmin.controller.auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {
    @GetMapping("/")
    public String getLoginPage(){
        return "authentication-login";
    }

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "authentication-register";
    }

}
