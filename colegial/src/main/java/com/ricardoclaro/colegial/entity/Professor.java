package com.ricardoclaro.colegial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Column(unique=true)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia  materia;

    @ManyToMany(targetEntity = Turma.class)
    private Set turmaSet;


    public void addTurmas(List<Turma> turmas){
        turmaSet.addAll(turmas);

    }
}
