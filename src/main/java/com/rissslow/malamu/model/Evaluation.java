package com.rissslow.malamu.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document("evaluation")
public record Evaluation(@Id String id,String description, Star star) {}
