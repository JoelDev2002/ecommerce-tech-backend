package pe.edu.idat.webtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // todas las rutas de todos los controllers
                        .allowedOrigins("http://localhost:5173") // tu frontend React
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // los métodos que usarás
                        .allowedHeaders("*"); // permitir todos los headers
            }
        };
    }
}
