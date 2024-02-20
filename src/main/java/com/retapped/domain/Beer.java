package com.retapped.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "beers")
public class Beer {

    @Id
    private int id;

    private float abv;

    private String name;

    private String type;

    private int ibu;

    private String brewer;
}
