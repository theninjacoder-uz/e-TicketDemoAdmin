package uz.pdp.eticketdemoadmin.controller.train;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.eticketdemoadmin.model.recieve.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.service.train.TrainService;

import java.util.List;

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

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boolean delete = trainService.delete(id);
        if(delete)
        return "redirect:/train";
        else
            return "404";
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") Long id, Model model){
        TrainReceiveDto edit = trainService.edit(id);
        model.addAttribute("train", edit);

        return new ModelAndView("/train-edit");
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Long id, @ModelAttribute TrainReceiveDto trainReceiveDto){
        boolean edit = trainService.edit(id, trainReceiveDto);

        return "redirect:/train";
    }
}
