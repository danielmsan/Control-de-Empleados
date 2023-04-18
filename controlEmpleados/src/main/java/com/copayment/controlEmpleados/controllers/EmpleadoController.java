package com.copayment.controlEmpleados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.copayment.controlEmpleados.models.Empleado;
import com.copayment.controlEmpleados.services.EmpleadoServicio;



@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	 @Autowired
	    private EmpleadoServicio empleadoServicio;
	 	
	 	//HTTP GET
	    @GetMapping("")
	    public List<Empleado> leerEmpleados() {
	        return empleadoServicio.findAll();
	    }
	    //HTTP GET
	    @GetMapping("/{id}")
	    public Empleado leerEmpleado(@PathVariable Long id) {
	        return empleadoServicio.findById(id);
	    }
	    
	    //HTTP POST
	    @PostMapping("")
	    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
	        return empleadoServicio.save(empleado);
	    }
	    
	    //HTTP PUT
	    @PutMapping("/{id}")
	    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
	        Empleado empleadoExistente = empleadoServicio.findById(id);
	        if (empleadoExistente == null) {
	            return null;
	        }
	        empleadoExistente.setNombre(empleado.getNombre());
	        empleadoExistente.setApellido(empleado.getApellido());
	        empleadoExistente.setDepartamento(empleado.getDepartamento());
	        empleadoExistente.setSalario(empleado.getSalario());
	        return empleadoServicio.save(empleadoExistente);
	    }
	    
	    //HTTP DELETE
	    @DeleteMapping("/{id}")
	    public void borrarEmpleado(@PathVariable Long id) {
	        Empleado empleado = empleadoServicio.findById(id);
	        if (empleado != null) {
	            empleadoServicio.delete(empleado);
	        }
	    }
	
	
}
