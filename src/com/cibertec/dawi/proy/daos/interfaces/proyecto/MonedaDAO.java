package com.cibertec.dawi.proy.daos.interfaces.proyecto;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.proyecto.MonedaDTO;

public interface MonedaDAO {
	public List<MonedaDTO> listarMonedas(SqlSession sqlSession)
			throws Exception;
}
