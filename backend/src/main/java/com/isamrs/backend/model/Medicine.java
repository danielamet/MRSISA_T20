package com.isamrs.backend.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medicine")
public class Medicine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
