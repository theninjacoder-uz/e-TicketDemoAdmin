package uz.pdp.eticketdemoadmin.service.train;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TrainService {
    private String BASE_URL = "http://127.0.0.1:8080/api/train/";
    public final ObjectMapper objectMapper;
    public final RestTemplate restTemplate;
}
