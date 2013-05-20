package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.PaisDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.PaisDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.PaisMapper;

public class PaisMySqlDAO implements PaisDAO {

	
	@Override
	public List<PaisDTO> listaPaises(SqlSession sqlSession) throws Exception {

		PaisMapper paisMapper= sqlSession.getMapper(PaisMapper.class);
		List<PaisDTO> lista=paisMapper.listarPaises();

		return lista;
	}

}
