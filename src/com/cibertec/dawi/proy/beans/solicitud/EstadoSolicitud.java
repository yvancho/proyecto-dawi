package com.cibertec.dawi.proy.beans.solicitud;

import java.io.Serializable;

public class EstadoSolicitud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8392879841700339378L;
	
	private int idEstSol;
	private String descEstSol;
	
	public int getIdEstSol() {
		return idEstSol;
	}
	public void setIdEstSol(int idEstSol) {
		this.idEstSol = idEstSol;
	}
	public String getDescEstSol() {
		return descEstSol;
	}
	public void setDescEstSol(String descEstSol) {
		this.descEstSol = descEstSol;
	}
	
	

}
