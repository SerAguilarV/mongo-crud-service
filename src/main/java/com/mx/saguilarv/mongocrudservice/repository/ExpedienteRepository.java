package com.mx.saguilarv.mongocrudservice.repository;

import com.mx.saguilarv.mongocrudservice.models.ExpedienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteRepository extends MongoRepository<ExpedienteEntity, String> {
}
