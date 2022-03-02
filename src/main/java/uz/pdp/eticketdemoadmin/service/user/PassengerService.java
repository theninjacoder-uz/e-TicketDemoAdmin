package uz.pdp.eticketdemoadmin.service.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.receive.user.PassengerResponseDto;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private String BASE_URL = "http://127.0.0.1:8080/api/passenger/";
    public final ObjectMapper objectMapper;
    public final RestTemplate restTemplate;

    public List<PassengerResponseDto> getList() {
        ApiResponse forObject = restTemplate.getForObject(BASE_URL + "list", ApiResponse.class);

        assert forObject != null;
        if (forObject.getStatusCode() == 1)
            return (List<PassengerResponseDto>) forObject.getData();

        return List.of(new PassengerResponseDto());
    }

}
