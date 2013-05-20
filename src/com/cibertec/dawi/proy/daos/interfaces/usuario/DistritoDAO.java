package com.cibertec.dawi.proy.daos.interfaces.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.DistritoDTO;

public interface DistritoDAO {

	public List<DistritoDTO> listarDist(SqlSession sqlSession) throws Exception;
}
