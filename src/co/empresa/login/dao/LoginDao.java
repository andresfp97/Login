package co.empresa.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.empresa.login.modelo.LoginVo;
import co.empresa.login.util.ConexionPostgres;

public class LoginDao {

private ConexionPostgres conexion;

	
	private static final String SELECT_USUARIO_BY_USERNAME = "SELECT * FROM users WHERE username = ?;";
	
	
	
	
	public LoginDao() {
		this.conexion = ConexionPostgres.getConexion();
	}

	
    public Boolean login(LoginVo i) {
        try {
           
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USUARIO_BY_USERNAME);
            
            preparedStatement.setString(1, i.getUsuario());
            
            ResultSet rs = conexion.query();

            if (rs.next()) {

                if (i.getPas().equals(rs.getString("pass"))) {
                    
                    return true;
                } else {
                	
                    return false;
                }
            }

            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
	
	
}

