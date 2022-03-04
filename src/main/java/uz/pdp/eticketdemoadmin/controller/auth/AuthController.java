package uz.pdp.eticketdemoadmin.controller.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.eticketdemoadmin.model.recieve.user.UserReceiveDto;
import uz.pdp.eticketdemoadmin.service.user.UserService;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    @GetMapping(value = {"/", "/login"})
    public String login(Model model){
//        model.addAttribute("train", new TrainReceiveDto(1, "AA", "A01", 300,300));
//        return "train-edit";
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
