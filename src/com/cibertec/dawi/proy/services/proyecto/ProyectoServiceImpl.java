package com.cibertec.dawi.proy.services.proyecto;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.proyecto.MonedaDTO;
import com.cibertec.dawi.proy.beans.proyecto.PrioridadProyectoDTO;
import com.cibertec.dawi.proy.beans.proyecto.ProyectoDTO;
import com.cibertec.dawi.proy.daos.factory.DAOFactory;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.MonedaDAO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.PrioridadProyectoDAO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.ProyectoDAO;
import com.cibertec.dawi.proy.daos.mybatis.SessionFactory;

public class ProyectoServiceImpl implements ProyectoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProyectoDAO proyDAO = fabrica.getProyectoDAO();
	MonedaDAO monDao = fabrica.getMonedaDAO();
	PrioridadProyectoDAO prioDAO = fabrica.getPrioridadProyectoDAO();

	@Override
	public void registraProy(ProyectoDTO proy) throws Exception {

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();

		proyDAO.registraProy(sqlSession, proy);
		sqlSession.close();
	}

	@Override
	public List<MonedaDTO> listarMonedas() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<MonedaDTO> lista = monDao.listarMonedas(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<PrioridadProyectoDTO> listarPrioridad() throws Exception {
		
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<PrioridadProyectoDTO> lista = prioDAO.listarPrioridad(sqlSession);
		sqlSession.close();
		return lista;
	}
}
