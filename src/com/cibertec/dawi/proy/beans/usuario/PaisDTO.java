package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class PaisDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 991853337982922745L;

	private String idPais;
	private String descPais;

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getDescPais() {
		return descPais;
	}

	public void setDescPais(String descPais) {
		this.descPais = descPais;
	}

}
