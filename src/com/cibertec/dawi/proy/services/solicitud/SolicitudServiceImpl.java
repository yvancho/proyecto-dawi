package com.cibertec.dawi.proy.services.solicitud;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.solicitud.SolicitudDTO;
import com.cibertec.dawi.proy.beans.usuario.AreaDTO;
import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;
import com.cibertec.dawi.proy.daos.factory.DAOFactory;
import com.cibertec.dawi.proy.daos.interfaces.solicitud.SolicitudDAO;
import com.cibertec.dawi.proy.daos.mybatis.SessionFactory;
import com.cibertec.dawi.proy.util.Constantes;
import com.opensymphony.xwork2.ActionContext;

public class SolicitudServiceImpl implements SolicitudService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	SolicitudDAO solicitudDAO = fabrica.getSolicitudDAO();

	@Override
	public void registrarSolicitud(File doc, SolicitudDTO sol) throws Exception {

		System.out.println(doc.getAbsoluteFile());

		Date dFecha = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy_HH_mm");

		Map<String, Object> session = ActionContext.getContext().getSession();

		// usuario que esta en sesion (jefe de area que registra la solicitud)
		UsuarioDTO usu = (UsuarioDTO) session.get("s_usuario");

		// la ruta
		String url = "C:\\TEMP\\SRQ_" + sdf1.format(dFecha) + ".pdf";

		// seteo de campos q faltan para el bean SOLICITUD
		sol.setUrlSol(url);

		// area
		int area = this.getAreaUsu(usu.getIdUsu());
		AreaDTO areaBean = new AreaDTO();
		areaBean.setIdArea(area);

		sol.setArea(areaBean);

		// id usuario
		sol.setIdUsu(usu.getIdUsu());

		// fecha de registro
		sol.setFecRegSol(dFecha);

		// escribe el archivo en el disco
		File archivo = new File(url);
		FileUtils.copyFile(doc, archivo);

		// registro en la bd
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		solicitudDAO.registrarSolicitud(sqlSession, sol);
		sqlSession.close();
	}

	@Override
	public int getAreaUsu(String idUsu) throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		int area = solicitudDAO.getAreaUsu(sqlSession, idUsu);
		sqlSession.close();
		return area;
	}

	@Override
	public List<SolicitudDTO> listarSolicitudes() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		Map<String, Object> session = ActionContext.getContext().getSession();
		UsuarioDTO usu = (UsuarioDTO) session.get("s_usuario");
		int area = this.getAreaUsu(usu.getIdUsu());
		List<SolicitudDTO> lista = solicitudDAO.listarSolicitudes(sqlSession,
				area);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<SolicitudDTO> listarSolEst() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<SolicitudDTO> lista = solicitudDAO.listarSolEst(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public String getSolicitudByPkDETAOBS(String idSol) throws Exception {

		int id = Integer.parseInt(idSol);

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		String obs = solicitudDAO.getSolicitudByPkDETAOBS(sqlSession, id);
		if (obs == null) {
			obs = "No existen observaciones para esta solicitud.";
		}
		sqlSession.close();
		return obs;
	}

	@Override
	public String getSolicitudByPkDETASUS(String idSol) throws Exception {
		int id = Integer.parseInt(idSol);

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		String sus = solicitudDAO.getSolicitudByPkDETASUS(sqlSession, id);
		if (sus == null) {
			sus = "No existe sustento de desaprobación";
		}
		sqlSession.close();
		return sus;
	}

	@Override
	public FileInputStream getRutaSolByPK(String idSol) throws Exception {
		int id = Integer.parseInt(idSol);

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		String ruta = solicitudDAO.getRutaSolByPK(sqlSession, id);
		ruta.replace("\\", "\\" + "\\");

		int indice = ruta.indexOf("SRQ");
		int indiceFin = ruta.indexOf(".pdf");
		String nombre = ruta.substring(indice, indiceFin);

		System.out.println(nombre);

		sqlSession.close();
		FileInputStream fis = new FileInputStream(new File(ruta));
		return fis;
	}

	@Override
	public Map<Object, Object> getRutaSolByPk(String idSol) throws Exception {
		int id = Integer.parseInt(idSol);

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		String ruta = solicitudDAO.getRutaSolByPK(sqlSession, id);
		sqlSession.close();
		ruta.replace("\\", "\\" + "\\");

		int indice = ruta.indexOf("SRQ");
		int indiceFin = ruta.indexOf(".pdf");
		String nombre = ruta.substring(indice, indiceFin);

		FileInputStream fis = new FileInputStream(new File(ruta));

		Map<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put("nombre", nombre);
		mapa.put("archivo", fis);

		return mapa;
	}

	@Override
	public int contarSolAprob() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		int num = solicitudDAO.contarSolAprob(sqlSession);
		sqlSession.close();
		return num;
	}

	@Override
	public String actualizaEstSol(String idest, String idsol) throws Exception {

		String resultado = "";

		int est = Integer.parseInt(idest);
		int sol = Integer.parseInt(idsol);
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();

		solicitudDAO.actualizaEstSol(sqlSession, est, sol);
		sqlSession.close();

		switch (est) {
		case 1:
			resultado = Constantes.SOLICITUD_REGISTRA_PROY;
			break;
		case 2:
			resultado = Constantes.SOLICITUD_DESAPRUEBA_PROY;
			break;
		default:
			resultado = Constantes.PROYECTO_LISTA_APR_SOL;
			break;
		}

		return resultado;
	}

	@Override
	public SolicitudDTO getSolicitudByPK(String idSol) throws Exception {

		int id = Integer.parseInt(idSol);

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		SolicitudDTO bean = solicitudDAO.getSolicitudByPK(sqlSession, id);
		sqlSession.close();
		return bean;
	}

}
