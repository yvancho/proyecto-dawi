package com.cibertec.dawi.proy.services.usuario;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cibertec.dawi.proy.beans.usuario.AreaDTO;
import com.cibertec.dawi.proy.beans.usuario.DistritoDTO;
import com.cibertec.dawi.proy.beans.usuario.EstadoCivilDTO;
import com.cibertec.dawi.proy.beans.usuario.GeneroDTO;
import com.cibertec.dawi.proy.beans.usuario.PaisDTO;
import com.cibertec.dawi.proy.beans.usuario.TipoDocIdDTO;
import com.cibertec.dawi.proy.beans.usuario.TipoUsuarioDTO;
import com.cibertec.dawi.proy.beans.usuario.UsuarioDTO;
import com.cibertec.dawi.proy.daos.factory.DAOFactory;
import com.cibertec.dawi.proy.daos.interfaces.usuario.AreaDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.DistritoDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.EstadoCivilDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.GeneroDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.PaisDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.TipoDocIdDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.TipoUsuarioDAO;
import com.cibertec.dawi.proy.daos.interfaces.usuario.UsuarioDAO;
import com.cibertec.dawi.proy.daos.mybatis.SessionFactory;
import com.cibertec.dawi.proy.util.Constantes;

public class UsuarioServiceImpl implements UsuarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	// DAOS
	UsuarioDAO usuarioDAO = fabrica.getUsuarioDAO(); // usuarios
	TipoDocIdDAO tipoDocIdDAO = fabrica.getTipoDocIdDAO(); // tipo de documentos
	GeneroDAO generoDAO = fabrica.getGeneroDAO(); // generos
	PaisDAO paisDAO = fabrica.getPaisDAO(); // pais
	DistritoDAO distDAO = fabrica.getDistritoDAO(); // Distritos
	EstadoCivilDAO estCivilDAO = fabrica.getEstadoCivilDAO(); // estados civiles
	TipoUsuarioDAO tipoUsuDAO = fabrica.getTipoUsuarioDAO(); // tipos usu
	AreaDAO areaDAO = fabrica.getAreaDAO();

	@Override
	public boolean existeUsuario(UsuarioDTO usuario) throws Exception {

		usuario.setIdUsu(usuario.getIdUsu().trim());

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();

		if (usuarioDAO.validarUsuario(sqlSession, usuario) != null) {
			sqlSession.close();
			return true;
		}
		sqlSession.close();
		return false;
	}

	@Override
	public UsuarioDTO getUsuSes(String idUsu) throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		UsuarioDTO usuario = usuarioDAO.getUsuSes(sqlSession, idUsu);
		sqlSession.close();
		return usuario;
	}

	@Override
	public UsuarioDTO getUsuarioByPK(String idUsu) throws Exception {
		int id = Integer.parseInt(idUsu);
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		UsuarioDTO bean = usuarioDAO.getUsuarioByPK(sqlSession, id);
		sqlSession.close();
		return bean;
	}

	@Override
	public UsuarioDTO getUsuarioByPkDETALLE(String idNusu) throws Exception {

		int id = Integer.parseInt(idNusu);
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		UsuarioDTO bean = usuarioDAO.getUsuarioByPkDETALLE(sqlSession, id);
		sqlSession.close();
		return bean;
	}

	// --------- MANTENIMIENTO --------------
	@Override
	public void regitraUsuario(UsuarioDTO usu) throws Exception {

		// 1. validar que la fecha de nacimiento y la de ingreso
		// no sean mayores que la de hoy.

		usu.setIdUsu(usu.getIdUsu().trim());
		usu.setEmail(usu.getEmail().trim());
		usu.setNroDocID(usu.getNroDocID().trim());

		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();

		usuarioDAO.registrarUsuario(sqlSession, usu);
		sqlSession.close();
	}

	@Override
	public void actualizarUsuario(UsuarioDTO usu) throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		usuarioDAO.actualizarUsuario(sqlSession, usu);
		sqlSession.close();
	}

	@Override
	public String eliminaUsuOpcion(String opc, UsuarioDTO usuario)
			throws Exception {
		String resultado;

		int opDel = Integer.parseInt(opc);

		switch (opDel) {
		case 0:
			// sistema
			this.actualizaEstadoUsu(usuario);
			resultado = Constantes.USUARIO_LISTA;
			break;
		default:
			// bd
			this.eliminarUsuario(usuario);
			resultado = Constantes.USUARIO_LISTA;
			break;
		}
		return resultado;
	}

	@Override
	public void actualizaEstadoUsu(UsuarioDTO usu) throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		usuarioDAO.actEstadoUsuario(sqlSession, usu);
		sqlSession.close();
	}

	@Override
	public void eliminarUsuario(UsuarioDTO usu) throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		usuarioDAO.eliminarUsuaio(sqlSession, usu);
		sqlSession.close();
	}

	// ---------- LISTAS ---------------
	@Override
	public List<UsuarioDTO> listarUsuarios() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<UsuarioDTO> lista = usuarioDAO.listarUsuarios(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<TipoDocIdDTO> listarTipoDocId() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<TipoDocIdDTO> lista = tipoDocIdDAO.listarTipoDocId(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<GeneroDTO> listarGeneros() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<GeneroDTO> lista = generoDAO.listarGeneros(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<PaisDTO> listaPaises() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<PaisDTO> lista = paisDAO.listaPaises(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<DistritoDTO> listarDistritos() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<DistritoDTO> lista = distDAO.listarDist(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<EstadoCivilDTO> listarEstCiv() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<EstadoCivilDTO> lista = estCivilDAO.listarEstCiv(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<TipoUsuarioDTO> listarTipoUsu() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<TipoUsuarioDTO> lista = tipoUsuDAO.listarTipoUsu(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<UsuarioDTO> listarUsuariosByNom(String nom) throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<UsuarioDTO> lista = usuarioDAO
				.listarUsuariosByNom(sqlSession, nom);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<AreaDTO> listarAreas() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<AreaDTO> lista = areaDAO.listarAreas(sqlSession);
		sqlSession.close();
		return lista;
	}

	@Override
	public List<UsuarioDTO> listarDesAnsResp() throws Exception {
		SqlSession sqlSession = SessionFactory.getSqlSessionFactory()
				.openSession();
		List<UsuarioDTO> lista = usuarioDAO.listarDesAnsResp(sqlSession);
		
		sqlSession.close();
		return lista;
	}

}
