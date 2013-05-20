package com.cibertec.dawi.proy.daos.interfaces.proyecto;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.proyecto.PrioridadProyectoDTO;

public interface PrioridadProyectoDAO {
	public List<PrioridadProyectoDTO> listarPrioridad(SqlSession sqlSession)
			throws Exception;
}
