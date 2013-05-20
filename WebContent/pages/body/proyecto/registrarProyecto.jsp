<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="well">
<h2 align="center">
	<s:text name="proyecto.regproy.titulo"/>
</h2>
</div>

<div class="well">
<table width="80%" border="0" align="center" class="table table-striped table-bordered table-condensed">
<tr>
	<td align="center" colspan="2">
	<h3><s:text name="proyecto.regproy.soltitulo"/> </h3>
	</td>
</tr>
<tr>
	<td align="right">
		<strong>
			<s:text name="form.aprobacion.solicitud.descripcion"/>
		</strong>
	</td>
	<td>
		<s:property value="solicitud.descSol"/>
	</td>
</tr>
<tr>
	<td align="right">
		<strong>
			<s:text name="proyecto.regproy.areasol"/>
		</strong>
	</td>
	<td>
		<s:property value="solicitud.area.descArea"/>
		
	</td>
</tr>
</table>
</div>


<s:form cssClass="well" name="frmRegProy" action="registrarProy">

<table width="80%" border="0" align="center">
<tr>
	<td align="right">
		<s:text name="Descripción"/>
	</td>
	<td>
		
		<input type="hidden" name="proyecto.solicitud.idSol" id="hCodSolp" 
				value="<s:property value='solicitud.idSol'/>"/>
			
		<s:textfield name="proyecto.descProy"/>
	</td>
</tr>
<tr>
	<td align="right">
		<s:text name="Tipo de moneda"/>
	</td>
	<td>
		<s:select	list="#application.listaMonedas"
					listKey="idMoneda"
					listValue="descMoneda"
					name="detaProyecto.moneda.idMoneda"
					/>
	</td>
</tr>
<tr>
	<td align="right">
		<s:text name="proyecto.regproy.costo"/>
	</td>
	<td>
		<s:textfield name="detaProyecto.costoProy"/>
	</td>
</tr>
<tr>
	<td align="right">
		<s:text name="proyecto.regproy.prioridad"/>
	</td>
	<td>
		<s:select list="#application.listaPrioridad"
				  listKey="idPrioProy"
				  listValue="descPrioProy"
				  name="proyecto.prioridad.idPrioProy"/>
	</td>
</tr>
<tr>
	<td align="right">
		<s:text name="Fecha de Inicio"/>
	</td>
	<td>
		<s:textfield/>
	</td>
</tr>
<tr>
	<td align="right">
		<s:text name="Fecha de Término"/>
	</td>
	<td>
		<s:textfield/>
	</td>
</tr>
<tr>
	<td align="right">
		<s:text name="ID del Repsonsable"/>
	</td>
	<td>
		<s:hidden name="detaProyecto.usuario.idNumUsu" id="txtIdNresp"/>
		<s:textfield disabled="true" name="detaProyecto.usuario.idUsu" id="txtIdResp"/>
	</td>
	<td valign="middle">
		<input type="button" 
			   value="Asignar Responsable"
			   id="btnAsignarRes"
			   onclick="abrir_ventana()"
			   class="btn btn-primary"/>
	</td>
</tr>
<tr>
	<td align="right">
		<s:text name="Nombre del Responsable"/>
	</td>
	<td>
		<s:textfield disabled="true" id="txtNomResp"/>
	</td>
</tr>
<tr>
	<td colspan="2">
		<div class="well span5" >
			<s:text name="Observación"/>
			<s:textarea name="proyecto.obsProy" rows="4" cssClass="input-xlarge"/>
		</div>				
	</td>
</tr>
<tr>
<td colspan="3">
	<h3><s:actionerror/></h3>
</td>
</tr>

<tr>
	<td>
		<s:hidden name="codSol"></s:hidden>
	</td>
	<td>
		<s:submit value="Registrar" cssClass="btn btn-success"/>
		<s:submit action="cancelaRegProy" value="Cancelar" cssClass="btn btn-warning">		
		</s:submit>
	</td>
</tr>
</table>

</s:form>

<script type="text/javascript">

var winAsigResp;

function abrir_ventana(){

	winAsigResp = window.open("pages/body/proyecto/asignarResp.jsp",
				"miventana",
				"width=680,height=600,status=1;menubar=no,"+
				"location=0,titlebar=0,scrollbars=1,resizable=1");
	winAsigResp.focus();
}
</script>














