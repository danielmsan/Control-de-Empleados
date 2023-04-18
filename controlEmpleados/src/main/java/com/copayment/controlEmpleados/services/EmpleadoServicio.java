package com.copayment.controlEmpleados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copayment.controlEmpleados.models.Empleado;
import com.copayment.controlEmpleados.repositories.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {
	@Autowired
    private EmpleadoRepositorio empleadoRepositorio;
	
	//Metodos que llaman a la interface empleadoRepositorio la cual tiene metodos para interactuar con la Base de datos
	
	//Read
	//Este metodo utiliza findAll() para devolver todos los objetos de un tipo en forma de lista
    public List<Empleado> findAll() {
        return empleadoRepositorio.findAll();
    }
    
    //Create
    //Este metodo utiliza findById para buscar por el id del empleado
    public Empleado findById(Long id) {
        return empleadoRepositorio.findById(id).orElse(null);
    }
    
    //Update
    //Este metodo permite guardar un objeto del tipo empleado en la base de datos
    public Empleado save(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    //Delete
    //Permite borrar objetos del tipo empleado en la base de datos
    public void delete(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
