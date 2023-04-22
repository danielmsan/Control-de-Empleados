package com.copayment.controlEmpleados.services;

import java.time.Duration;
import java.time.LocalDateTime;
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
    
    //Read
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
    //Calcula las horas trabajadas del empleado
    public double calcularHorasTrabajadas(Long id) {
        Empleado empleado = empleadoRepositorio.findById(id).orElseThrow();
        LocalDateTime horaEntrada = empleado.getHoraEntrada();
        LocalDateTime horaSalida = empleado.getHoraSalida();
        
        Duration duracionTrabajo = Duration.between(horaEntrada.toLocalTime(), horaSalida.toLocalTime());
        return duracionTrabajo.toMinutes() / 60.0;
    }

	public double calcularSueldoDiario(Long id) {
		double horasTrabajadas = calcularHorasTrabajadas(id);
		double sueldoPorHora = obtenerSueldoPorHora(id);
		return horasTrabajadas * sueldoPorHora;
	}

	  public double obtenerSueldoPorHora(Long id) {
	        return empleadoRepositorio.findSueldoById(id);

	  }
}
