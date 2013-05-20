package com.cibertec.dawi.proy.actions;

import java.util.List;
import java.util.Map;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;
import com.cibertec.dawi.proy.beans.usuario.*;
import com.cibertec.dawi.proy.services.solicitud.GestionSolicitudBusinessDelegate;
import com.cibertec.dawi.proy.services.solicitud.SolicitudService;
import com.cibertec.dawi.proy.services.usuario.GestionMantenUsuarioBusinessDelegate;
import com.cibertec.dawi.proy.services.usuario.UsuarioService;
import com.cibertec.dawi.proy.util.Constantes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionUsuario extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7798990179508918546L;

	// service
	private UsuarioService usuarioService = GestionMantenUsuarioBusinessDelegate
			.getUsuarioService();
	private SolicitudService solicitudService = GestionSolicitudBusinessDelegate
			.getSolicitudService();

	// beans
	private UsuarioDTO usuario;

	// listas
	private List<UsuarioDTO> listaUsu; // lista de usuarios

	// atributos ausxiliares
	// CODIGO para CRUD (Create, Read, Update, Delete)
	private String codigo;

	// validar PASSWORD sea correcto
	private String reClave;

	// validar EMAIL sea correco
	private String reEmail;

	// opcion cargar para actualizar o detalle
	private String opActEliDet;

	// opcion tomada para eliminar
	private String opElimina;

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usu) {
		this.usuario = usu;
	}

	public List<UsuarioDTO> getListaUsu() {
		return listaUsu;
	}

	public void setListaUsu(List<UsuarioDTO> listaUsu) {
		this.listaUsu = listaUsu;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getReClave() {
		return reClave;
	}

	public void setReClave(String reClave) {
		this.reClave = reClave;
	}

	public String getReEmail() {
		return reEmail;
	}

	public void setReEmail(String reEmail) {
		this.reEmail = reEmail;
	}

	// --------------- VALORES POR DEFECTO DE LOS COMBOS ----------------
	// metodo que obtiene el valor por defecto a mostrar en el combo Pais

	public String getOpActEliDet() {
		return opActEliDet;
	}

	public void setOpActEliDet(String opActEliDet) {
		this.opActEliDet = opActEliDet;
	}

	public String getOpElimina() {
		return opElimina;
	}

	public void setOpElimina(String opElimina) {
		this.opElimina = opElimina;
	}

	public String getDefaultPais() {
		return "PE";
	}

	public String getDefaultEstCiv() {
		return "S";
	}

	public String getDefaultTipoUsu() {
		return "usu";
	}

	// --------------- TRANSACCIONES ------------------

	public String validarUsuario() {

		String resultado = "";

		try {
			boolean existe = usuarioService.existeUsuario(usuario);

			if (existe) {

				usuario = usuarioService.getUsuSes(usuario.getIdUsu());

				Map<String, Object> session = ActionContext.getContext()
						.getSession();
				session.put("s_usuario", usuario);

				String tipo = usuario.getTipoUsu().getIdTipoUsu();

				if (tipo.equalsIgnoreCase("adm")) {
					resultado = Constantes.ADMIN_LOGIN;
					usuario = null;
				} else if (tipo.equalsIgnoreCase("jfa")) {
					resultado = Constantes.JAREA_LOGIN;
				} else if (tipo.equalsIgnoreCase("gpr")) {
					List<SolicitudDTO> listarSolEst = solicitudService
							.listarSolEst();
					Map<String, Object> app = ActionContext.getContext()
							.getApplication();
					app.put("listarSolEst", listarSolEst);
					// subir las solicitudes al Application para listar
					// luego mandar la pagina
					resultado = Constantes.GPRO_LOGIN;
				} else {
					resultado = Constantes.USUARIO_EXISTE;
				}

			} else {
				addActionError(Constantes.MENSAJE_LOGIN_INCORRECTO);
				resultado = Constantes.USUARIO_LOGIN;
			}

			return resultado;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			addActionError(Constantes.MENSAJE_ERROR);
			resultado = Constantes.USUARIO_LOGIN;
			e.printStackTrace();
		}

		return resultado;
	}

	public String cancelaIngreso() throws Exception {
		return Constantes.USUARIO_LOGIN_CANCELAR;
	}

	public String cancelaActEliDet() throws Exception {
		listaUsu = usuarioService.listarUsuariosByNom("");
		return Constantes.USUARIO_LISTA;
	}

	public String logout() {
		ActionContext.getContext().getSession().clear();
		return Constantes.USUARIO_LOGOUT;
	}

	public String registrarUsuario() throws Exception {

		String resultado = "";

		try {
			usuarioService.regitraUsuario(usuario);
			usuario = null;
			listaUsu = usuarioService.listarUsuariosByNom("");
			resultado = Constantes.USUARIO_LISTA;
		} catch (Exception e) {
			addActionError(Constantes.MENSAJE_ERROR);
			resultado = Constantes.USUARIO_NUEVO;
			e.printStackTrace();
		}
		return resultado;
	}

	public String actualizaUsuario() throws Exception {
		String resultado = "";

		try {
			usuarioService.actualizarUsuario(usuario);
			usuario = null;
			listaUsu = usuarioService.listarUsuariosByNom("");
			resultado = Constantes.USUARIO_LISTA;
		} catch (Exception e) {
			addActionError(Constantes.MENSAJE_ERROR);
			resultado = Constantes.USUARIO_EDITA;
			e.printStackTrace();
		}
		return resultado;
	}

	public String eliminarUsuario() throws Exception {
		String resultado;

		try {
			resultado = usuarioService.eliminaUsuOpcion(opElimina, usuario);
			listaUsu = usuarioService.listarUsuariosByNom("");
		} catch (Exception e) {
			addActionError(Constantes.MENSAJE_ERROR);
			resultado = Constantes.USUARIO_ELIMINA;
			e.printStackTrace();
		}

		return resultado;
	}

	public String cargarUsuario() throws Exception {
		String resultado = "";
		usuario = usuarioService.getUsuarioByPK(codigo);

		int opcMant = Integer.parseInt(opActEliDet);

		switch (opcMant) {
		case 1:
			resultado = Constantes.USUARIO_EDITA;
			break;
		case 2:
			resultado = Constantes.USUARIO_ELIMINA;
			break;
		default:
			usuario = usuarioService.getUsuarioByPkDETALLE(codigo);
			resultado = Constantes.USUARIO_DETALLE;
			break;
		}

		return resultado;
	}

	public String listarUsuarios() throws Exception {
		listaUsu = usuarioService.listarUsuariosByNom("");
		return Constantes.USUARIO_LISTA;
	}

	public String listarUsuariosByNom() throws Exception {

		listaUsu = usuarioService.listarUsuariosByNom(usuario.getNomUsu());

		// agregar un mensaje cuando al buscar no exista el usuario.

		return Constantes.USUARIO_LISTA;
	}

}
