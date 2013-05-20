package com.cibertec.dawi.proy.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cibertec.dawi.proy.beans.proyecto.MonedaDTO;
import com.cibertec.dawi.proy.beans.proyecto.PrioridadProyectoDTO;
import com.cibertec.dawi.proy.beans.usuario.AreaDTO;
import com.cibertec.dawi.proy.beans.usuario.DistritoDTO;
import com.cibertec.dawi.proy.beans.usuario.EstadoCivilDTO;
import com.cibertec.dawi.proy.beans.usuario.GeneroDTO;
import com.cibertec.dawi.proy.beans.usuario.PaisDTO;
import com.cibertec.dawi.proy.beans.usuario.TipoDocIdDTO;
import com.cibertec.dawi.proy.beans.usuario.TipoUsuarioDTO;
import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;
import com.cibertec.dawi.proy.services.proyecto.GestionProyectoBusinessDelegate;
import com.cibertec.dawi.proy.services.proyecto.ProyectoService;
import com.cibertec.dawi.proy.services.usuario.GestionMantenUsuarioBusinessDelegate;
import com.cibertec.dawi.proy.services.usuario.UsuarioService;

public class ContextoListener implements ServletContextListener {

	private UsuarioService usuarioService = GestionMantenUsuarioBusinessDelegate
			.getUsuarioService();
	private ProyectoService proyService = GestionProyectoBusinessDelegate
			.getProyectoService();

	@Override
	public void contextDestroyed(ServletContextEvent sc) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {

		try {

			// -------------- USUARIO -----------------
			List<UsuarioDTO> listaUsuario = usuarioService
					.listarUsuariosByNom("");
			List<TipoDocIdDTO> listaTipoDocId = usuarioService
					.listarTipoDocId();
			List<GeneroDTO> listaGen = usuarioService.listarGeneros();
			List<PaisDTO> listaPais = usuarioService.listaPaises();
			List<DistritoDTO> listaDist = usuarioService.listarDistritos();
			List<EstadoCivilDTO> listaEstCiv = usuarioService.listarEstCiv();
			List<TipoUsuarioDTO> listaTipoUsu = usuarioService.listarTipoUsu();
			List<AreaDTO> listaAreas = usuarioService.listarAreas();

			sc.getServletContext().setAttribute("listaUsuario", listaUsuario);
			sc.getServletContext().setAttribute("listaTipoDocId",
					listaTipoDocId);
			sc.getServletContext().setAttribute("listaGen", listaGen);
			sc.getServletContext().setAttribute("listaPais", listaPais);
			sc.getServletContext().setAttribute("listaDist", listaDist);
			sc.getServletContext().setAttribute("listaEstCiv", listaEstCiv);
			sc.getServletContext().setAttribute("listaTipoUsu", listaTipoUsu);
			sc.getServletContext().setAttribute("listaAreas", listaAreas);

			// --------------- PROYECTO ----------------
			List<MonedaDTO> listarMonedas = proyService.listarMonedas();
			List<PrioridadProyectoDTO> listarPrioridad = proyService
					.listarPrioridad();

			sc.getServletContext().setAttribute("listaMonedas", listarMonedas);
			sc.getServletContext().setAttribute("listaPrioridad",
					listarPrioridad);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
