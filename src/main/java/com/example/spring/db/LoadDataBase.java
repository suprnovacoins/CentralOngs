package com.example.spring.db;

import com.example.spring.entity.Ong;
import com.example.spring.repository.OngRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(OngRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Ong("Jorge","Monte Azul","Crianças e Adolescentes","11-5853.8080","R. Agatino de Esparta, 33","Chacara da Enseada-SP","Adolf Luther")));
        };
    }
}
