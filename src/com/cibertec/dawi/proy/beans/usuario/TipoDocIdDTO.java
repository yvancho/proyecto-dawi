package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class TipoDocIdDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833640647989387127L;

	private int idTipoDoc;
	private String descTipoDoc;

	public int getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(int idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getDescTipoDoc() {
		return descTipoDoc;
	}

	public void setDescTipoDoc(String descTipoDoc) {
		this.descTipoDoc = descTipoDoc;
	}

}
