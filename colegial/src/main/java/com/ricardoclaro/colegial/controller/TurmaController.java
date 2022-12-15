package com.ricardoclaro.colegial.controller;


import com.ricardoclaro.colegial.entity.Turma;
import com.ricardoclaro.colegial.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping(path = "/turma")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class TurmaController {


    @Autowired
    private TurmaRepository turmaRep;

    @PostMapping(path = "/add")
    public @ResponseBody String addTurma(@RequestParam String nome) {
        Turma turma = new Turma();
        turma.setClasse(nome);

        try{
            turmaRep.save(turma);
        }catch (Exception e){
            Logger.error("TurmaSaveError: ", e);
            return "Error ";
        }

        Logger.info("Turma Salva "+nome);
        return "Saved";
    }


    @GetMapping(path = "/read")
    public @ResponseBody ResponseEntity<List<Turma>> readTurma(@RequestParam String nome) {
        Logger.info("Turma Listada "+nome);
        return new ResponseEntity(turmaRep.findByClasse(nome), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Turma> getAllTurmas() {

        Logger.info("Turmas Listadas ");
        return turmaRep.findAll();
    }


    @PostMapping(path = "/remove")
    @Transactional
    public ResponseEntity<String> deleteTurma(@RequestParam String nome) {

        try{
            turmaRep.deleteTurmaByClasse(nome);
        }catch (Exception e){
            Logger.error("TurmaDeleteError: ", e);
            return ResponseEntity.ok("Error ");
        }

        Logger.info("Turma removida "+nome);
        return ResponseEntity.ok("Deleted");

    }


}
