package com.cibertec.dawi.proy.daos.mysql.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.UsuarioDAO;
import com.cibertec.dawi.proy.daos.mybatis.mappers.usuario.UsuarioMapper;

public class UsuarioMySqlDAO implements UsuarioDAO {

	@Override
	public UsuarioDTO validarUsuario(SqlSession sqlSession, UsuarioDTO usuario)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);

		int usu = usuarioMapper.validarUsuario(usuario);
		sqlSession.close();

		if (usu == 0)
			return null;

		return usuario;

	}

	@Override
	public void registrarUsuario(SqlSession sqlSession, UsuarioDTO usu)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		usuarioMapper.registrarUsuario(usu);
		sqlSession.commit();

	}

	@Override
	public void actualizarUsuario(SqlSession sqlSession, UsuarioDTO usu)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		usuarioMapper.actualizarUsuario(usu);
		sqlSession.commit();

	}

	@Override
	public void actEstadoUsuario(SqlSession sqlSession, UsuarioDTO usu)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		usuarioMapper.actEstadoUsuario(usu);
		sqlSession.commit();

	}

	@Override
	public void eliminarUsuaio(SqlSession sqlSession, UsuarioDTO usu)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		usuarioMapper.eliminarUsuaio(usu);
		sqlSession.commit();

	}

	@Override
	public UsuarioDTO getUsuSes(SqlSession sqlSession, String idUsu)
			throws Exception {
		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		UsuarioDTO usu = usuarioMapper.getUsuSes(idUsu);
		return usu;
	}

	@Override
	public UsuarioDTO getUsuarioByPK(SqlSession sqlSession, int idUsu)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		UsuarioDTO usu = usuarioMapper.getUsuarioByPK(idUsu);

		return usu;
	}

	@Override
	public UsuarioDTO getUsuarioByPkDETALLE(SqlSession sqlSession, int idUsu)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		UsuarioDTO bean = usuarioMapper.getUsuarioByPkDETALLE(idUsu);
		return bean;
	}

	@Override
	public List<UsuarioDTO> listarUsuarios(SqlSession sqlSession)
			throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		List<UsuarioDTO> lista = usuarioMapper.listarUsuarios();

		return lista;

	}

	@Override
	public List<UsuarioDTO> listarUsuariosByNom(SqlSession sqlSession,
			String filtro) throws Exception {

		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		List<UsuarioDTO> lista = usuarioMapper.listarUsuariosByNom(filtro);

		return lista;

	}

	@Override
	public List<UsuarioDTO> listarDesAnsResp(SqlSession sqlSession)
			throws Exception {
		UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
		List<UsuarioDTO> lista = usuarioMapper.listarDesAnsResp();
		return lista;
	}

}
