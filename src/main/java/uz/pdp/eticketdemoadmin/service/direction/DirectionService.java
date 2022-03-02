package uz.pdp.eticketdemoadmin.service.direction;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.recieve.direction.DirectionDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DirectionService {
    private final String BASE_URL = "http://127.0.0.1:8080/api/direction/";
    public final ObjectMapper objectMapper;
    public final RestTemplate restTemplate;

    public List<DirectionDto> getList() {
        ResponseEntity<ApiResponse> forEntity = restTemplate.getForEntity(BASE_URL + "list", ApiResponse.class);
        List<DirectionDto> directionList = (List<DirectionDto>) forEntity.getBody().getData();
        if (forEntity.getStatusCode() == HttpStatus.OK)
            return directionList;
        else return new ArrayList<>();
    }

    public boolean add(DirectionDto directionDto) {

        ApiResponse response = restTemplate.postForObject(BASE_URL + "add", directionDto, ApiResponse.class);

        assert response != null;
        return response.getStatusCode() == 1;
    }

    public boolean delete(Long id) {
//        Map<String, Long> mid = new HashMap<>();
//        mid.put("id", id);

//        ApiResponse response = restTemplate.execute(BASE_URL + "delete?="+id, HttpMethod.DELETE, );

        //TODO use restTemplate execute
//        restTemplate.delete(BASE_URL + "delete?=" + id, mid);

        ApiResponse response = restTemplate.getForObject(BASE_URL + "delete?id=" + id, ApiResponse.class);

        return response != null && response.getStatusCode() == 1;
    }

    public DirectionDto edit(Long id){
//        ApiResponse response = restTemplate.getForObject(BASE_URL + "get?id=" + id, ApiResponse.class);
//
//        DirectionDto receiveDto = objectMapper.convertValue(response.getData(), DirectionDto.class);
//
////        Object data = response.getData();
//
//        return receiveDto;
//
          return new DirectionDto();
    }

    public boolean edit(Long id, DirectionDto directionDto){
//        ApiResponse response = restTemplate.postForObject(BASE_URL + "get?id=" + id, directionDto, ApiResponse.class);
//        return response.getStatusCode() == 1 ? true : false;
        return false;
    }

}
