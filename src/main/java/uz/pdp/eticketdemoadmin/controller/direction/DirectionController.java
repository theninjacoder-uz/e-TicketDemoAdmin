package uz.pdp.eticketdemoadmin.controller.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.eticketdemoadmin.model.recieve.direction.DirectionDto;
import uz.pdp.eticketdemoadmin.service.direction.DirectionService;

@Controller
@RequestMapping("/direction")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionService directionService;

    @GetMapping
    public String getTrainPage(Model model){
        model.addAttribute("directions", directionService.getList());
        return "direction";
    }

    @PostMapping( produces = MediaType.TEXT_HTML_VALUE, consumes = "*/*")
    public String add(@ModelAttribute DirectionDto directionDto, Model model){
        boolean add = directionService.add(directionDto);
        model.addAttribute("directions", directionService.getList());
        return "direction";
    }

}
