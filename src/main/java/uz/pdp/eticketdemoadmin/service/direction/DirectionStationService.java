package uz.pdp.eticketdemoadmin.service.direction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.recieve.direction.DirectionDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectionStationService {

    public final RestTemplate restTemplate;
    private String BASE_URL = "http://127.0.0.1:8080/api/direction-station/";
    public final ObjectMapper objectMapper;

    public List<DirectionDto> getList(){
        ApiResponse response = restTemplate.getForObject(BASE_URL + "routes", ApiResponse.class);

        return objectMapper.convertValue(response.getData(), new TypeReference<List<DirectionDto>>() {
        });
    }
}
