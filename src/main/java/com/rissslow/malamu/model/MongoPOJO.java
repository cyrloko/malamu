package com.rissslow.malamu.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class MongoPOJO <T> {

    @Id
    String id = UUID.randomUUID().toString();

    T entity;
}
