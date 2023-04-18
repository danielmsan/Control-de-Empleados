package com.copayment.controlEmpleados.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "empleado")
	public class Empleado {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	    private Long id;
	    private String nombre;
	    private String apellido;
	    private String departamento;
	    private double salario;
	    
	    
		public Empleado() {
			super();
		}


		public Empleado(Long id, String nombre, String apellido, String departamento, double salario) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.departamento = departamento;
			this.salario = salario;
		}
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getDepartamento() {
			return departamento;
		}
		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}
		public double getSalario() {
			return salario;
		}
		public void setSalario(double salario) {
			this.salario = salario;
		}
	    
	    
	}

	
	

