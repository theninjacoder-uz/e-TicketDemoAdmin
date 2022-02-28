package uz.pdp.eticketdemoadmin.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.recieve.UserReceiveDto;

@Service
@RequiredArgsConstructor
public class UserService {

    private String BASE_URL = "http://127.0.0.1:8080/api/user/";
    public final ObjectMapper objectMapper;
    public final RestTemplate restTemplate;

    public boolean login(UserReceiveDto userReceiveDto){
        String response = restTemplate.postForObject( BASE_URL+ "login", userReceiveDto, String.class);
        try {
            Boolean resp = objectMapper.readValue(response, Boolean.class);
            return resp;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public List<UserDto>
}
