package com.rissslow.malamu.service;

import com.rissslow.malamu.exception.DatabaseSearchException;
import com.rissslow.malamu.model.Evaluation;
import com.rissslow.malamu.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EvaluationService {

    @Autowired
    EvaluationRepository evaluationRepository;

    public Evaluation searchEvaluation(String id) throws DatabaseSearchException {
        return searchEvaluation(Evaluation.builder().id(id).build());
    }

    public Evaluation searchEvaluation(Evaluation evaluation) throws DatabaseSearchException {

        Optional<Evaluation> optEvaluation = evaluationRepository.findById(evaluation.id());

        return optEvaluation.orElseThrow(DatabaseSearchException::new);
    }

    public Evaluation saveEvaluation(Evaluation evaluation){

        return evaluationRepository.insert(evaluation.toBuilder()
                .id(calculateId(evaluation))
                .build()
        );
    }

    private static String calculateId(Evaluation evaluation) {
        return evaluation.id() == null ? String.valueOf(UUID.randomUUID()) : evaluation.id();
    }

    public List<Evaluation> saveEvaluation(List<Evaluation> evaluations){
        return evaluationRepository.insert(evaluations);
    }

    public Evaluation deleteEvaluation(Evaluation evaluation) throws DatabaseSearchException {

        Evaluation evaluationToDelete = searchEvaluation(evaluation);

        evaluationRepository.deleteById(evaluationToDelete.id());

        return evaluationToDelete;
    }

    public Evaluation updateEvaluation(Evaluation evaluation) throws DatabaseSearchException {

        Evaluation evaluationToUpdate = deleteEvaluation(evaluation);


        return saveEvaluation(
                Evaluation.builder()
                        .id(evaluationToUpdate.id())
                        .star(evaluation.star())
                        .description(evaluation.description())
                        .build())
                ;
    }

}
