package com.dh.movimiento.service;

import com.dh.movimiento.persistence.entities.Movimiento;
import com.dh.movimiento.persistence.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository repository;

    @Autowired
    public MovimientoService(MovimientoRepository repository) {
        this.repository = repository;
    }

    public String save(Movimiento movimiento) {
        repository.save(movimiento);
        return "OK";
    }

    public List<Movimiento> obtenerTodos() {
        return repository.findAll();
    }

}
