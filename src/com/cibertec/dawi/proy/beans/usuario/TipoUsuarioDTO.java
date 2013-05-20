package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;

public class TipoUsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5871289807563381687L;

	private String idTipoUsu;
	private String descTipoUsu;

	public String getIdTipoUsu() {
		return idTipoUsu;
	}

	public void setIdTipoUsu(String idTipoUsu) {
		this.idTipoUsu = idTipoUsu;
	}

	public String getDescTipoUsu() {
		return descTipoUsu;
	}

	public void setDescTipoUsu(String descTipoUsu) {
		this.descTipoUsu = descTipoUsu;
	}

}
