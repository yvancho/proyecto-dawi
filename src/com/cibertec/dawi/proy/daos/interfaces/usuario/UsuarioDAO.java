package com.cibertec.dawi.proy.daos.interfaces.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;

public interface UsuarioDAO {

	// valida que el usuario exista
	public UsuarioDTO validarUsuario(SqlSession sqlSession,UsuarioDTO usuario) throws Exception;

	// registrar usuario
	public void registrarUsuario(SqlSession sqlSession, UsuarioDTO usu)
			throws Exception;

	// actualizar usuario
	public void actualizarUsuario(SqlSession sqlSession, UsuarioDTO usu)
			throws Exception;

	// cambiar estado de usuario
	public void actEstadoUsuario(SqlSession sqlSession,UsuarioDTO usu) throws Exception;

	// eliminar usuario
	public void eliminarUsuaio(SqlSession sqlSession,UsuarioDTO usu) throws Exception;

	// obtener detalle de usuario
	UsuarioDTO getUsuarioByPkDETALLE(SqlSession sqlSession, int idUsu)
			throws Exception;

	//obtener usuario para sesion
	public UsuarioDTO getUsuSes(SqlSession sqlSession, String idUsu)
			throws Exception;

	// obtener un usuario por PK (idnum) de usuario
	public UsuarioDTO getUsuarioByPK(SqlSession sqlSession,int idUsu) throws Exception;

	// lista de usuarios
	public List<UsuarioDTO> listarUsuarios(SqlSession sqlSession) throws Exception;

	// lista de usuarios por nombre
	public List<UsuarioDTO> listarUsuariosByNom(SqlSession sqlSession,
			String nom) throws Exception;
	
	public List<UsuarioDTO> listarDesAnsResp(SqlSession sqlSession) throws Exception;
}
