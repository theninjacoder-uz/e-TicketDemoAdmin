package uz.pdp.eticketdemoadmin.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.eticketdemoadmin.model.recieve.PassengerResponseDto;
import uz.pdp.eticketdemoadmin.service.user.PassengerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping
    public String getPassengerList(Model model){
        model.addAttribute("passengers", passengerService.getPassengerList());
        return "passenger";
    }

}
