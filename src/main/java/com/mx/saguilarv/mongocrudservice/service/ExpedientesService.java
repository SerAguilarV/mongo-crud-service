package com.mx.saguilarv.mongocrudservice.service;

import com.mx.saguilarv.mongocrudservice.models.ExpedienteEntity;

public interface ExpedientesService {

    public ExpedienteEntity getExpedienteById(String expediente);

    public ExpedienteEntity getExpedienteByCliente(String expediente);


}
