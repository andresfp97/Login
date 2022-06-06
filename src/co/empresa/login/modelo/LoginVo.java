package co.empresa.login.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo implements Serializable {

		private Integer id;

		private String usuario;

		private String pas;

		public LoginVo( String usuario, String pas) {
			super();
			this.usuario = usuario;
			this.pas = pas;
		}


	
		


}
