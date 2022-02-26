package uz.pdp.eticketdemoadmin.controller.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemoadmin.model.recieve.UserReceiveDto;
import uz.pdp.eticketdemoadmin.service.user.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class AuthController {

    private final UserService userService;
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(){
        return "index";
//        return "authentication-login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUserByPhoneNumber(@RequestBody UserReceiveDto userReceiveDto){
        boolean res = userService.login(userReceiveDto);
        if(res)
            return "index";
        else
            return "error-404";
    }

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "authentication-register";
    }

}
