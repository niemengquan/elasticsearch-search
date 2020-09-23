package com.nmq.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "person")
public class Person implements Persistable<Long> {
    @Id
    private Long id;
    private String lastName;
    private String firstName;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date createdDate;
    private String createdBy;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date lastModifiedDate;
    private String lastModifiedBy;

    @Override
    public Long getId() {                                                 
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null || (createdDate == null && createdBy == null);  
    }
}