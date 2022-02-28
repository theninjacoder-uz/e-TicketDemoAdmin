package uz.pdp.eticketdemoadmin.controller.train;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/train")
@RequiredArgsConstructor

public class TrainController {

    @GetMapping
    public String getTrainPage(){
        return "train";
    }
}
