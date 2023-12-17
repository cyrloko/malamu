package com.rissslow.malamu.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder(toBuilder = true)
@Document("entity")
public record Entity (@Id String id, String name, int age, List<Evaluation> evaluations){}
