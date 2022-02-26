package uz.pdp.eticketdemoadmin.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user-table")
    public String getUserTable(){
        return "user-table";
    }
}
