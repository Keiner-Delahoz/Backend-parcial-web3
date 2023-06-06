package com.parcialweb.Controller;

import com.parcialweb.Model.Consulta;
import com.parcialweb.Service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@CrossOrigin
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> getAll(){
        List<Consulta> listConsultas = consultaService.getConsultas();
        if (listConsultas == null || listConsultas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(listConsultas);
        }
    }

    @GetMapping("/{consultaId}")
    public ResponseEntity<Consulta> getStudentById(@PathVariable Long consultaId){
        try {
            Consulta consulta = consultaService.getConsultaById(consultaId);
            return ResponseEntity.ok(consulta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Consulta consulta){
        consultaService.create(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{consultaId}")
    public ResponseEntity delete(@PathVariable("consultaId") Long consultaId){
        try {
            consultaService.delete(consultaId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
