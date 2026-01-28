package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.infra.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    /**
     * Configura as regras de segurança HTTP para a aplicação.
     * @param http
     * @return
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        try{
            http.csrf(csrf -> csrf.disable())
                    .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                    .authorizeHttpRequests(auth -> auth.requestMatchers(
                                    "/api/v1/users/**",
                                    "/h2-console/**"
                            ).permitAll().anyRequest().authenticated()
                    );
            return http.build();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
