package com.copayment.controlEmpleados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.copayment.controlEmpleados.models.Empleado;

//Interface que extiende de la clase JPA para traer metodos que interactuan con el CRUD de la base de datos

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long>{

	 @Query("SELECT d.sueldo FROM Empleado e JOIN e.departamento d WHERE e.id = :idEmpleado")
	    Double findSueldoById(@Param("idEmpleado") Long idEmpleado);

}
