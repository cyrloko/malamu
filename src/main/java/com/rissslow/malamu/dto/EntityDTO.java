package com.rissslow.malamu.dto;

import lombok.Builder;

import java.util.*;

@Builder(toBuilder = true)
public record EntityDTO ( String id, String name, int age, List<EvaluationDTO> evaluations){}

