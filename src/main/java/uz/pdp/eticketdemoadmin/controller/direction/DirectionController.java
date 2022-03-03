package uz.pdp.eticketdemoadmin.controller.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.eticketdemoadmin.model.recieve.direction.DirectionDto;
import uz.pdp.eticketdemoadmin.model.recieve.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.model.recieve.train.WagonReceiveDto;
import uz.pdp.eticketdemoadmin.service.direction.DirectionService;

@Controller
@RequestMapping("/direction")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionService directionService;

    @GetMapping
    public String getDirectionPage(Model model){
        model.addAttribute("directions", directionService.getList());
        return "direction";
    }

    @PostMapping( produces = MediaType.TEXT_HTML_VALUE, consumes = "*/*")
    public String add(@ModelAttribute DirectionDto directionDto, Model model){
        boolean add = directionService.add(directionDto);
        model.addAttribute("directions", directionService.getList());
        return "direction";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boolean delete = directionService.delete(id);
        if(delete)
            return "redirect:/direction";
        else
            return "404";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        DirectionDto direction = directionService.getById(id);
        model.addAttribute("direction", direction);
        return "direction-edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Long id, @ModelAttribute DirectionDto directionDto){
        boolean edit = directionService.edit(id, directionDto);

        return "redirect:/direction";
    }

}
