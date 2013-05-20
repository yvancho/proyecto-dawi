<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2 align="center">
	<s:text name="Observación del Requerimiento"/>
	<br/>
	<s:text name= "Aquí va el Nombre del SRQ"/>
</h2>
<s:form action="vovlerListaSol" >
  
<table width="80%" border="0" align="center" class="table ">
    
  <tr>
    <td  align="left" valign="middle">
    	<s:text name="detObsSol" />
    </td>
  </tr>
   <tr>
    <td  align="left" valign="middle">
 	&nbsp;
    </td>
  </tr>
  <tr>
     <td  align="left" valign="middle">
    <s:submit cssClass="btn btn-inverse" 
    		  id="btnDetRegresar" 
    		  value="Regresar"/>
    </td>
    
  </tr>
</table>
</s:form>