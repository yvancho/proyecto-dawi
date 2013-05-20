package com.cibertec.dawi.proy.daos.mysql.proyecto;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.proyecto.MonedaDTO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.MonedaDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.proyecto.MonedaMapper;

public class MonedaMySqlDAO implements MonedaDAO {

	@Override
	public List<MonedaDTO> listarMonedas(SqlSession sqlSession)
			throws Exception {
		MonedaMapper monmap = sqlSession.getMapper(MonedaMapper.class);
		List<MonedaDTO> lista = monmap.listarMonedas();
		return lista;
	}

}
