//package uz.pdp.eticketdemoadmin.service.auth;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import uz.pdp.eticketdemoadmin.response.ApiResponse;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService implements UserDetailsService {
//
//    private final RestTemplate restTemplate;
//    private String BASE_URL = "http://127.0.0.1:8080/api/user/";
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ApiResponse response = restTemplate.getForObject(BASE_URL + username, ApiResponse.class);
//        assert response != null;
//        return (UserDetails) response.getData();
//    }
//}
