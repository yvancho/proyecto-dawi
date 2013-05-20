package com.cibertec.dawi.proy.daos.mysql.solicitud;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;
import com.cibertec.dawi.proy.daos.interfaces.solicitud.SolicitudDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.solicitud.SolicitudMapper;

public class SolicitudMySqlDAO implements SolicitudDAO {

	@Override
	public void registrarSolicitud(SqlSession sqlSession, SolicitudDTO sol)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		solicitudMapper.registrarSolicitud(sol);
		sqlSession.commit();

	}

	@Override
	public int getAreaUsu(SqlSession sqlSession, String idUsu) throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		int area = solicitudMapper.getAreaUsu(idUsu);
		return area;
	}

	@Override
	public List<SolicitudDTO> listarSolicitudes(SqlSession sqlSession, int area)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		List<SolicitudDTO> lista = solicitudMapper.listarSolArea(area);
		return lista;
	}

	@Override
	public List<SolicitudDTO> listarSolEst(SqlSession sqlSession)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		List<SolicitudDTO> lista = solicitudMapper.listarSolEst();
		return lista;
	}

	@Override
	public String getSolicitudByPkDETAOBS(SqlSession sqlSession, int codSol)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		String observacion = solicitudMapper.getSolicitudByPkDETAOBS(codSol);
		return observacion;
	}

	@Override
	public String getSolicitudByPkDETASUS(SqlSession sqlSession, int codSol)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		String sus = solicitudMapper.getSolicitudByPkDETASUS(codSol);
		return sus;
	}

	@Override
	public String getRutaSolByPK(SqlSession sqlSession, int idSol)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		String ruta = solicitudMapper.getRutaSolByPK(idSol);
		return ruta;
	}

	@Override
	public void actualizaEstSol(SqlSession sqlSession, int idest, int idsol)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		solicitudMapper.actualizaEstSol(idest, idsol);
		sqlSession.commit();
	}

	@Override
	public int contarSolAprob(SqlSession sqlSession) throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		int num = solicitudMapper.contarSolAprob();
		return num;
	}

	@Override
	public SolicitudDTO getSolicitudByPK(SqlSession sqlSession, int idSol)
			throws Exception {
		SolicitudMapper solicitudMapper = sqlSession
				.getMapper(SolicitudMapper.class);
		SolicitudDTO bean = solicitudMapper.getSolicitudByPK(idSol);
		return bean;
	}

}
