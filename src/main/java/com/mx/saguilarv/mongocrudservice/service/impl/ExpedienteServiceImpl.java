package com.mx.saguilarv.mongocrudservice.service.impl;

import com.mx.saguilarv.mongocrudservice.models.ExpedienteEntity;
import com.mx.saguilarv.mongocrudservice.models.ExpedienteRequest;
import com.mx.saguilarv.mongocrudservice.repository.ExpedienteRepository;
import com.mx.saguilarv.mongocrudservice.service.ExpedientesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ExpedienteServiceImpl implements ExpedientesService {

    @Autowired
    private ExpedienteRepository expedienteRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ExpedienteEntity getExpedienteById(String expediente) {
        Optional<ExpedienteEntity> exp =  expedienteRepository.findById(expediente);
        if (exp.isEmpty())
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Expediente " + expediente + " no encontrado."
            );
        return exp.get();
    }

    @Override
    public ExpedienteEntity getExpedienteByCliente(String cliente) {
        List<ExpedienteEntity> exp = expedienteRepository.findByCliente(cliente);
        if(exp.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Expediente " + cliente + " ya existe."
            );
        return exp.get(0);
    }

    @Override
    public ExpedienteEntity saveExpediente(ExpedienteRequest expediente) {
        if(!expedienteRepository.findByCliente(expediente.getCliente()).isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Expediente " + expediente.getCliente() + " ya existe."
            );
        ExpedienteEntity expedienteToCreate = new ExpedienteEntity();
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.map(expediente, expedienteToCreate);
        mapper.getConfiguration().setSkipNullEnabled(false);
        return expedienteRepository.save(expedienteToCreate);
    }

}
