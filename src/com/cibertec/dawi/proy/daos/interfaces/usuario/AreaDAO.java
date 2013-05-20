package com.cibertec.dawi.proy.daos.interfaces.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.AreaDTO;

public interface AreaDAO {
	
	public List<AreaDTO> listarAreas(SqlSession sqlSession) throws Exception;
}
