package jdbc.modelo;

import java.sql.Date;

public class Huesped {
	private String nombre;
	private String apellido;
	private Date nacimiento;
	private String nacionalidad;
	private String telefono;
	private int idReserva;
	
	public Huesped(String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Huesped(String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono, Integer idReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
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
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
		
}
