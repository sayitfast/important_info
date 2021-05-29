package com.sayitfast.important_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Important_Info {

    public static void main(String[] args) {
        SpringApplication.run(Important_Info.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new com.sayitfast.important_info.SpringSecurityAuditorAware();
    }

}
