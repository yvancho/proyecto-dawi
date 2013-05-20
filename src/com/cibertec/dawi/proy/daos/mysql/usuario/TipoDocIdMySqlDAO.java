package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.TipoDocIdDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.TipoDocIdDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.TipoDocIdMapper;

public class TipoDocIdMySqlDAO implements TipoDocIdDAO {

	@Override
	public List<TipoDocIdDTO> listarTipoDocId(SqlSession sqlSession)
			throws Exception {

		TipoDocIdMapper tipoDocMapper = sqlSession
				.getMapper(TipoDocIdMapper.class);

		List<TipoDocIdDTO> lista = tipoDocMapper.listarTipoDocId();

		return lista;
	}

}
