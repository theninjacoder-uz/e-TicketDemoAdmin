package uz.pdp.eticketdemoadmin.controller.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.eticketdemoadmin.service.direction.DirectionService;
import uz.pdp.eticketdemoadmin.service.station.StationService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/direction-station")
public class DirectionStationController {

    private final StationService stationService;
    private final DirectionService directionService;

    @GetMapping
    public String getDirectionStationPage(Model model){
        model.addAttribute("directions", directionService.getList());
        model.addAttribute("stations", stationService.getList());
        return "direction-station";
    }



}
