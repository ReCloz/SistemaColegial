package com.ricardoclaro.colegial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Column(unique=true)
    private String ra;

    @ManyToOne
    private Turma turmaSet;

    @OneToMany(mappedBy = "aluno",cascade=CascadeType.REMOVE)
    private List<AlunoMateria> materias;

    public void addNota(AlunoMateria alunoMateria){


        materias.add(alunoMateria);

    }

}

