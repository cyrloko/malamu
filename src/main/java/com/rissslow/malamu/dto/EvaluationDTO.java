package com.rissslow.malamu.dto;

import com.rissslow.malamu.model.Star;
import lombok.Builder;

@Builder(toBuilder = true)
public record EvaluationDTO (String id, String description, Star star) {
}
