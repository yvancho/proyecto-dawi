package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class DistritoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8167748226311499840L;

	private int idDist;
	private String descDist;

	public int getIdDist() {
		return idDist;
	}

	public void setIdDist(int idDist) {
		this.idDist = idDist;
	}

	public String getDescDist() {
		return descDist;
	}

	public void setDescDist(String descDist) {
		this.descDist = descDist;
	}

}
