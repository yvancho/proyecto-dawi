package com.cibertec.dawi.proy.daos.factory;

import com.cibertec.dawi.proy.daos.factory.dbms.*;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.MonedaDAO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.PrioridadProyectoDAO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.ProyectoDAO;
import com.cibertec.dawi.proy.daos.interfaces.solicitud.EstadoSolicitudDAO;
import com.cibertec.dawi.proy.daos.interfaces.solicitud.SolicitudDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.*;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int POSTGRESQL = 5;
	public static final int XML = 6;

	// ------------- DAOS USUARIO -----------------
	public abstract UsuarioDAO getUsuarioDAO();

	public abstract AreaDAO getAreaDAO();

	public abstract TipoDocIdDAO getTipoDocIdDAO();

	public abstract GeneroDAO getGeneroDAO();

	public abstract PaisDAO getPaisDAO();

	public abstract DistritoDAO getDistritoDAO();

	public abstract EstadoCivilDAO getEstadoCivilDAO();

	public abstract TipoUsuarioDAO getTipoUsuarioDAO();

	// --------------- DAOS SOLICITUD ----------------
	public abstract EstadoSolicitudDAO getEstadoSolicitudDAO();

	public abstract SolicitudDAO getSolicitudDAO();

	// --------------- DAOS PROYECTO ------------------
	public abstract ProyectoDAO getProyectoDAO();

	public abstract MonedaDAO getMonedaDAO();
	
	public abstract PrioridadProyectoDAO getPrioridadProyectoDAO();

	// ------------------------------------------------
	public static DAOFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		case DB2:
			return new DerbyDAOFactory();
		case SQLSERVER:
			return new XMLDAOFactory();
		case POSTGRESQL:
			return new PostgreSQLDAOFactory();
		case XML:
			return new XMLDAOFactory();
		default:
			return null;
		}
	}
}
