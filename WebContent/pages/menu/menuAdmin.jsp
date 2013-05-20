<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!-- este menu tiene que ir en la parte izquierda de la pagina del administrador -->
<div class="well">
<ul class="nav nav-list">
  	<li class="nav-header">  	
  		<h3><s:text name="menu.titulo"/></h3>  		
	</li>
	
   	<li >
  	<s:url action="regUsu" id="nuevo"></s:url> 
			<s:a href="%{nuevo}">
				<i class="icon-user"></i>
				<s:text name="menu.registrarnuevo"/>
			</s:a>
  	</li>
  	
  	<li>
  	<s:url action="listarUsu" id="listar"></s:url> 
			<s:a href="%{listar}">
			<i class="icon-list"></i>
				<s:text name="menu.listarusu"/>
			</s:a>
  	</li>
  <li class="divider"></li>
  <li>
  	<s:url action="logout" id="salir"></s:url>
				<s:a href="%{salir}">
				<i class="icon-share-alt"></i>
					<s:text name="menu.logout"/>
				</s:a>
  </li>
</ul>
</div>