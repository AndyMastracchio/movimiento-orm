package com.dh.mascotas.service;

import com.dh.mascotas.persistence.entities.Movimiento;
import com.dh.mascotas.persistence.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemploService {

    private final MovimientoRepository repository;

    @Autowired
    public EjemploService(MovimientoRepository repository) {
        this.repository = repository;
    }

    public String save(Movimiento m){
        repository.save(m);
        return "OK";
    }

    public List<Movimiento> obtenerTodos(){
        return repository.findAll();
    }

}
