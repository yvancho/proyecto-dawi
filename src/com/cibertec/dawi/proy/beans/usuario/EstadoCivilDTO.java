package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class EstadoCivilDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4203460819096723202L;

	private String idEstCiv;
	private String descEstCiv;

	public String getDescEstCiv() {
		return descEstCiv;
	}

	public void setDescEstCiv(String descEstCiv) {
		this.descEstCiv = descEstCiv;
	}

	public String getIdEstCiv() {
		return idEstCiv;
	}

	public void setIdEstCiv(String idEstCiv) {
		this.idEstCiv = idEstCiv;
	}

}
