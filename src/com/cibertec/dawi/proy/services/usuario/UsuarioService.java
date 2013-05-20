package com.cibertec.dawi.proy.services.usuario;

import java.util.List;

import com.cibertec.dawi.proy.beans.usuario.AreaDTO;
import com.cibertec.dawi.proy.beans.usuario.DistritoDTO;
import com.cibertec.dawi.proy.beans.usuario.EstadoCivilDTO;
import com.cibertec.dawi.proy.beans.usuario.GeneroDTO;
import com.cibertec.dawi.proy.beans.usuario.PaisDTO;
import com.cibertec.dawi.proy.beans.usuario.TipoDocIdDTO;
import com.cibertec.dawi.proy.beans.usuario.TipoUsuarioDTO;
import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;

public interface UsuarioService {

	// comprobar la existencia del usuario
	public boolean existeUsuario(UsuarioDTO usuario) throws Exception;

	// ----- MANTENIMIENTO -----
	public void regitraUsuario(UsuarioDTO usu) throws Exception;

	public void actualizarUsuario(UsuarioDTO usu) throws Exception;

	// Eliminar: escojer si elimina de la bd o inhabilita
	public String eliminaUsuOpcion(String opc,UsuarioDTO usu) throws Exception;

	// Eliminar usuario de la bd
	public void eliminarUsuario(UsuarioDTO usu) throws Exception;

	// Eliminar, cambiar de estado Usuario a Desactivado
	public void actualizaEstadoUsu(UsuarioDTO usuario) throws Exception;

	// --------- TRANSACCIONES ----------
	// obtener un usuario a traves de su id de usuario
	public UsuarioDTO getUsuSes(String idUsu) throws Exception;

	// obtener un usuario por PK (idnum) de usuario
	public UsuarioDTO getUsuarioByPK(String idUsu) throws Exception;

	// obtener el usuario y su detalle
	public UsuarioDTO getUsuarioByPkDETALLE(String idNusu) throws Exception;
	
	public List<UsuarioDTO> listarDesAnsResp() throws Exception;

	// -------------------- LISTAS --------------------------
	// lista de usuarios
	public List<UsuarioDTO> listarUsuarios() throws Exception;

	// listar usuarios por nombre
	public List<UsuarioDTO> listarUsuariosByNom(String nom) throws Exception;

	// lista de tipo de documentos de identificacion
	public List<TipoDocIdDTO> listarTipoDocId() throws Exception;

	// lista de géneros
	public List<GeneroDTO> listarGeneros() throws Exception;

	// lista de paises
	public List<PaisDTO> listaPaises() throws Exception;

	// lista de distritos
	public List<DistritoDTO> listarDistritos() throws Exception;

	// lista de estados civiles
	public List<EstadoCivilDTO> listarEstCiv() throws Exception;

	// lista de Tipo de usuarios
	public List<TipoUsuarioDTO> listarTipoUsu() throws Exception;

	// lista de Areas
	public List<AreaDTO> listarAreas() throws Exception;
	
	
}
