<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2 align="center">Eliminar Usuario</h2>

<s:form>
	<table width="80%" border="0" align="center">
		<s:hidden name="usuario.idNumUsu" id="idn"></s:hidden>
		<tr>
			<td width="50%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><s:radio
					list="#{'0':'Eliminar del sistema', '1':'Eliminar permanentemente'}"
					name="opElimina" value="0"></s:radio>
		</tr>
		<tr>
			<td><s:submit   action="deleteUsu" 
							id="btnElimina" 
							cssClass="btn btn-danger"
							value="%{getText('forms.eliminar')}" />
							 
				<s:submit 	action="cancelaActEliDet" 
							id="btnCanceler"
							cssClass="btn" 
							value="%{getText('forms.cancelar')}" /></td>
			<td>&nbsp;</td>
		</tr>
	</table>
</s:form>

