package com.rissslow.malamu;

import com.rissslow.malamu.model.Entity;
import com.rissslow.malamu.model.Evaluation;
import com.rissslow.malamu.model.Star;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MalamuApplicationTests {


    public Entity anEntity(){
        return Entity.builder()
                .id(UUID.randomUUID())
                .name("ONE_ENTITY")
                .age(20)
                .evaluations(listOfStars())
                .build();
    }

    public List<Evaluation> listOfStars(){
        return List.of(
                Evaluation.builder()
                .star(Star.THREE)
                .description("Tout est ok un peu de retard")
                .build(),
                Evaluation.builder()
                        .star(Star.FIVE)
                        .description("Super")
                        .build(),
                Evaluation.builder()
                        .star(Star.MINUS_ONE)
                        .description("Rien ne va !!")
                        .build(),
                Evaluation.builder()
                        .star(Star.TWO)
                        .description("Nul")
                        .build(),
                Evaluation.builder()
                        .star(Star.ONE)
                        .description("Pas sérieux")
                        .build(),
                Evaluation.builder()
                        .star(Star.FOUR)
                        .description("Vraiment bien")
                        .build(),
                Evaluation.builder()
                        .star(Star.ZERO)
                        .description("")
                        .build()
        );
    }
    @Test
    void an_entity_should_have_three_evaluations() {

        //when
        Entity entity = anEntity();

        //then
        assertEquals(3,entity.evaluations().size(),"Evaluations should contains 3 elements");


    }

}
