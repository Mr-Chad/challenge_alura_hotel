package jdbc.controllers;

import java.sql.Date;
import java.util.List;
import jdbc.dao.HuespedDAO;
import jdbc.modelo.Huesped;
import jdbc.factory.ConnectionFactory;
public class HuespedesControllers {

		
	private HuespedDAO HuespedDAO ;
	
	public HuespedesControllers() {
		var fac = new ConnectionFactory();
		this.HuespedDAO = new HuespedDAO(fac.recuperarConexion());
	}
	
	public void guardar(Huesped huesped) {
		HuespedDAO.guardar(huesped);
	}
	
	public List<Huesped> listar(){
		return HuespedDAO.listar();
	}
	
	public int eliminar(Integer id) {
		return HuespedDAO.eliminar(id);
	}
	
	public int modificar(String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono, int idReserva) {
		return HuespedDAO.modificar(nombre, apellido, nacimiento, nacionalidad, telefono, idReserva);
	}
	
}
