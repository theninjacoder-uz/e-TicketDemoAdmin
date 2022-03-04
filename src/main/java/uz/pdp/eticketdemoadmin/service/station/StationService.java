package uz.pdp.eticketdemoadmin.service.station;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.recieve.address.AddressResponseDto;
import uz.pdp.eticketdemoadmin.model.recieve.station.StationResponseDto;
import uz.pdp.eticketdemoadmin.model.recieve.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;
import uz.pdp.eticketdemoadmin.response.station.StationReceiveDto;

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

    public List<StationResponseDto> getList() {
        ApiResponse response = restTemplate.getForObject(BASE_URL + "/list", ApiResponse.class);
        if (response.getStatusCode() == 1) {
            List<StationResponseDto> stationReceiveDtos = objectMapper.convertValue(response.getData(), new TypeReference<List<StationResponseDto>>() {
            });
            return stationReceiveDtos;
        } else return new ArrayList<>();
    }

    public boolean delete(Long id) {

        //TODO use restTemplate exec
        ApiResponse response = restTemplate.getForObject(BASE_URL + "/delete?id=" + id, ApiResponse.class);
        assert response != null;
        if (response.getStatusCode() == 1)
            return true;
        return false;
    }

    public StationResponseDto getById(Long id) {
        ApiResponse response = restTemplate.getForObject(BASE_URL + "/get?id=" + id, ApiResponse.class);
        assert response != null;
        return objectMapper.convertValue(response.getData(), StationResponseDto.class);
    }

    public boolean edit(Long id, StationReceiveDto stationReceiveDto) {
        ApiResponse response = restTemplate.postForObject(BASE_URL + "/get?id=" + id, stationReceiveDto, ApiResponse.class);
        assert response != null;
        return response.getStatusCode() == 1 ;
    }


}
