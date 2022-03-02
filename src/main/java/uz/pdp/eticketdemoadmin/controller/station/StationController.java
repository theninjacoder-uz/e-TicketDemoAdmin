package uz.pdp.eticketdemoadmin.controller.station;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.eticketdemoadmin.model.recieve.station.StationReceiveDto;
import uz.pdp.eticketdemoadmin.service.address.AddressService;
import uz.pdp.eticketdemoadmin.service.station.StationService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/station")
public class StationController {

    private final AddressService addressService;
    private final StationService stationService;

    @GetMapping
    public String get(Model model){

        model.addAttribute("countries",  addressService.getCountryList());
        List<StationReceiveDto> list = stationService.getList();
        model.addAttribute("stations", list);
        return "station";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute StationReceiveDto stationReceiveDto, Model model){

        boolean add = stationService.add(stationReceiveDto);
        if(add){
            model.addAttribute("countries",  addressService.getCountryList());
            List<StationReceiveDto> list = stationService.getList();
            model.addAttribute("stations", list);
            return "station";
        }

        return "500";
    }
}
