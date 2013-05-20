package com.cibertec.dawi.proy.beans.proyecto;

import java.io.Serializable;

public class EstadoProyectoDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5704169821020815014L;
	
	
	private int idEstProy;
	private String descEstProy;

	public int getIdEstProy() {
		return idEstProy;
	}

	public void setIdEstProy(int idEstProy) {
		this.idEstProy = idEstProy;
	}

	public String getDescEstProy() {
		return descEstProy;
	}

	public void setDescEstProy(String descEstProy) {
		this.descEstProy = descEstProy;
	}

}
