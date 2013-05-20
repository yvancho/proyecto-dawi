<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2 align="center">
	<s:text name="solicitud.listasol.titulo"/>	
</h2>

<s:if test="listaSol.size>0">

<table width="80%" border="0" align="center" class="table table-bordered">
	<thead>
		<tr >
			<th scope="col"><s:text name="solicitud.listasol.cabecera.id"/> </th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.desc"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.fecha"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.estado"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.obser"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.sustento"/></th>
			
		</tr>
	</thead>
		<s:iterator value="listaSol">
		<tr>
			<td align="center"><s:property value="idSol"/></td>
			<td align="left">
				<s:url id="bajar" namespace="/" action="bajarSol">
					<s:param name="codSol">
						<s:property value="idSol"/>
					</s:param>		
				</s:url>
				<s:a href="%{bajar}">
					<s:property value="descSol"/>
				</s:a>				
			</td>
			<td align="center"><s:property value="fecRegSol"/></td>
			<td align="center"><s:property value="estSol.descEstSol"/></td>
			
			<s:if test="obsSol != null">
				<td align="center">
				<s:url action="detalleObs" id="detalle">
					<s:param name="codSol">
						<s:property value="idSol"/>
					</s:param>			
				</s:url>
				<s:a href="%{detalle}">
					<s:text name="solicitud.listasol.celda.obs"/>
				</s:a>
				</td>	
			</s:if>
			<s:else>
				<td align="center">
					<s:text name="solicitud.listasol.celda.obsvacia"></s:text>
				</td>
			</s:else>		
			
			<s:if test="susDes != null">
				<td align="center">
					<s:url action="detSustento" id="sustento">
						<s:param name="codSol">
							<s:property value="idSol"/>
						</s:param>
					</s:url>
					<s:a href="%{sustento}">
						<s:text name="solicitud.listasol.celda.sus"></s:text>
					</s:a>
				</td>
			</s:if>
			<s:else>
				<td align="center">
					<s:text name="solicitud.listasol.celda.susvacio"></s:text>
				</td>
			</s:else>
			
		</tr>
		</s:iterator>
</table>
</s:if>
<s:else>
	<h2>
		<s:text name="solicitud.listasol.vacia"/>
	</h2>
</s:else>