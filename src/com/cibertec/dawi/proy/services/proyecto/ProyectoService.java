package com.cibertec.dawi.proy.services.proyecto;

import java.util.List;

import com.cibertec.dawi.proy.beans.proyecto.MonedaDTO;
import com.cibertec.dawi.proy.beans.proyecto.PrioridadProyectoDTO;
import com.cibertec.dawi.proy.beans.proyecto.ProyectoDTO;

public interface ProyectoService {
	public void registraProy(ProyectoDTO proy) throws Exception;

	public List<MonedaDTO> listarMonedas() throws Exception;
	
	public List<PrioridadProyectoDTO> listarPrioridad() throws Exception;
	
}
