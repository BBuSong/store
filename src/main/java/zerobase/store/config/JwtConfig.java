package zerobase.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zerobase.domain.config.JwtAuthenticationProvider;

@Configuration
public class JwtConfig {
    @Bean
    public JwtAuthenticationProvider jwtAuthenticationProvider() {
        return new JwtAuthenticationProvider();
    }
}
