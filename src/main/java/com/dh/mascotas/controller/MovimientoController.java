package com.dh.mascotas.controller;


import com.dh.mascotas.persistence.entities.Movimiento;
import com.dh.mascotas.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    EjemploService service;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Movimiento movimiento){
        ResponseEntity<String> respuesta;

        if(service.save(movimiento) != null){
            respuesta = ResponseEntity.ok("El movimiento fue registrado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Mmmm... me parece que algo salió mal...");
        }
        return respuesta;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Movimiento>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }
}
