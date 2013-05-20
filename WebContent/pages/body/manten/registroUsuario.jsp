<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="well">
<h2 align="center">
	<s:text name="form.registrar.titulo"></s:text>
</h2>
</div>
<!-- FORMULARIO -->

<s:form action="registrarUsu" method="post"	name="fmrEnvio">

<table width="80%" border="0" align="center">
  <tr>
    <td align="right">
    	<s:text name="form.datosusu.id"/>
    </td>
    <td>
    	<s:textfield name="usuario.idUsu"/>
    </td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.clave"/></td>
    <td>
    	<s:textfield name="usuario.clave" />
    </td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.email"/></td>
    <td><s:textfield name="usuario.email"/></td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.tipodoc"/></td>
    <td>
   		<s:select	list="#application.listaTipoDocId"
   					listKey="idTipoDoc"
   					listValue="descTipoDoc"
   					name="usuario.tipoDoc.idTipoDoc"/>
    </td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.nrodni"/></td>
    <td><s:textfield name="usuario.nroDocID"/></td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.nom"/></td>
    <td><s:textfield name="usuario.nomUsu"/></td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.ape"/></td>
    <td><s:textfield name="usuario.apeUsu"/></td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.gen"/></td>
    <td>
		<s:select	list="#application.listaGen"
   					listKey="idGen"
   					listValue="descGen"
   					name="usuario.genero.idGen"/>
	</td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.pais"/></td>
    <td>
		<s:select	list="#application.listaPais"
   					listKey="idPais"
   					listValue="descPais" 
   					name="usuario.pais.idPais"
   					value="defaultPais"
   					/>
	</td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.dist"/></td>
    <td>
		<s:select	list="#application.listaDist"
   					listKey="idDist"
   					listValue="descDist" 
   					name="usuario.distrito.idDist"
   					/>
	</td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.dire"/></td>
    <td><s:textfield name="usuario.direUsu"/></td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.fecnac"/></td>
    <td>    
    	<s:textfield name="usuario.fecNac" id="txtFecNac" />
    	<a href="javascript:NewCal('txtFecNac','ddmmyyyy')">
    		<img src="img/cal.gif" width="16" height="16" border="0" alt="fecha_nac"/>
    	</a>
    </td>
  </tr>
  <tr>
    <td align="right"> <s:text name="form.datosusu.estciv"/></td>
    <td>
		<s:select	list="#application.listaEstCiv"
   					listKey="idEstCiv"
   					listValue="descEstCiv" 
   					name="usuario.estadoCivil.idEstCiv"
   					value="defaultEstCiv"
   					/>
	</td>
  </tr>
  <tr>
    <td align="right"><s:text name="form.datosusu.fono"/></td>
    <td><s:textfield name="usuario.telefono"/></td>
  </tr>
 
 <tr>
    <td align="right"><s:text name="form.datosusu.area"/></td>
    <td>
		<s:select	list="#application.listaAreas"
   					listKey="idArea"
   					listValue="descArea" 
   					name="usuario.area.idArea"
   					value="1"
   					/>
	</td>
  </tr>
  
  <tr>
    <td align="right"><s:text name="form.datosusu.tipousu"/></td>
    <td>
		<s:select	list="#application.listaTipoUsu"
   					listKey="idTipoUsu"
   					listValue="descTipoUsu" 
   					name="usuario.tipoUsu.idTipoUsu"
   					value="defaultTipoUsu"
   					/>
	</td>
  </tr>
  
  <tr>
    <td align="right"><s:text name="form.datosusu.feccont"/></td>
    <td>
    	<s:textfield name="usuario.fecContrato" id="txtfecContrato"/>
    	<a href="javascript:NewCal('txtfecContrato','ddmmyyyy')">
    		<img src="img/cal.gif" width="16" height="16" border="0" alt="fecha_Contrato"/>
    	</a>
    </td>
  </tr>
  <tr>
  	<td >
  		<h3><s:actionerror/></h3>
  	</td>
  	<td >
  		<s:submit value="%{getText('form.registrar.botonReg')}" cssClass="btn btn-primary"/>
  	</td>
  </tr>
</table>
</s:form>