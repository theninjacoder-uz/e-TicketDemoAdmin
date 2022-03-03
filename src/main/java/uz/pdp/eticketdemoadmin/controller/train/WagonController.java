package uz.pdp.eticketdemoadmin.controller.train;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemoadmin.model.recieve.direction.DirectionDto;
import uz.pdp.eticketdemoadmin.model.recieve.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.model.recieve.train.WagonReceiveDto;
import uz.pdp.eticketdemoadmin.service.train.WagonService;

@Controller
@RequestMapping("/wagon")
@RequiredArgsConstructor
public class WagonController {
    private final WagonService wagonService;

    @GetMapping
    public String getWagonPage(Model model){
        model.addAttribute("wagons", wagonService.getList());
        return "wagon";
    }

    @PostMapping( produces = MediaType.TEXT_HTML_VALUE, consumes = "*/*")
    public String add(@ModelAttribute WagonReceiveDto wagonDto, Model model){
        boolean add = wagonService.add(wagonDto);
        model.addAttribute("wagons", wagonService.getList());
        return "wagon";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boolean delete = wagonService.delete(id);
        if(delete)
            return "redirect:/wagon";
        else
            return "404";
    }
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        WagonReceiveDto wagon = wagonService.getById(id);
        model.addAttribute("wagon", wagon);
        return "wagon-edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@RequestParam("id") Long id,  @ModelAttribute WagonReceiveDto wagonReceiveDto){
        boolean edit = wagonService.edit(id, wagonReceiveDto);
        return "redirect:/wagon";
    }

}
