package com.rissslow.malamu.repository;

import com.rissslow.malamu.model.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EvaluationRepository extends MongoRepository<Evaluation, String> {
}
