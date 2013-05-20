package com.cibertec.dawi.proy.actions;

import com.cibertec.dawi.proy.beans.proyecto.DetalleProyectoDTO;
import com.cibertec.dawi.proy.beans.proyecto.ProyectoDTO;
import com.cibertec.dawi.proy.services.proyecto.GestionProyectoBusinessDelegate;
import com.cibertec.dawi.proy.services.proyecto.ProyectoService;
import com.opensymphony.xwork2.ActionSupport;

public class ActionProyecto extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6152138691776836445L;

	// service
	private ProyectoService proyService = GestionProyectoBusinessDelegate
			.getProyectoService();

	private String codSolp;
	private ProyectoDTO proyecto;
	private DetalleProyectoDTO detaProyecto;

	public ProyectoDTO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDTO proyecto) {
		this.proyecto = proyecto;
	}

	public DetalleProyectoDTO getDetaProyecto() {
		return detaProyecto;
	}

	public void setDetaProyecto(DetalleProyectoDTO detaProyecto) {
		this.detaProyecto = detaProyecto;
	}

	public String getCodSolp() {
		return codSolp;
	}

	public void setCodSolp(String codSolp) {
		this.codSolp = codSolp;
	}

	public String registraProy() throws Exception {
		proyService.registraProy(proyecto);	
		return SUCCESS;
	}

}
