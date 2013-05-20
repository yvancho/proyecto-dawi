package com.cibertec.dawi.proy.util;

public class Constantes {

	// login
	public static final String USUARIO_LOGIN = "loginUsuario";
	public static final String USUARIO_LOGIN_CANCELAR = "cancelar";
	public static final String USUARIO_LOGOUT = "logoutUsuario";

	// logeo de tipos de usuario
	public static final String ADMIN_LOGIN = "mantenUsuario";
	public static final String JAREA_LOGIN = "registraSolic";
	public static final String GPRO_LOGIN = "aprobarSol";

	// results
	public static final String USUARIO_EXISTE = "existeUsuario";
	public static final String SOLICITUD_APROB_RELOAD = "recargaAprobSol";

	// mantenimiento
	public static final String USUARIO_NUEVO = "mantenUsuario";
	public static final String USUARIO_EDITA = "actualizaUsuario";
	public static final String USUARIO_ELIMINA = "eliminaUsuario";
	public static final String USUARIO_LISTA = "listaUsuarios";
	public static final String USUARIO_DETALLE = "detalleUsuario";

	// SOLICITUD
	public static final String SOLICITUD_REGISTRA_PROY = "registraProy";
	public static final String SOLICITUD_DESAPRUEBA_PROY = "desapruebaProy";
	public static final String SOLICITUD_LISTA = "listaSolicitud";
	public static final String SOLICITUD_DETALLEOBS = "detalleObs";
	public static final String SOLICITUD_DETALLE_SUS = "detalleSus";
	public static final String SOLICITUD_BAJADA = "bajando";
	
	// PROYECTO
	public static final String PROYECTO_LISTA_APR_SOL = "listaAprSol";

	// ERRORES
	public static final String MENSAJE_ERROR = "En estos momentos no lo podemos atender";
	public static final String MENSAJE_LOGIN_INCORRECTO = "Datos incorrectos";
	public static final String MENSAJE_NO_APROBAR_SOL = "No se puede aprobar más solcitudes por haber alcanzado el número máximo de proyectos en marcha.";
}
