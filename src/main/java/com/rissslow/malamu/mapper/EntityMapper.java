package com.rissslow.malamu.mapper;

import com.rissslow.malamu.dto.EntityDTO;
import com.rissslow.malamu.model.Entity;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    EntityDTO toDTO(Entity entity);

    Entity toModel(EntityDTO entityDTO);

}
