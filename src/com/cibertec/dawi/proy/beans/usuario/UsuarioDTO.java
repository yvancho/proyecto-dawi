package com.cibertec.dawi.proy.beans.usuario;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9114251595377850881L;

	private int idNumUsu;
	private String idUsu;
	private String clave;
	private String email;
	private TipoDocIdDTO tipoDoc;
	private String nroDocID;
	private String nomUsu;
	private String apeUsu;
	private GeneroDTO genero;
	private PaisDTO pais;
	private DistritoDTO distrito;
	private String direUsu;
	private Date fecNac;
	private EstadoCivilDTO estadoCivil;
	private String telefono;
	private AreaDTO area;
	private TipoUsuarioDTO tipoUsu;
	private Date fecContrato;
	private int esResponsable;
	private EstadoUsuarioDTO estadoUsu;

	public int getIdNumUsu() {
		return idNumUsu;
	}

	public void setIdNumUsu(int idNumUsu) {
		this.idNumUsu = idNumUsu;
	}

	public String getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(String idusu) {
		this.idUsu = idusu;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoDocIdDTO getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocIdDTO tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDocID() {
		return nroDocID;
	}

	public void setNroDocID(String nroDocID) {
		this.nroDocID = nroDocID;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getApeUsu() {
		return apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public GeneroDTO getGenero() {
		return genero;
	}

	public void setGenero(GeneroDTO genero) {
		this.genero = genero;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public DistritoDTO getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoDTO distrito) {
		this.distrito = distrito;
	}

	public String getDireUsu() {
		return direUsu;
	}

	public void setDireUsu(String direUsu) {
		this.direUsu = direUsu;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public EstadoCivilDTO getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilDTO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoUsuarioDTO getTipoUsu() {
		return tipoUsu;
	}

	public void setTipoUsu(TipoUsuarioDTO tipoUsu) {
		this.tipoUsu = tipoUsu;
	}

	public AreaDTO getArea() {
		return area;
	}

	public void setArea(AreaDTO area) {
		this.area = area;
	}

	public Date getFecContrato() {
		return fecContrato;
	}

	public void setFecContrato(Date fecIng) {
		this.fecContrato = fecIng;
	}

	public int getEsResponsable() {
		return esResponsable;
	}

	public void setEsResponsable(int esResponsable) {
		this.esResponsable = esResponsable;
	}

	public EstadoUsuarioDTO getEstadoUsu() {
		return estadoUsu;
	}

	public void setEstadoUsu(EstadoUsuarioDTO estadoUsu) {
		this.estadoUsu = estadoUsu;
	}

}
