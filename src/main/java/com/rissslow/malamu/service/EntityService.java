package com.rissslow.malamu.service;

import com.rissslow.malamu.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    @Autowired
    EntityRepository entityRepository;



}
