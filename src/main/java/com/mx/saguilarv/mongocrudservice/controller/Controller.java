package com.mx.saguilarv.mongocrudservice.controller;

import com.mx.saguilarv.mongocrudservice.models.ExpedienteEntity;
import com.mx.saguilarv.mongocrudservice.models.ExpedienteRequest;
import com.mx.saguilarv.mongocrudservice.service.ExpedientesService;
import com.mx.saguilarv.mongocrudservice.service.impl.ExpedienteServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("expediente")
public class Controller {

    @Autowired
    private ExpedientesService expedienteService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "200", description = "Expediente Encontrado")
    @ApiResponse(responseCode = "404", description = "Expediente no Encontrado")
    public ResponseEntity<ExpedienteEntity> getExpediente(@RequestParam(required = false) String id,
                                                          @RequestParam(required = false) String cliente){

        if(id == null && cliente == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingrese id o cliente.");
        } else if(id != null) {
            return new ResponseEntity<>(expedienteService.getExpedienteById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(expedienteService.getExpedienteByCliente(cliente), HttpStatus.OK);

    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "200", description = "Expediente Guardado")
    @ApiResponse(responseCode = "400", description = "Error en los datos del expediente a guardar")
    public ResponseEntity<ExpedienteEntity> saveExpediente(@Valid @RequestBody ExpedienteRequest expediente){

        return new ResponseEntity<>(expedienteService.saveExpediente(expediente), HttpStatus.OK);

    }

}
