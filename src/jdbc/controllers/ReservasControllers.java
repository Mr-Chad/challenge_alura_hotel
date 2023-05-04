package jdbc.controllers;

import java.util.List;

import jdbc.dao.ReservaDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reserva;

public class ReservasControllers {

		private ReservaDAO ReservaDAO;
		
		public ReservasControllers() {
			var fac = new ConnectionFactory();
			this.ReservaDAO = new ReservaDAO(fac.recuperarConexion());
		}
		
		public void guardar(Reserva Reserva) {
			ReservaDAO.guardar(Reserva);
		}
		
		public List<Reserva> listar(){
			return ReservaDAO.listar();
		}
		
		public int eliminar(Integer id) {
			return ReservaDAO.eliminar(id);
		}
		
		public int actualizarReserva(String fechaIn, String fechaOut, String valor, String id, String formaPago) {
			return ReservaDAO.actualizarReserva(fechaIn, fechaOut, valor, id , formaPago);
		}
}
