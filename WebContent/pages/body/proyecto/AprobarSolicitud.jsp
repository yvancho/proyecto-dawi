<%@ taglib prefix="s" uri="/struts-tags"%> 

<h2 align="center">
	<s:text name="form.aprobacion.solicitud.titulo"></s:text>
</h2>

<s:if test="#application.listarSolEst.size>0">

<s:form action="aprobarSol" method="post">

<table width="100%" border="0" align="center" class="table table-bordered">
	<thead>
		<tr >
			<th scope="col"><s:text name="solicitud.listasol.cabecera.id"/> </th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.desc"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.area"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.fecha"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.obser"/></th>
			<th scope="col"><s:text name="solicitud.listasol.cabecera.seleccion"/></th>
			
		</tr>
	</thead>
		<s:iterator value="#application.listarSolEst">
		<tr>
			<td align="center">
				<s:property value="idSol"/>
			</td>
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
			
			<td align="center">
				<s:property value="area.descArea"/>
			</td>
			
			<td align="center">
				<s:property value="fecRegSol"/>
			</td>				
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
			<td align="center">
				<s:radio list="#{idSol:''}" name="codSol" ></s:radio>
			</td>			
		</tr>
		</s:iterator>
		
</table>
<div class="span9 well">
<h3><s:text name="Acción "/></h3>
	<s:select list="#{'1':'Aprobar', '2':'Desaprobar'}"
	  		  name="estSol"/>
	  		  
	<s:submit value="%{getText('forms.aplicar')}" cssClass="btn btn-primary"/>
<h3><s:actionerror/></h3>
</div>
</s:form>
</s:if>
<s:else>
	<h2>
		<s:text name="solicitud.listasol.vacia"/>
	</h2>
</s:else>