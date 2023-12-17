package com.rissslow.malamu.model;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record Entity (UUID id, String name, int age, List<Evaluation> evaluations){
}
