package com.mx.saguilarv.mongocrudservice.service;

import com.mx.saguilarv.mongocrudservice.models.ExpedienteEntity;
import com.mx.saguilarv.mongocrudservice.models.ExpedienteRequest;

public interface ExpedientesService {

    public ExpedienteEntity getExpedienteById(String expediente);

    public ExpedienteEntity getExpedienteByCliente(String expediente);

    public ExpedienteEntity saveExpediente(ExpedienteRequest expediente);


}
