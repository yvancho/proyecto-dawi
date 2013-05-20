package com.cibertec.dawi.proy.daos.mybatis.mappers.usuario;

import java.util.List;

import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;

public interface UsuarioMapper {

	// UsuarioDTO validarUsuario(UsuarioDTO usuario);
	int validarUsuario(UsuarioDTO usuario);

	UsuarioDTO getUsuSes(String idUsu);

	// obtener un usuario por PK (idnum) de usuario
	UsuarioDTO getUsuarioByPK(int idUsu);

	// obtener detalle de usuario
	UsuarioDTO getUsuarioByPkDETALLE(int idUsu);

	//------------- MANTENIMIENTO -----------------
	
	// registra nuevos usuarios
	void registrarUsuario(UsuarioDTO usu);

	// actualizar usuario
	void actualizarUsuario(UsuarioDTO usu);

	// cambiar estado de usuario
	void actEstadoUsuario(UsuarioDTO usu);

	// eliminar usuario
	void eliminarUsuaio(UsuarioDTO usu);

	// lista todos los usuarios
	List<UsuarioDTO> listarUsuarios();

	// Lista y busca usuarios por user, nombre, apellido
	List<UsuarioDTO> listarUsuariosByNom(String filtro);
	
	//Listar usuarios Desarrolladores y Analistas con menos de 2 proyectos
	List<UsuarioDTO> listarDesAnsResp();
}
