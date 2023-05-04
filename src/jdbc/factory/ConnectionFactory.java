package jdbc.factory;
	
import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;	
import java.sql.SQLException;

import javax.sql.DataSource;

	public class ConnectionFactory {
		
		private DataSource datasource;
		
		public ConnectionFactory() {
			var poolDataSource = new ComboPooledDataSource();
			poolDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel?useTimeZone=true&serverTimeZone=UTC");
			poolDataSource.setUser("root");
			poolDataSource.setPassword("324168");
			
			this.datasource = poolDataSource;
			
		}
		public Connection recuperarConexion() {
			try {
				return this.datasource.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
