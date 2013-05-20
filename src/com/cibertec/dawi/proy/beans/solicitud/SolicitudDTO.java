package com.cibertec.dawi.proy.beans.solicitud;

import java.io.Serializable;
import java.util.Date;

import com.cibertec.dawi.proy.beans.usuario.AreaDTO;

public class SolicitudDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5426792707076639137L;

	private int idSol;
	private String descSol;
	private String obsSol;
	private String susDes;
	private String urlSol;
	private AreaDTO area;
	private String idUsu;
	private Date fecRegSol;
	private EstadoSolicitud estSol;

	public SolicitudDTO() {

	}

	public int getIdSol() {
		return idSol;
	}

	public void setIdSol(int idSol) {
		this.idSol = idSol;
	}

	/**
	 * @return the descSol
	 */
	public String getDescSol() {
		return descSol;
	}

	/**
	 * @param descSol
	 *            the descSol to set
	 */
	public void setDescSol(String descSol) {
		this.descSol = descSol;
	}

	/**
	 * @return the obsSol
	 */
	public String getObsSol() {
		return obsSol;
	}

	/**
	 * @param obsSol
	 *            the obsSol to set
	 */
	public void setObsSol(String obsSol) {
		this.obsSol = obsSol;
	}

	public String getSusDes() {
		return susDes;
	}

	public void setSusDes(String susDes) {
		this.susDes = susDes;
	}

	public String getUrlSol() {
		return urlSol;
	}

	public void setUrlSol(String urlSol) {
		this.urlSol = urlSol;
	}

	public AreaDTO getArea() {
		return area;
	}

	public void setArea(AreaDTO area) {
		this.area = area;
	}

	public String getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(String idUsu) {
		this.idUsu = idUsu;
	}

	public Date getFecRegSol() {
		return fecRegSol;
	}

	public void setFecRegSol(Date fecRegSol) {
		this.fecRegSol = fecRegSol;
	}

	public EstadoSolicitud getEstSol() {
		return estSol;
	}

	public void setEstSol(EstadoSolicitud estSol) {
		this.estSol = estSol;
	}

}
