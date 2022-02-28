package uz.pdp.eticketdemoadmin.controller.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemoadmin.model.recieve.UserReceiveDto;
import uz.pdp.eticketdemoadmin.service.user.UserService;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
//        return "authentication-login";
    }

    @PostMapping(value = "/login", produces = MediaType.TEXT_HTML_VALUE, consumes = "*/*")
    public String checkUserByPhoneNumber(@ModelAttribute UserReceiveDto userReceiveDto){
        boolean res = userService.login(userReceiveDto);
        if(res)
            return "index";
        else
            return "unauthorization";
    }

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "register";
    }

}
