package com.dh.mascotas.controller;


import com.dh.mascotas.persistence.entities.Movimiento;
import com.dh.mascotas.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final EjemploService service;

    @Autowired
    public MovimientoController(EjemploService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<String> crear(@RequestBody Movimiento movimiento){
        ResponseEntity<String> respuesta;

        if(Objects.nonNull(service.save(movimiento))){
            respuesta = ResponseEntity.ok("El movimiento fue registrado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Mmmm... me parece que algo salió mal...");
        }
        return respuesta;
    }

    @GetMapping()
    public ResponseEntity<List<Movimiento>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }
}
