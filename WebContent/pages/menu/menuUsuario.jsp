<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!-- este menu tiene que ir en la parte derecha de los usuarios -->

<!-- 
<s:if test="#session.s_usuario != null">
	<s:if test="#session.s_usuario.getTipoUsu().getIdTipoUsu() != 'ADM'">
		<div class="btn-group" align="center">  
          <a class="btn btn-primary" href="#">
          <i class="icon-user icon-white"></i> Perfil
          </a>  
          <a class="btn btn-small btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>  
          <ul class="dropdown-menu">
            <li>
            	<s:url action="logout" id="salir"></s:url>
				<s:a href="%{salir}">
				<i class="i"></i>
					<s:text name="menu.logout"/>
				</s:a>
            </li>  
          </ul>  
		</div>
	</s:if>
				
</s:if>
 -->