package kmichalski.tanksCompetition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfigBasicAuth {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return
                http.csrf(AbstractHttpConfigurer::disable)
                        .cors(withDefaults())
                        .authorizeHttpRequests(registry -> {
                            registry.requestMatchers("/games").authenticated();
                            registry.requestMatchers("/games_public").permitAll();
                            registry.requestMatchers("/register-new-user").permitAll();
                            registry.requestMatchers("/update-game/{gameId}").authenticated();
                        }).
                        httpBasic(withDefaults()).build();
    }
}
