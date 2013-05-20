<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="img/ico/mvv3.ico">
<script type="text/javascript" src=js/jquery-1.7.2.js></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>&nbspSISTEMA INTEGRAL DE GESTIÓN DE REQUERIMIEMTOS DE
	SOFTWARE Y PROYECTOS TI&nbsp</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<style type="text/css">
body {
	background-image: url(img/bg_blue3.jpg);
	background-repeat: repeat-y;
	margin-top: 0px;
}
</style>

<!--[if lt IE 9]>  
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>  
    <![endif]-->

<SCRIPT lang=JavaScript>
	var txt = document.title;
	var espera = 100;
	var refresco = null;
	function rotulo_title() {
		document.title = txt;
		txt = txt.substring(1, txt.length) + txt.charAt(0);
		refresco = setTimeout("rotulo_title()", espera);
	}
	rotulo_title();
	
</SCRIPT>



</head>
<body>
	<table width="80%" border="0" align="center">
		<tr>
			<th height="230" colspan="3" align="center" valign="middle"
				class="titulo_header" scope="col">
				<tiles:insertAttribute name="header" />

			</th>
		</tr>
		<tr>
			<td valign="top" width="200px"><tiles:insertAttribute
					name="menu" /></td>
			<td width="300" rowspan="2" style="width: 600px; "><tiles:insertAttribute name="body" />
			</td>
			<td valign="top" width="200px" align="center" style="width: 170px; ">
			<tiles:insertAttribute name="menuUsuario"/>
			</td>
		</tr>
		<tr>
			<td valign="top" width="200px"></td>
			<td width="200">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>

</body>
<script lang="javascript" type="text/javascript"
	src="js/datetimepicker.js">
	//Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
	//Script featured on JavaScript Kit (http://www.javascriptkit.com)
	//For this script, visit http://www.javascriptkit.com
</script>

</html>