package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class GeneroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7358223949538309386L;

	private String idGen;
	private String descGen;

	public String getDescGen() {
		return descGen;
	}

	public void setDescGen(String descGen) {
		this.descGen = descGen;
	}

	public String getIdGen() {
		return idGen;
	}

	public void setIdGen(String idGen) {
		this.idGen = idGen;
	}

}
