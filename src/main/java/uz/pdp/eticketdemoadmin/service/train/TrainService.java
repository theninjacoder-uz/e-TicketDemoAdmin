package uz.pdp.eticketdemoadmin.service.train;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.receive.train.TrainReceiveDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private String BASE_URL = "http://127.0.0.1:8080/api/train/";
    public final ObjectMapper objectMapper;
    public final RestTemplate restTemplate;

    public List<TrainReceiveDto> getList() {
        ResponseEntity<ApiResponse> forEntity = restTemplate.getForEntity(BASE_URL + "list", ApiResponse.class);
        List<TrainReceiveDto> trainList = (List<TrainReceiveDto>) forEntity.getBody().getData();
        if (forEntity.getStatusCode() == HttpStatus.OK)
            return trainList;
        else return new ArrayList<>();
    }

    public boolean add(TrainReceiveDto trainReceiveDto) {
        trainReceiveDto.setAvailableSeatNumber(trainReceiveDto.getCapacity());

        ApiResponse response = restTemplate.postForObject(BASE_URL + "add", trainReceiveDto, ApiResponse.class);

        if (response.getStatusCode() == 1)
            return true;

        return false;
    }
}
