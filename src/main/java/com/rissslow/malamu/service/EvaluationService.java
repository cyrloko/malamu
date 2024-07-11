package com.rissslow.malamu.service;

import com.rissslow.malamu.exception.DefaultException;
import com.rissslow.malamu.model.Evaluation;
import com.rissslow.malamu.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.rissslow.malamu.exception.DefaultError.ENTITY_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public Evaluation searchEvaluation(String id) throws DefaultException {
        return searchEvaluation(Evaluation.builder().id(id).build());
    }

    public Evaluation searchEvaluation(Evaluation evaluation) throws DefaultException {

        Optional<Evaluation> optEvaluation = evaluationRepository.findById(evaluation.id());


        return optEvaluation.orElseThrow(ENTITY_NOT_FOUND::getException);
    }

    public Evaluation saveEvaluation(Evaluation evaluation) throws DefaultException{

        if(!Objects.isNull(evaluation.id())) throw new DefaultException(400, "The id must not be provided");

        return evaluationRepository.insert(evaluation.toBuilder()
                .id(calculateId(evaluation))
                .build());
    }

    private static String calculateId(Evaluation evaluation) {
        return evaluation.id() == null ? String.valueOf(UUID.randomUUID()) : evaluation.id();
    }

    public List<Evaluation> saveEvaluation(List<Evaluation> evaluations){
        return evaluationRepository.insert(evaluations);
    }

    public Evaluation deleteEvaluation(Evaluation evaluation) throws DefaultException {

        Evaluation evaluationToDelete = searchEvaluation(evaluation);

        evaluationRepository.deleteById(evaluationToDelete.id());

        return evaluationToDelete;
    }

    public Evaluation updateEvaluation(Evaluation evaluation) throws DefaultException {

        Evaluation evaluationToUpdate = deleteEvaluation(evaluation);


        return saveEvaluation(
                Evaluation.builder()
                        .id(evaluationToUpdate.id())
                        .star(evaluation.star())
                        .description(evaluation.description())
                        .build());
    }

}

