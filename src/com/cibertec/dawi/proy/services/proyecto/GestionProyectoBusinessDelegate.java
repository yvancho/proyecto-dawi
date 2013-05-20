package com.cibertec.dawi.proy.services.proyecto;

public class GestionProyectoBusinessDelegate {

	public static ProyectoService getProyectoService() {
		return new ProyectoServiceImpl();
	}

}
