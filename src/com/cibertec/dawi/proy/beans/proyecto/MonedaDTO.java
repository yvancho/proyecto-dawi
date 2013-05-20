package com.cibertec.dawi.proy.beans.proyecto;

import java.io.Serializable;

public class MonedaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8502377814348407008L;

	private String idMoneda;
	private String descMoneda;
	private String simbMoneda;

	public String getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(String idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getDescMoneda() {
		return descMoneda;
	}

	public void setDescMoneda(String descMoneda) {
		this.descMoneda = descMoneda;
	}

	public String getSimbMoneda() {
		return simbMoneda;
	}

	public void setSimbMoneda(String simbMoneda) {
		this.simbMoneda = simbMoneda;
	}

}
