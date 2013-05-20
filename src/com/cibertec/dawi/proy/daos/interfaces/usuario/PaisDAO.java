package com.cibertec.dawi.proy.daos.interfaces.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.PaisDTO;

public interface PaisDAO {
	
	public List<PaisDTO> listaPaises(SqlSession sqlSession) throws Exception; 
	
}
