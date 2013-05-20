package com.cibertec.dawi.proy.daos.mysql.proyecto;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.proyecto.ProyectoDTO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.ProyectoDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.proyecto.ProyectoMapper;

public class ProyectoMySqlDAO implements ProyectoDAO {

	@Override
	public void registraProy(SqlSession sqlSession, ProyectoDTO proy)
			throws Exception {
		ProyectoMapper proyMapper = sqlSession.getMapper(ProyectoMapper.class);
		proyMapper.registraProy(proy);
		sqlSession.commit();
	}

}
