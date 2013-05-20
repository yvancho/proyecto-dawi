package com.cibertec.dawi.proy.daos.mysql.proyecto;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.proyecto.PrioridadProyectoDTO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.PrioridadProyectoDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.proyecto.PrioridadProyectoMapper;

public class PrioridadProyectoMySqlDAO implements PrioridadProyectoDAO {

	@Override
	public List<PrioridadProyectoDTO> listarPrioridad(SqlSession sqlSession)
			throws Exception {
		PrioridadProyectoMapper prioMapper = sqlSession
				.getMapper(PrioridadProyectoMapper.class);
		List<PrioridadProyectoDTO> lista = prioMapper.listarPrioridad();
		return lista;
	}

}
