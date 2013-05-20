package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class EstadoUsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4474499379775038843L;
	
	private int idEstUsu;
	private String descEstUsu;
	
	public void setIdEstUsu(int idEstUsu) {
		this.idEstUsu = idEstUsu;
	}
	public int getIdEstUsu() {
		return idEstUsu;
	}
	public void setDescEstUsu(String descEstUsu) {
		this.descEstUsu = descEstUsu;
	}
	public String getDescEstUsu() {
		return descEstUsu;
	}

}
