package jdbc.modelo;

import java.sql.Date;

public class Reserva {
	private int id;
	private Date fechaIn;
	private Date fechaOut;
	private String valor;
	private String formaPago;
	
	public Reserva(Date fechaIn, Date fechaOut, String valor, String formaPago) {
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reserva(Integer id, Date fechaIn, Date fechaOut, String valor, String formaPago) {
		this.id = id;
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Date getFechaIn() {
		return fechaIn;
	}
	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}
	public Date getFechaOut() {
		return fechaOut;
	}
	public void setFechaOut(Date fechaOut) {
		this.fechaOut = fechaOut;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	}
