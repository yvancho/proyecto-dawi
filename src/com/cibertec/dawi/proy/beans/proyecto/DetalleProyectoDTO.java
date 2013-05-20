package com.cibertec.dawi.proy.beans.proyecto;

import java.io.Serializable;
import java.util.Date;

import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;

public class DetalleProyectoDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3680518901374786033L;
	
	private UsuarioDTO usuario;
	private ProyectoDTO proyecto;
	private MonedaDTO moneda;
	private double costoProy;
	private Date fecIniProy;
	private Date fecFinProy;

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public ProyectoDTO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDTO proyecto) {
		this.proyecto = proyecto;
	}

	public MonedaDTO getMoneda() {
		return moneda;
	}

	public void setMoneda(MonedaDTO moneda) {
		this.moneda = moneda;
	}

	public double getCostoProy() {
		return costoProy;
	}

	public void setCostoProy(double costoProy) {
		this.costoProy = costoProy;
	}

	public Date getFecIniProy() {
		return fecIniProy;
	}

	public void setFecIniProy(Date fecIniProy) {
		this.fecIniProy = fecIniProy;
	}

	public Date getFecFinProy() {
		return fecFinProy;
	}

	public void setFecFinProy(Date fecFinProy) {
		this.fecFinProy = fecFinProy;
	}

}
