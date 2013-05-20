package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.DistritoDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.DistritoDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.DistritoMapper;

public class DistritoMySqlDAO implements DistritoDAO {

	@Override
	public List<DistritoDTO> listarDist(SqlSession sqlSession) throws Exception {

		DistritoMapper distritoMapper = sqlSession
				.getMapper(DistritoMapper.class);
		List<DistritoDTO> lista = distritoMapper.listarDist();

		return lista;
	}

}
