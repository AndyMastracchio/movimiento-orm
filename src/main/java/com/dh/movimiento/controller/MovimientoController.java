package com.dh.movimiento.controller;


import com.dh.movimiento.persistence.entities.Movimiento;
import com.dh.movimiento.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService service;

    @Autowired
    public MovimientoController(MovimientoService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<String> crear(@RequestBody Movimiento movimiento) {
        ResponseEntity<String> respuesta;

        if (Objects.nonNull(service.save(movimiento))) {
            respuesta = ResponseEntity.ok("El movimiento fue registrado con éxito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("Mmmm... me parece que algo salió mal...");
        }
        return respuesta;
    }

    @GetMapping()
    public ResponseEntity<List<Movimiento>> consultarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }
}
