<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Asignar Responsable</title>
<link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function retornaResp() {
	var idn="-1";
	var idusu="";
	var nombre="";
	var apellido="";
	
	var elementos = document.getElementsByName("codNusu");
	
	for(var i=0; i<elementos.length; i++) {
		
		if (elementos[i].checked) {
			//id = elementos[i].value;
			var fila = elementos[i].parentNode.parentNode;
			var celdas = fila.getElementsByTagName("td");
			
			idn = celdas[0].innerText;
			idusu = celdas[1].innerText;
			nombre = celdas[2].innerText;
			apellido = celdas[3].innerText;			
			break;
			};		
	}
	
	opener.document.getElementById("txtIdNresp").value=idn;
	opener.document.getElementById("txtIdResp").value=idusu;
	opener.document.getElementById("txtNomResp").value=nombre+" "+apellido;
	window.close();
}
</script>

</head>
<body>

<div class="well">
<h2 align="center">
	<s:text name="proyecto.asigresp.titulo"/>
</h2>
</div>

<div class="well">
<s:if test="#application.listaUsuario.size>0">
<table width="80%" border="0" align="center" class="table table-bordered">
<thead>
<tr>
	<th scope="col"><s:text name="form.listaUsuarios.cabecera.id"/> </th>
	<th scope="col"><s:text name="form.listaUsuarios.cabecera.usuario"/></th>
	<th scope="col"><s:text name="form.listaUsuarios.cabecera.nombre"/></th>
	<th scope="col"><s:text name="form.listaUsuarios.cabecera.apellido"/></th>
	<th scope="col"><s:text name="form.listaUsuarios.cabecera.tipousu"/></th>
	<th scope="col"><s:text name="proyecto.asigresp.tabla.cabecera.responsable"/></th>
	<th scope="col"><s:text name="proyecto.asigresp.tabla.cabecera.selec"/></th>
</tr>
</thead>
<s:iterator value="#application.listaUsuResp">
<tr>
	<td align="center"><s:property value="idNumUsu"/></td>
	<td align="center"><s:property value="idUsu"/></td>
	<td align="justify"><s:property value="nomUsu"/></td>
	<td align="justify"><s:property value="apeUsu"/></td>
	<td align="center"><s:property value="tipoUsu.descTipoUsu"/></td>
	<td align="center">
		<s:if test="esResponsable==1">
			<s:text name="SI"/>
		</s:if>
		<s:else>
			<s:text name=""/>
		</s:else>
	</td>
	
	<td align="center">
		<s:radio list="#{idNumUsu:''}" name="codNusu" 
				 onclick ="retornaResp()"
		></s:radio>
	</td>
				
</tr>
</s:iterator>
</table>
</s:if>
</div>
</body>
</html>