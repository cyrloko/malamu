package com.rissslow.malamu.mapper;

import com.rissslow.malamu.dto.EvaluationDTO;
import com.rissslow.malamu.model.Evaluation;
import org.mapstruct.Mapper;

@Mapper
public interface EvaluationMapper  {

    EvaluationDTO toDTO(Evaluation evaluation);

    Evaluation toModel(EvaluationDTO evaluationDTO);
}
