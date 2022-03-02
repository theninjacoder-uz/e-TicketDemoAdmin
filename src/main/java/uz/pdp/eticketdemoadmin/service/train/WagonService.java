package uz.pdp.eticketdemoadmin.service.train;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.recieve.train.WagonReceiveDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WagonService {
    private final String BASE_URL = "http://127.0.0.1:8080/api/wagon/";
    public final ObjectMapper objectMapper;
    public final RestTemplate restTemplate;

    public List<WagonReceiveDto> getList() {
        ResponseEntity<ApiResponse> forEntity = restTemplate.getForEntity(BASE_URL + "list", ApiResponse.class);
        List<WagonReceiveDto> wagonList = (List<WagonReceiveDto>) forEntity.getBody().getData();
        if (forEntity.getStatusCode() == HttpStatus.OK)
            return wagonList;
        else return new ArrayList<>();
    }

    public boolean add(WagonReceiveDto wagonDto) {

        ApiResponse response = restTemplate.postForObject(BASE_URL + "add", wagonDto, ApiResponse.class);

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

    public WagonReceiveDto edit(Long id){
//        ApiResponse response = restTemplate.getForObject(BASE_URL + "get?id=" + id, ApiResponse.class);
//
//        WagonReceiveDto receiveDto = objectMapper.convertValue(response.getData(), WagonReceiveDto.class);
//
////        Object data = response.getData();
//
//        return receiveDto;
//
        return new WagonReceiveDto();
    }

    public boolean edit(Long id, WagonReceiveDto wagonDto){
//        ApiResponse response = restTemplate.postForObject(BASE_URL + "get?id=" + id, wagonDto, ApiResponse.class);
//        return response.getStatusCode() == 1 ? true : false;
        return false;
    }
}
