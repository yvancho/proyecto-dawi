package com.cibertec.dawi.proy.daos.interfaces.solicitud;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;

public interface SolicitudDAO {
	// registrar una solicitud de requerimientos
	public void registrarSolicitud(SqlSession sqlSession, SolicitudDTO sol)
			throws Exception;

	// obtener el area de trabajo del usuario en sesion que registra un SRQ
	public int getAreaUsu(SqlSession sqlSession, String idUsu) throws Exception;

	// obtener una solicitud x su pk
	public SolicitudDTO getSolicitudByPK(SqlSession sqlSession, int idSol)
			throws Exception;

	// listar solicitudes
	public List<SolicitudDTO> listarSolicitudes(SqlSession sqlSession, int area)
			throws Exception;

	// listar solicitudes por estado
	public List<SolicitudDTO> listarSolEst(SqlSession sqlSession)
			throws Exception;

	// obtener campo observacion
	public String getSolicitudByPkDETAOBS(SqlSession sqlSession, int codSol)
			throws Exception;

	// obtener campo Sustento
	public String getSolicitudByPkDETASUS(SqlSession sqlSession, int codSol)
			throws Exception;

	// obtener la ruta de un archivo
	public String getRutaSolByPK(SqlSession sqlSession, int idSol)
			throws Exception;

	// contar las solicitudes aprobadas
	public int contarSolAprob(SqlSession sqlSession) throws Exception;

	// actualizacion de estado
	public void actualizaEstSol(SqlSession sqlSession, int idest, int idsol)
			throws Exception;
}
