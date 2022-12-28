package com.mx.saguilarv.mongocrudservice.service.impl;

import com.mx.saguilarv.mongocrudservice.models.ExpedienteEntity;
import com.mx.saguilarv.mongocrudservice.repository.ExpedienteRepository;
import com.mx.saguilarv.mongocrudservice.service.ExpedientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ExpedienteServiceImpl implements ExpedientesService {

    @Autowired
    private ExpedienteRepository expedienteRepository;

    @Override
    public ExpedienteEntity getExpedienteById(String expediente) {
        expedienteRepository.findById(expediente);
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Expediente " + expediente + " no encontrado."
        );
    }

    @Override
    public ExpedienteEntity getExpedienteByCliente(String expediente) {
        return null;
    }

}
