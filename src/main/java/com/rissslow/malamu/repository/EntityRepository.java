package com.rissslow.malamu.repository;

import com.rissslow.malamu.model.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntityRepository extends MongoRepository<Entity, String> {

    List<Entity> findEntitiesByName(String name);

}
