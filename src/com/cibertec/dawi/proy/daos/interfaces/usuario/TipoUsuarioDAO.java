package com.cibertec.dawi.proy.daos.interfaces.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.TipoUsuarioDTO;

public interface TipoUsuarioDAO {

	public List<TipoUsuarioDTO> listarTipoUsu(SqlSession sqlSession)
			throws Exception;

}
