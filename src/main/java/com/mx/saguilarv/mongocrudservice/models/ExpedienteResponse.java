package com.mx.saguilarv.mongocrudservice.models;

import org.springframework.data.annotation.Id;

public class ExpedienteResponse {

    @Id
    private String id;

    private String cliente;

    private String empresa;

}
