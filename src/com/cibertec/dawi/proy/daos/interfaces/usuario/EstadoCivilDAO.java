package com.cibertec.dawi.proy.daos.interfaces.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.EstadoCivilDTO;

public interface EstadoCivilDAO {
	
	List<EstadoCivilDTO> listarEstCiv(SqlSession sqlSession) throws Exception;
	
}
