<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<h2 align="center">
	<s:text name="form.listaUsuarios.titulo"></s:text>
</h2>


<s:form action="buscarUsu" cssClass="well form-search">
	<s:text name="form.campo.buscarUsu"/>
	<s:textfield name="usuario.nomUsu" cssClass="input-medium search-query"/>
	
	<s:submit value="%{getText('form.listaUsuarios.btnBuscar')}" cssClass="btn">
		<i class="icon-search"></i>
	</s:submit>				
</s:form>

<s:if test="#application.listaUsuario.size>0">

<table width="80%" border="0" align="center" class="table table-bordered">
	<thead>
		<tr >
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.id"/> </th>
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.usuario"/></th>
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.nombre"/></th>
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.apellido"/></th>
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.tipousu"/></th>
			
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.actualiza"/></th>
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.elimina"/></th>
			<th scope="col"><s:text name="form.listaUsuarios.cabecera.detalle"/></th>
			
		</tr>
	</thead>
		<s:iterator value="listaUsu">
		<tr>
			<td align="center"><s:property value="idNumUsu"/></td>
			<td align="center"><s:property value="idUsu"/></td>
			<td align="justify"><s:property value="nomUsu"/></td>
			<td align="justify"><s:property value="apeUsu"/></td>
			<td align="center"><s:property value="tipoUsu.descTipoUsu"/></td>
			
			
			<td align="center">
				<s:url action="loadUsu" id="actualizar">
					<s:param name="codigo">
						<s:property value="idNumUsu"/>
					</s:param>
					<s:param name="opActEliDet">
						<s:property value="1"/>
					</s:param>
				</s:url>
				<s:a href="%{actualizar}">
					<s:text name="form.listaUsuarios.celda.act"></s:text>
				</s:a>
			</td>
						
			<td align="center">
			<s:url action="loadUsu" id="eliminar">
					<s:param name="codigo">
						<s:property value="idNumUsu"/>
					</s:param>
					<s:param name="opActEliDet">
						<s:property value="2"/>
					</s:param>
				</s:url>
				<s:a href="%{eliminar}">
					<s:text name="form.listaUsuarios.celda.eli"></s:text>
				</s:a>
			</td>
			
			<td align="center">
				<s:url action="loadUsu" id="detalle">
					<s:param name="codigo">
						<s:property value="idNumUsu"/>
					</s:param>
					<s:param name="opActEliDet">
						<s:property value="3"/>
					</s:param>				
				</s:url>
				<s:a href="%{detalle}">
					<s:text name="form.listaUsuarios.celda.det"></s:text>
				</s:a>
			</td>			
		</tr>
		</s:iterator>
</table>
</s:if>
<s:else>
	<h2> <s:text name="form.listaUsuarios.listavacia"></s:text></h2>
</s:else>