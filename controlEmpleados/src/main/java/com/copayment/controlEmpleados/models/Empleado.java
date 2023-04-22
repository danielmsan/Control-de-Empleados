package com.copayment.controlEmpleados.models;


import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "empleado")
	public class Empleado {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	    private Long id;
	    private String nombre;
	    private String apellido;

	    @ManyToOne
	    @JoinColumn(name = "departamento_iddepartamento")
	    private Departamento departamento;
	    
	    private LocalDateTime horaEntrada;
	    private LocalDateTime horaSalida;
	    
	    
	    
		public Empleado() {
			super();
		}

		public Empleado(Long id, String nombre, String apellido, Departamento departamento, LocalDateTime horaEntrada,
				LocalDateTime horaSalida) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.departamento = departamento;
			this.horaEntrada = horaEntrada;
			this.horaSalida = horaSalida;
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

		public Departamento getDepartamento() {
			return departamento;
		}

		public void setDepartamento(Departamento departamento) {
			this.departamento = departamento;
		}

		public LocalDateTime getHoraEntrada() {
			return horaEntrada;
		}

		public void setHoraEntrada(LocalDateTime horaEntrada) {
			this.horaEntrada = horaEntrada;
		}

		public LocalDateTime getHoraSalida() {
			return horaSalida;
		}

		public void setHoraSalida(LocalDateTime horaSalida) {
			this.horaSalida = horaSalida;
		}
	    
		
	    
	}

	
	

