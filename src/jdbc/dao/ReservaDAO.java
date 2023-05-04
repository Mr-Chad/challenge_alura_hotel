package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.controllers.HuespedesControllers;
import jdbc.modelo.Reserva;

public class ReservaDAO {
	private HuespedesControllers HuespedesControllers;
	private Connection con;
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Reserva reserva) {
		try {
			PreparedStatement stm;
			
			stm = con.prepareStatement("INSERT INTO RESERVAS (fecha_in, fecha_out, valor, forma_pago)"
					+ " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(stm) {
				stm.setDate(1, reserva.getFechaIn());
				stm.setDate(2, reserva.getFechaOut());
				stm.setString(3, reserva.getValor());
				stm.setString(4, reserva.getFormaPago());
				
				stm.executeUpdate();
				
				final ResultSet rst = stm.getGeneratedKeys();
				
				try (rst){
					while(rst.next()){
						 reserva.setId(rst.getInt(1));
					}
					
				}
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Reserva> listar(){
		List<Reserva> resultado = new ArrayList<>();
		
		try {
			final PreparedStatement stm = con.prepareStatement("SELECT ID_RESERVA, FECHA_IN, FECHA_OUT, VALOR, FORMA_PAGO FROM RESERVAS");
			
			try(stm){
				stm.execute();
				
				final ResultSet rst = stm.getResultSet();
				
				try(rst){
					while (rst.next()) {
						  resultado.add(new Reserva(
								rst.getInt(1),
								rst.getDate(2),
								rst.getDate(3),
								rst.getString(4),
								rst.getString(5)));
					}
				}
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int eliminar(Integer Id) {
		this.HuespedesControllers = new HuespedesControllers();
		HuespedesControllers.eliminar(Id);
		try {
			final PreparedStatement stm = con.prepareStatement("DELETE FROM RESERVAS WHERE ID_RESERVA = ?");
			try(stm){
				stm.setInt(1, Id);
				stm.executeUpdate();
				
				int updateCount = stm.getUpdateCount();
				
				return updateCount;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public int actualizarReserva(String idReserva, String fechaEntrada, String fechaSalida, String valor, String formaPago) {
	    try {
	        final PreparedStatement stm = con.prepareStatement("UPDATE RESERVAS SET "
	                + "fecha_in = ?,"
	                + "fecha_out = ?, "
	                + "VALOR = ?, "
	                + "forma_pago = ? "
	                + "WHERE id_reserva = ?");

	        stm.setString(1, fechaEntrada);
	        stm.setString(2, fechaSalida);
	        stm.setString(3, valor);
	        stm.setString(4, formaPago);
	        stm.setString(5, idReserva);

	        int lineasActualizadas = stm.executeUpdate();

	        return lineasActualizadas;

	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}}

