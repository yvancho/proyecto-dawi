package com.cibertec.dawi.proy.daos.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {

	protected static final SqlSessionFactory FACTORY;

	static {
		try {
			Reader reader = Resources
					.getResourceAsReader("/com/cibertec/dawi/proy/daos/mybatis/config/mybatis-config.xml");
			FACTORY = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error inicializando la clase SqlSessionFactory. Causa: "
							+ e);
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return FACTORY;
	}

}
