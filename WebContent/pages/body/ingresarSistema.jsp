<%@ taglib prefix="s" uri="/struts-tags"%>

<h2 align="center">
	<s:text name="form.ingresar.titulo"></s:text>
</h2>


<s:form action="ingresarSistema" id="frmLogin">
	<table width="80%" border="0" align="center">
		<tr>
			<td><s:text name="form.ingresar.user"></s:text></td>
			<td><s:textfield name="usuario.idUsu" id="txtId"></s:textfield></td>
		</tr>
		<tr>
			<td><s:text name="form.ingresar.pass"></s:text></td>
			<td><s:password name="usuario.clave" id="txtClav"></s:password></td>
		</tr>
		<tr>
			<td><h3><s:actionerror/></h3>
			</td>
			<td>
				<s:submit value="%{getText('form.ingresar.boton.ingresar')}"
						  cssClass="btn btn-primary" data-loading-text="Loading..."/>
				<s:submit value="%{getText('form.ingresar.boton.cancelar')}" cssClass="btn"
						  action="cancelaIngreso"/>
			</td>
		</tr>
	</table>

</s:form>