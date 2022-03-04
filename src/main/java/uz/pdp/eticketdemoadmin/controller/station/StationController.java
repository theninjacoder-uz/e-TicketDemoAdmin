package uz.pdp.eticketdemoadmin.controller.station;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemoadmin.model.recieve.station.StationResponseDto;
import uz.pdp.eticketdemoadmin.model.recieve.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.response.station.StationReceiveDto;
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
        List<StationResponseDto> list = stationService.getList();
        model.addAttribute("stations", list);
        return "station";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute StationReceiveDto stationReceiveDto, Model model){

        boolean add = stationService.add(stationReceiveDto);
        if(add){
            model.addAttribute("countries",  addressService.getCountryList());
            List<StationResponseDto> list = stationService.getList();
            model.addAttribute("stations", list);
            return "redirect:/station";
        }

        return "500";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boolean delete = stationService.delete(id);
        if(delete)
            return "redirect:/station";
        else
            return "404";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("countries",  addressService.getCountryList());
        StationResponseDto station = stationService.getById(id);
        model.addAttribute("station", station);
        return "station-edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@RequestParam("id") Long id,  @ModelAttribute StationReceiveDto stationReceiveDto){
        boolean edit = stationService.edit(id, stationReceiveDto);

        return "redirect:/station";
    }}
