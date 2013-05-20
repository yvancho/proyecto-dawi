<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EXITO</title>
</head>
<body>
	<img alt="EEEEXITO" src="img/Exito_meme.jpg">
	<h3>
		<s:actionerror />
	</h3>
	<script type="text/javascript">
		setTimeout('Redirect()', 3000);
		function Redirect() {
			location.href = '/DAW1_ProyGestionReq/';
		}
	</script>
</body>
</html>