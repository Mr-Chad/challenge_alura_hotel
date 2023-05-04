package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Huesped;

public class HuespedDAO {
private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huesped huesped) {
		try {
			PreparedStatement stm;
			
			stm = con.prepareStatement("INSERT INTO HUESPEDES (NOMBRE, APELLIDO, NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA)"
					+ " VALUES (?, ?, ?, ?, ?, ?)");
			
			try(stm) {
				stm.setString(1, huesped.getNombre());
				stm.setString(2, huesped.getApellido());
				stm.setDate(3, huesped.getNacimiento());
				stm.setString(4, huesped.getNacionalidad());
				stm.setString(5, huesped.getTelefono());
				stm.setInt(6, huesped.getIdReserva());
				
				stm.executeUpdate();
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Huesped> listar(){
		List<Huesped> resultado = new ArrayList<>();
		
		try {
			final PreparedStatement stm = con.prepareStatement("SELECT NOMBRE, APELLIDO, NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM HUESPEDES");
			
			try(stm){
				stm.execute();
				
				final ResultSet rst = stm.getResultSet();
				
				try(rst){
					while (rst.next()) {
						 resultado.add(new Huesped(
								rst.getString(1),
								rst.getString(2),
								rst.getDate(3),
								rst.getString(4),
								rst.getString(5),
								rst.getInt(6)));
					}
				}
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int eliminar(Integer idReserva) {
		try {
			final PreparedStatement stm = con.prepareStatement("DELETE FROM HUESPEDES WHERE ID_RESERVA = ?");
			try(stm){
				stm.setInt(1, idReserva);
				stm.executeUpdate();
				
				int updateCount = stm.getUpdateCount();
				
				return updateCount;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public int modificar(String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono, int idReserva ) {
		try {
			final PreparedStatement stm = con.prepareStatement("UPDATE HUESPEDES SET "
					+ "nombre = ?,"
					+ "apellido = ?,"
					+ "nacimiento = ?,"
					+ "nacionalidad = ?,"
					+ "TELEFONO = ?"
					+ "WHERE ID_reserva = ?");
					
			
			try(stm){
				stm.setString(1, nombre);
				stm.setString(2, apellido);
				stm.setDate(3,nacimiento);
				stm.setString(4, nacionalidad);
				stm.setString(5, telefono);
				stm.setInt(6, idReserva);
				
				int listaActualizada = stm.executeUpdate();
				
				return listaActualizada;
				
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
