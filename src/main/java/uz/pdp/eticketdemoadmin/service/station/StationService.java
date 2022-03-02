package uz.pdp.eticketdemoadmin.service.station;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.recieve.station.StationReceiveDto;
import uz.pdp.eticketdemoadmin.model.recieve.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StationService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private String BASE_URL = "http://localhost:8080/api/station";
    public boolean add(StationReceiveDto stationReceiveDto){
        ApiResponse response = restTemplate.postForObject(BASE_URL + "/add", stationReceiveDto, ApiResponse.class);
        if(response.getStatusCode()==1)
            return true;
        return false;
    }

    public List<StationReceiveDto> getList() {
        ApiResponse response = restTemplate.getForObject(BASE_URL + "/list", ApiResponse.class);
        if (response.getStatusCode() == 1) {
            List<StationReceiveDto> stationReceiveDtos = objectMapper.convertValue(response.getData(), new TypeReference<List<StationReceiveDto>>() {
            });
            return stationReceiveDtos;
        } else return new ArrayList<>();
    }


}
