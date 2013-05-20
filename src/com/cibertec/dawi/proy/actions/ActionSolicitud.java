package com.cibertec.dawi.proy.actions;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;
import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;
import com.cibertec.dawi.proy.services.solicitud.GestionSolicitudBusinessDelegate;
import com.cibertec.dawi.proy.services.solicitud.SolicitudService;
import com.cibertec.dawi.proy.services.usuario.GestionMantenUsuarioBusinessDelegate;
import com.cibertec.dawi.proy.services.usuario.UsuarioService;
import com.cibertec.dawi.proy.util.Constantes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionSolicitud extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7542633537397460804L;

	// service
	private SolicitudService solService = GestionSolicitudBusinessDelegate
			.getSolicitudService();
	
	private UsuarioService usuarioService = GestionMantenUsuarioBusinessDelegate
			.getUsuarioService();
	

	private InputStream archivoIS;
	private List<SolicitudDTO> listaSol;
	private List<UsuarioDTO> listaUsu;
	private String codSol;
	private String detObsSol;
	private String detSusSol;
	private String estSol;
	private String nomFile;

	private String descAreaProy;

	// bean
	private SolicitudDTO solicitud;

	private File docusuario;
	private String docusuarioContentType;
	private String Nombredoc;

	// -------------------------------------

	public List<SolicitudDTO> getListaSol() {
		return listaSol;
	}

	public void setListaSol(List<SolicitudDTO> listaSol) {
		this.listaSol = listaSol;
	}

	public List<UsuarioDTO> getListaUsu() {
		return listaUsu;
	}

	public void setListaUsu(List<UsuarioDTO> listaUsu) {
		this.listaUsu = listaUsu;
	}

	public String getNombredoc() {
		return Nombredoc;
	}

	public void setNombredoc(String nombredoc) {
		Nombredoc = nombredoc;
	}

	public String getDocusuarioContentType() {
		return docusuarioContentType;
	}

	public void setDocusuarioContentType(String docusuarioContentType) {
		this.docusuarioContentType = docusuarioContentType;
	}

	public SolicitudDTO getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudDTO solicitud) {
		this.solicitud = solicitud;
	}

	public File getDocusuario() {

		return docusuario;
	}

	public void setDocusuario(File docusuario) {
		this.docusuario = docusuario;
	}

	public InputStream getArchivoIS() {
		return archivoIS;
	}

	public void setArchivoIS(InputStream archivoIS) {
		this.archivoIS = archivoIS;
	}

	/**
	 * @return the codSol
	 */
	public String getCodSol() {
		return codSol;
	}

	/**
	 * @param codSol
	 *            the codSol to set
	 */
	public void setCodSol(String codSol) {
		this.codSol = codSol;
	}

	public String getDetObsSol() {
		return detObsSol;
	}

	public void setDetObsSol(String detObsSol) {
		this.detObsSol = detObsSol;
	}

	public String getDetSusSol() {
		return detSusSol;
	}

	public void setDetSusSol(String detSusSol) {
		this.detSusSol = detSusSol;
	}

	public String getNomFile() {
		return nomFile;
	}

	public void setNomFile(String nomFile) {
		this.nomFile = nomFile;
	}

	public String getDescAreaProy() {
		return descAreaProy;
	}

	public void setDescAreaProy(String descAreaProy) {
		this.descAreaProy = descAreaProy;
	}

	public String getEstSol() {
		return estSol;
	}

	public void setEstSol(String estSol) {
		this.estSol = estSol;
	}

	public String registrarSolicitud() {
		String resultado = "";
		try {

			solService.registrarSolicitud(docusuario, solicitud);

			resultado = listarSolicitudes();

		} catch (Exception e) {
			addActionError(ERROR);
			// resultado = Constantes.JAREA_LOGIN;
			e.printStackTrace();

		}
		// return Constantes.JAREA_LOGIN;
		return resultado;
	}

	public String listarSolicitudes() throws Exception {
		listaSol = solService.listarSolicitudes();
		return Constantes.SOLICITUD_LISTA;
	}

	public String detalleObs() throws Exception {
		detObsSol = solService.getSolicitudByPkDETAOBS(codSol);
		return Constantes.SOLICITUD_DETALLEOBS;
	}

	public String detalleSus() throws Exception {
		detSusSol = solService.getSolicitudByPkDETASUS(codSol);
		return Constantes.SOLICITUD_DETALLE_SUS;
	}

	public String descargarSolicitud() throws Exception {

		archivoIS = (InputStream) solService.getRutaSolByPk(codSol).get(
				"archivo");
		nomFile = (String) solService.getRutaSolByPk(codSol).get("nombre");
		return Constantes.SOLICITUD_BAJADA;
	}

	public String aprobarSolicitud() throws Exception {
		int numSol = solService.contarSolAprob();

		if (estSol.equals("1") && numSol >= 2) {
			addActionError(Constantes.MENSAJE_NO_APROBAR_SOL);
			return Constantes.SOLICITUD_APROB_RELOAD;
		}

		solicitud = solService.getSolicitudByPK(codSol);
		
		listaUsu = usuarioService.listarDesAnsResp();
		Map<String, Object> app = ActionContext.getContext().getApplication();
		app.put("listaUsuResp", listaUsu);
		
		String resultado = solService.actualizaEstSol(estSol, codSol);

		return resultado;
	}

	public String cancelarRegistroProy() throws Exception {

		String resultado = solService.actualizaEstSol(0 + "", codSol);

		List<SolicitudDTO> listarSolEst = solService.listarSolEst();
		Map<String, Object> app = ActionContext.getContext().getApplication();
		app.put("listarSolEst", listarSolEst);

		return resultado;
	}

}
