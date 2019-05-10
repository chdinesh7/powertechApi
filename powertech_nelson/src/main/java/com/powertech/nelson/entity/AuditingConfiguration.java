package com.powertech.nelson.entity;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/**
 *
 * @author javadevcorner.com
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfiguration {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
    
    class AuditorAwareImpl implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("dinesh");
            //If you´re working with the security context here is the place 
            //where you call your context and get the user
        }
        
    }
}