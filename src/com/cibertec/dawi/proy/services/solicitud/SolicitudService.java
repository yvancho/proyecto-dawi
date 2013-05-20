package com.cibertec.dawi.proy.services.solicitud;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;

public interface SolicitudService {

	public void registrarSolicitud(File doc, SolicitudDTO sol) throws Exception;

	public int getAreaUsu(String idUsu) throws Exception;

	public List<SolicitudDTO> listarSolicitudes() throws Exception;
	
	public List<SolicitudDTO> listarSolEst() throws Exception;

	public String getSolicitudByPkDETAOBS(String idSol) throws Exception;
	
	public String getSolicitudByPkDETASUS(String idSol) throws Exception;

	public FileInputStream getRutaSolByPK(String idSol) throws Exception;
	
	public Map<Object, Object> getRutaSolByPk(String idSol) throws Exception;
	
	public int contarSolAprob() throws Exception;
	
	public String actualizaEstSol(String idest, String idsol) throws Exception;
	
	// obtener una Solicitud por su pk
	public SolicitudDTO getSolicitudByPK(String idSol) throws Exception;
}
