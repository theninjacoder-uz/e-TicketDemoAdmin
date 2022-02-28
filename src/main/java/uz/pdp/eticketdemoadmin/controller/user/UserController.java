package uz.pdp.eticketdemoadmin.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/passenger-table")
    public String getUserTable(){
        return "passenger-table";
    }
}
