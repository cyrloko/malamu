package com.rissslow.malamu;

import com.rissslow.malamu.model.Entity;
import com.rissslow.malamu.model.Evaluation;
import com.rissslow.malamu.model.Star;
import com.rissslow.malamu.repository.EntityRepository;
import com.rissslow.malamu.repository.EvaluationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.*;
import java.util.stream.*;

@SpringBootApplication
@EnableMongoRepositories
@RequiredArgsConstructor
public class MalamuApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(MalamuApplication.class);

    @NonNull
    EntityRepository entityRepository;

    @NonNull
    EvaluationRepository evaluationRepository;

    void testCreationEntityDB(){
        logger.info("*********Data creation started*********");



        entityRepository.insert(Entity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .age(29)
                .name("Jim")
                .evaluations(
                        evaluationRepository.insert(List.of(
                                Evaluation.builder()
                                        .id(String.valueOf(UUID.randomUUID()))
                                        .star(Star.FIVE)
                                        .description("Parfait")
                                        .build(),
                                Evaluation.builder()
                                        .id(String.valueOf(UUID.randomUUID()))
                                        .star(Star.FIVE)
                                        .description("Parfait")
                                        .build()
                        ))
                )
                .build());

        logger.info("*********Data creation complete*********");

    }

    void testReadEntityDB(){
        logger.info("*********Data read started*********");

        List<Entity> entities = entityRepository.findEntitiesByName("Jim");

        Stream.of(entities)
                .forEach(entity -> logger.info(String.valueOf(entity)));

        logger.info("*********Data read complete*********");

    }

    public static void main(String[] args) {
        SpringApplication.run(MalamuApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //testCreationEntityDB();
        testReadEntityDB();
    }
}
