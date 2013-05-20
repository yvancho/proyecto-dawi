package com.cibertec.dawi.proy.services.usuario;

public class GestionMantenUsuarioBusinessDelegate {

	public static UsuarioService getUsuarioService(){
		return new UsuarioServiceImpl();
	}
	
}
