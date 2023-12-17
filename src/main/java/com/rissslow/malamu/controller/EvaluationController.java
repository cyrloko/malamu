package com.rissslow.malamu.controller;

import com.rissslow.malamu.exception.DatabaseSearchException;
import com.rissslow.malamu.model.Evaluation;
import com.rissslow.malamu.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation getEvaluation(@PathVariable String id) throws DatabaseSearchException {
        return evaluationService.searchEvaluation(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation postEvaluation(@Validated @RequestBody Evaluation evaluation){
        return evaluationService.saveEvaluation(evaluation);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation putEvaluation(@Validated @RequestBody Evaluation evaluation) throws DatabaseSearchException {
        return evaluationService.updateEvaluation(evaluation);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation deleteEvaluation(@Validated @RequestBody Evaluation evaluation) throws DatabaseSearchException {
        return evaluationService.deleteEvaluation(evaluation);
    }

}
