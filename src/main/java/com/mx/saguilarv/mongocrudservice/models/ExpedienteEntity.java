package com.mx.saguilarv.mongocrudservice.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString

@Generated
@Document(collection = "Expedientes")
public class ExpedienteEntity {

    @Id
    @Indexed
    private String id;

    @Indexed
    private String cliente;

    private String empresa;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updateAt;

}
