<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2 align="center">
	 <s:text name="form.datosusu.detalle.titulo"></s:text>
	<s:text name="usuario.idUsu"/>
</h2>

<s:form action="cancelaActEliDet" >
<table width="80%" border="0" align="center" class="table table-striped table-bordered table-condensed">
  <tr>
    <td width="50%" align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.nom"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.nomUsu"/>
    </td>
  </tr>  
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.ape"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.apeUsu"/>
    </td>
  </tr>  
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.tipodoc"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.tipoDoc.descTipoDoc"/>
    </td>
  </tr>  
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.nrodni"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.nroDocID"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.pais"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.pais.descPais"/>
    </td>
  </tr>  
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.dist"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.distrito.descDist"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle"><strong>
      <s:text name="form.datosusu.dire"/>
    </strong></td>
    <td align="left" valign="middle">
    	<s:text name="usuario.direUsu"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle"><strong>
      <s:text name="form.datosusu.fecnac"/>
    </strong></td>
    <td align="left" valign="middle"><s:text name="usuario.fecNac"/></td>
  </tr>
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.gen"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.genero.descGen"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.estciv"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.estadoCivil.descEstCiv"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.fono"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.telefono"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.email"/>
    	</strong>
    </td>
    <td align="left" valign="middle">   	
    	    	
    	<a href='mailto:<s:property value="usuario.email"/>'>
    		<s:property value="usuario.email"/>
    	</a>
    	
    </td>
  </tr>  
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.area"/>
    	</strong>
    </td>
    <td align="left" valign="middle">   	
    	<s:text name="usuario.area.descArea"/>
    </td>
  </tr>  
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.tipousu"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.tipoUsu.descTipoUsu"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle">
    	<strong>
      		<s:text name="form.datosusu.feccont"/>
    	</strong>
    </td>
    <td align="left" valign="middle">
    	<s:text name="usuario.fecContrato"/>
    </td>
  </tr>
  <tr>
    <td align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">
    <s:submit cssClass="btn btn-inverse" 
    		  id="btnDetRegresar" 
    		  value="%{getText('forms.retornar')}"/>
    </td>
  </tr>
</table>
</s:form>