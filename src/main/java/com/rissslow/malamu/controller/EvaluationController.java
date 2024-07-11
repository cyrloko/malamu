package com.rissslow.malamu.controller;

import com.rissslow.malamu.exception.DefaultException;
import com.rissslow.malamu.model.Evaluation;
import com.rissslow.malamu.service.EvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/evaluation")
public class EvaluationController {

    EvaluationService evaluationService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation getEvaluation(@PathVariable String id) throws DefaultException {
        return evaluationService.searchEvaluation(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation postEvaluation(@Validated @RequestBody Evaluation evaluation) throws DefaultException {
        return evaluationService.saveEvaluation(evaluation);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation putEvaluation(@Validated @RequestBody Evaluation evaluation) throws DefaultException {
        return evaluationService.updateEvaluation(evaluation);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Evaluation deleteEvaluation(@Validated @RequestBody Evaluation evaluation) throws DefaultException {
        return evaluationService.deleteEvaluation(evaluation);
    }

}
