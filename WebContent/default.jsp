<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>&nbspSISTEMA INTEGRAL DE GESTIÓN DE REQUERIMIEMTOS DE
	SOFTWARE Y PROYECTOS TI&nbsp</title>
<link rel="shortcut icon" href="img/ico/mvv3.ico" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-latest.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>

<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav">
					<li class="active"><a class="brand" href="#">EMPRESA</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Portfolio</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<ul class="nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Idioma<b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<s:url id="idiomaEs" action="idioma">
								<s:param name="request_locale">es</s:param>
							</s:url>

							<s:url id="idiomaEn" action="idioma">
								<s:param name="request_locale">en</s:param>
							</s:url>

							<li><s:a href="%{idiomaEs}">
									<s:text name="inicio.idioma.espanol" />
								</s:a></li>

							<li><s:a href="%{idiomaEn}">
									<s:text name="inicio.idioma.ingles" />
								</s:a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
	
	
	
	</div>

</body>
</html>