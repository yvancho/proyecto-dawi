package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.AreaDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.AreaDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.AreaMapper;

public class AreaMySqlDAO implements AreaDAO {

	@Override
	public List<AreaDTO> listarAreas(SqlSession sqlSession) throws Exception {
		// TODO Auto-generated method stub
		
		AreaMapper areaMapper= sqlSession.getMapper(AreaMapper.class);
		List<AreaDTO> lista=areaMapper.listarAreas();
		
		return lista;
	}

}
