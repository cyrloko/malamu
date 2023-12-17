package com.rissslow.malamu.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Evaluation(UUID id, String description, Star star) {
}
