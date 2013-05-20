package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.TipoUsuarioDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.TipoUsuarioDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.TipoUsuarioMapper;

public class TipoUsuarioMySqlDAO implements TipoUsuarioDAO {

	@Override
	public List<TipoUsuarioDTO> listarTipoUsu(SqlSession sqlSession) throws Exception {

		TipoUsuarioMapper tipoUsuMapper= sqlSession
				.getMapper(TipoUsuarioMapper.class);
		
		List<TipoUsuarioDTO> lista= tipoUsuMapper.listarTipoUsu();
		
		return lista;
	}

}
