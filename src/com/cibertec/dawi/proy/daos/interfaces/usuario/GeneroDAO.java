package com.cibertec.dawi.proy.daos.interfaces.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.GeneroDTO;

public interface GeneroDAO {

	public List<GeneroDTO> listarGeneros(SqlSession sqlSession) throws Exception;
}
