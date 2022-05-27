package co.empresa.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.empresa.login.modelo.Login;
import co.empresa.login.util.ConexionPostgreSQL;

public class LoginDao {

private ConexionPostgreSQL conexion;
	
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM users WHERE id = ?;";
	
	
	
	
	public LoginDao() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}

	
	
	public Login select(int id) {
		Login usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String user = rs.getString("usuario");
				String pas = rs.getString("email");
				
				usuario = new Login (id, user, pas);
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuario;
		
	}

	
}

