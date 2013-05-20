package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.GeneroDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.GeneroDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.GeneroMapper;

public class GeneroMySqlDAO implements GeneroDAO {

	@Override
	public List<GeneroDTO> listarGeneros(SqlSession sqlSession)
			throws Exception {

		GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);

		List<GeneroDTO> lista = generoMapper.listarGeneros();
		return lista;

	}

}
