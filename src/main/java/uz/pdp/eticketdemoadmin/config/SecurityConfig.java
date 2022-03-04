//package uz.pdp.eticketdemoadmin.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    private final AuthService authService;
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////            auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails userOne = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("root"))
//                .roles("SUPER_ADMIN")
//                .build();
//        UserDetails userTwo = User.builder()
//                .username("user1")
//                .password(passwordEncoder().encode("root"))
//                .roles("SUPER_ADMIN")
//                .build();
//
//        UserDetails userThree = User.builder()
//                .username("user2")
//                .password(passwordEncoder().encode("root"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                userOne, userTwo, userThree
//        );
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/passenger").permitAll()
//                .antMatchers("/train/**").hasAnyRole("SUPER_ADMIN", "ADMIN")
//                .antMatchers( "/direction").hasRole("USER")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .defaultSuccessUrl("/");
//
////                .and()
////                .logout()
////                .logoutUrl("/login").permitAll()
////                .deleteCookies("JSESSIONID");
//    }
//}
