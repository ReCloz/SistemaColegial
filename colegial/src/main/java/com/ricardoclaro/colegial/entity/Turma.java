package com.ricardoclaro.colegial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String classe;

    @OneToMany(targetEntity = Aluno.class,cascade=CascadeType.REMOVE)
    private List alunoslista;

    @ManyToMany(targetEntity=Professor.class)
    @JoinColumn(name = "professor", referencedColumnName = "cpf")
    private Set professorSet;


}

