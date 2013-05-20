package com.cibertec.dawi.proy.daos.interfaces.proyecto;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.proyecto.ProyectoDTO;

public interface ProyectoDAO {
	public void registraProy(SqlSession sqlSession, ProyectoDTO proy) throws Exception;
}
