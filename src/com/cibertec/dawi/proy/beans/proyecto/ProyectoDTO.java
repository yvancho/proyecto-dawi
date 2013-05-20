package com.cibertec.dawi.proy.beans.proyecto;

import java.io.Serializable;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;

public class ProyectoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5962769358139153574L;

	private String idProy;
	private String descProy;
	private String obsProy;
	private SolicitudDTO solicitud;
	private PrioridadProyectoDTO prioridad;
	private EstadoProyectoDTO estadoProy;

	public String getIdProy() {
		return idProy;
	}

	public void setIdProy(String idProy) {
		this.idProy = idProy;
	}

	public String getDescProy() {
		return descProy;
	}

	public void setDescProy(String descProy) {
		this.descProy = descProy;
	}

	public String getObsProy() {
		return obsProy;
	}

	public void setObsProy(String obsProy) {
		this.obsProy = obsProy;
	}

	public SolicitudDTO getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudDTO solicitud) {
		this.solicitud = solicitud;
	}

	public PrioridadProyectoDTO getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadProyectoDTO prioridad) {
		this.prioridad = prioridad;
	}

	public EstadoProyectoDTO getEstadoProy() {
		return estadoProy;
	}

	public void setEstadoProy(EstadoProyectoDTO estadoProy) {
		this.estadoProy = estadoProy;
	}

}
