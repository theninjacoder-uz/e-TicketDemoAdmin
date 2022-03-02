package uz.pdp.eticketdemoadmin.service.address;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.recieve.address.CountryReceiveDto;
import uz.pdp.eticketdemoadmin.model.recieve.address.RegionReceiveDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private String BASE_URL = "http://localhost:8080/api/";

    public List<CountryReceiveDto> getCountryList() {
        ApiResponse response = restTemplate.getForObject(BASE_URL + "country/list", ApiResponse.class);
        ArrayList<CountryReceiveDto> countryReceiveDtos = objectMapper.convertValue(response.getData(), new TypeReference<ArrayList<CountryReceiveDto>>() {
        });
        return countryReceiveDtos;
    }

    public List<RegionReceiveDto> getRegionList() {
        ApiResponse response = restTemplate.getForObject(BASE_URL + "region/list", ApiResponse.class);
        ArrayList<RegionReceiveDto> regionReceiveDtos = objectMapper.convertValue(response.getData(), new TypeReference<ArrayList<RegionReceiveDto>>() {
        });
        return regionReceiveDtos;
    }
}
