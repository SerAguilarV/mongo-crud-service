package com.mx.saguilarv.mongocrudservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@Generated
@Document(collection = "Expedientes")
public class ExpedienteEntity {

    @Id
    @Indexed
    private String id;

    @Indexed
    private String cliente;

    private String empresa;

    private Date createdAt;

    private Date updateAt;

}
