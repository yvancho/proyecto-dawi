package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class AreaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3799768263194913899L;

	private int idArea;
	private String descArea;

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getDescArea() {
		return descArea;
	}

	public void setDescArea(String descArea) {
		this.descArea = descArea;
	}

}
