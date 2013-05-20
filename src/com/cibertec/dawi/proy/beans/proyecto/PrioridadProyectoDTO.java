package com.cibertec.dawi.proy.beans.proyecto;

import java.io.Serializable;

public class PrioridadProyectoDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -676273098111762810L;
	
	private int idPrioProy;
	private String descPrioProy;

	public int getIdPrioProy() {
		return idPrioProy;
	}

	public void setIdPrioProy(int idPrioProy) {
		this.idPrioProy = idPrioProy;
	}

	public String getDescPrioProy() {
		return descPrioProy;
	}

	public void setDescPrioProy(String descPrioProy) {
		this.descPrioProy = descPrioProy;
	}

}
