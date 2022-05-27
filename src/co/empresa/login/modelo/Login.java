package co.empresa.login.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login implements Serializable {

	
	

		private Integer id;

		private String usuario;

		private String pas;

		public Login( String usuario, String pas) {
			super();
			this.usuario = usuario;
			this.pas = pas;
		}


	
		


}
