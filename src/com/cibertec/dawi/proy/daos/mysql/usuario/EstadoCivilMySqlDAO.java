package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.EstadoCivilDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.EstadoCivilDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.EstadoCivilMapper;

public class EstadoCivilMySqlDAO implements EstadoCivilDAO {

	@Override
	public List<EstadoCivilDTO> listarEstCiv(SqlSession sqlSession)
			throws Exception {

		EstadoCivilMapper estCivMapper = sqlSession
				.getMapper(EstadoCivilMapper.class);
		List<EstadoCivilDTO> lista = estCivMapper.listarEstCiv();
		return lista;
	}

}
