package com.cibertec.dawi.proy.daos.mybatis.mappers.solicitud;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;

public interface SolicitudMapper {

	//registrar una nueva solicitud
	void registrarSolicitud(SolicitudDTO sol);

	//actualizar el estado de una solicitud
	@Update("UPDATE tb_solicitud SET idEstSol=#{idest} WHERE idSol=#{idsol}")
	void actualizaEstSol(@Param("idest") Integer idest,
			@Param("idsol") Integer idsol);

	//obtener el area de un usuario
	int getAreaUsu(String idUsu);

	//Listar solicitudes por area
	List<SolicitudDTO> listarSolArea(int area);

	//Listar solicitudes por su estado
	List<SolicitudDTO> listarSolEst();

	//Obtener campo Observacion
	String getSolicitudByPkDETAOBS(int idSol);
	
	//Obtener campo Sustento de Desaprobacion
	String getSolicitudByPkDETASUS(int idSol);

	//Obtener campo ruta de una solicitud
	String getRutaSolByPK(int idSol);
	
	//Contar cuantas solicitudes fueron aprobadas
	int contarSolAprob();
	
	// obtener una Solicitud por su pk
	SolicitudDTO getSolicitudByPK(int idSol);

}
