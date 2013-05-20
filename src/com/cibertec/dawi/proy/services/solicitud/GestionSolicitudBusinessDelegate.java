package com.cibertec.dawi.proy.services.solicitud;

public class GestionSolicitudBusinessDelegate {

	public static SolicitudService getSolicitudService(){
		return new  SolicitudServiceImpl();
	}
}
