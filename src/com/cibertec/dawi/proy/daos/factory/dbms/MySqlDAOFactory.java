package com.cibertec.dawi.proy.daos.factory.dbms;

import com.cibertec.dawi.proy.daos.factory.DAOFactory;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.MonedaDAO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.PrioridadProyectoDAO;
import com.cibertec.dawi.proy.daos.interfaces.proyecto.ProyectoDAO;
import com.cibertec.dawi.proy.daos.interfaces.solicitud.EstadoSolicitudDAO;
import com.cibertec.dawi.proy.daos.interfaces.solicitud.SolicitudDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.*;
import com.cibertec.dawi.proy.daos.mysql.proyecto.MonedaMySqlDAO;
import com.cibertec.dawi.proy.daos.mysql.proyecto.PrioridadProyectoMySqlDAO;
import com.cibertec.dawi.proy.daos.mysql.proyecto.ProyectoMySqlDAO;
import com.cibertec.dawi.proy.daos.mysql.solicitud.EstadoSolicitudMySqlDAO;
import com.cibertec.dawi.proy.daos.mysql.solicitud.SolicitudMySqlDAO;
import com.cibertec.dawi.proy.daos.mysql.usuario.*;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioMySqlDAO();
	}

	@Override
	public TipoDocIdDAO getTipoDocIdDAO() {
		// TODO Auto-generated method stub
		return new TipoDocIdMySqlDAO();
	}

	@Override
	public GeneroDAO getGeneroDAO() {
		// TODO Auto-generated method stub
		return new GeneroMySqlDAO();
	}

	@Override
	public PaisDAO getPaisDAO() {
		// TODO Auto-generated method stub
		return new PaisMySqlDAO();
	}

	@Override
	public DistritoDAO getDistritoDAO() {
		// TODO Auto-generated method stub
		return new DistritoMySqlDAO();
	}

	@Override
	public EstadoCivilDAO getEstadoCivilDAO() {
		// TODO Auto-generated method stub
		return new EstadoCivilMySqlDAO();
	}

	@Override
	public TipoUsuarioDAO getTipoUsuarioDAO() {
		// TODO Auto-generated method stub
		return new TipoUsuarioMySqlDAO();
	}

	@Override
	public AreaDAO getAreaDAO() {
		// TODO Auto-generated method stub
		return new AreaMySqlDAO();
	}

	// -------------- SOLICITUD ---------------

	@Override
	public EstadoSolicitudDAO getEstadoSolicitudDAO() {
		// TODO Auto-generated method stub
		return new EstadoSolicitudMySqlDAO();
	}

	@Override
	public SolicitudDAO getSolicitudDAO() {
		return new SolicitudMySqlDAO();
	}

	@Override
	public ProyectoDAO getProyectoDAO() {
		return new ProyectoMySqlDAO();
	}

	@Override
	public MonedaDAO getMonedaDAO() {
		return new MonedaMySqlDAO();
	}

	@Override
	public PrioridadProyectoDAO getPrioridadProyectoDAO() {
		// TODO Auto-generated method stub
		return new PrioridadProyectoMySqlDAO();
	}

}
