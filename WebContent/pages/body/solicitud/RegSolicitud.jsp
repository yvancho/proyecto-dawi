<%@ taglib prefix="s" uri="/struts-tags"%>


<h2 align="center">
	<s:text name="form.solicitud.titulo"></s:text>
</h2>


<s:form action="UploadUserDoc" method="post"
		enctype="multipart/form-data">

	<table width="80%" border="0" align="center">
		<tr>
			<td>
				<s:text name="form.aprobacion.solicitud.descripcion"/>
				<s:textfield name="solicitud.descSol"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<s:text name="form.solicitud.observaciones"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<s:textarea name="solicitud.obsSol" rows="4" cssClass="input-xlarge"/>
				
				<s:actionerror/>
			</td>
		</tr>
		<tr>
			<td width="50%"></td>
		</tr>

		<tr>
			<td>
				<s:file name="docusuario" accept="application/pdf" required="true"/>
				<s:label>- Sólo archivos PDF</s:label>
				<s:label>- 2MB máximo</s:label>
			</td>
			<td width="50%">
				
			</td>
		</tr>

		<tr>
			<td>
				<s:submit value="%{getText('form.registrar.botonReg')}" align="center" cssClass="btn btn-primary"/>
			</td>
		</tr>

		<tr>
			<td><h3>
					<s:actionerror />
				</h3></td>
		</tr>
	</table>

</s:form>
