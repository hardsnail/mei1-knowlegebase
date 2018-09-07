package com.mei1.knowlegebase.api.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 8799888504973100341L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}
