//package pe.upc.edu.bibflipbackend.shared.infrastructure.security.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // Desactiva CSRF
//                .csrf(csrf -> csrf.disable())
//
//                // Desactiva el login por formulario de Spring Security
//                .formLogin(form -> form.disable())
//
//                // Desactiva Basic Auth
//                .httpBasic(basic -> basic.disable())
//
//                // Permite todo en este microservicio
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll()
//                );
//
//        return http.build();
//    }
//}