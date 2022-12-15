package com.ricardoclaro.colegial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String nome;

    @OneToMany(targetEntity = Professor.class,cascade=CascadeType.REMOVE)
    private List professoreslista;

    @JsonIgnore
    @OneToMany(mappedBy = "materia",cascade=CascadeType.REMOVE)
    private List<AlunoMateria> alunos;

}
