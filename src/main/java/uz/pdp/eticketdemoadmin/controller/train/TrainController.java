package uz.pdp.eticketdemoadmin.controller.train;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemoadmin.model.recieve.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.service.train.TrainService;

@Controller
@RequestMapping("/train")
@RequiredArgsConstructor

public class TrainController {
    private final TrainService trainService;

    @GetMapping
    public String getTrainPage(Model model){
        model.addAttribute("trains", trainService.getList());
        return "train";
    }

    @PostMapping( produces = MediaType.TEXT_HTML_VALUE, consumes = "*/*")
    public String add(@ModelAttribute TrainReceiveDto trainReceiveDto, Model model){
        boolean add = trainService.add(trainReceiveDto);
        model.addAttribute("trains", trainService.getList());
        return "train";
    }
}
