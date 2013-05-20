<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="shortcut icon" href="img/ico/mvv3.ico">
<script type="text/javascript" src=js/jquery-1.7.2.js></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
$('.carousel').carousel({
	  interval: 2000
	});
</script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<style type="text/css">

body {
	background-image: url(img/bg_blue3.jpg);
	margin-top: 0px;
	background-repeat: repeat;
}


</style>

<title>&nbspSISTEMA INTEGRAL DE GESTIÓN DE REQUERIMIEMTOS DE
	SOFTWARE Y PROYECTOS TI&nbsp</title>

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

	<s:url id="idiomaEs" action="idioma">
		<s:param name="request_locale">es</s:param>
	</s:url>

	<s:url id="idiomaEn" action="idioma">
		<s:param name="request_locale">en</s:param>
	</s:url>
 
<table width="80%" align="center" class="table_size">
	<tr>
		<th height="230" colspan="2" align="center" valign="middle"
				scope="col">
				<img src="img/background_esp.jpg" width="1200" height="516" alt="logo" longdesc="img/logo02.jpg">
         </th>
		</tr>
		<tr><td><p>&nbsp;</p> </td></tr>
		<tr>
			<td width="50%" align="center"><p>
					<img src="img/peru.gif" width="80" height="58" alt="bandera_peru"
						longdesc="img/peru.gif">
				</p>
				<h2>
					<s:a href="%{idiomaEs}">
						<s:text name="inicio.idioma.espanol"></s:text>
					</s:a>
				</h2>
			</td>
			
	  		<td width="50%" align="center"><p>
					<img src="img/usa.gif" width="84" height="57" alt="bandera_usa"
						longdesc="img/usa.gif">
				</p>
				<h2>
					<s:a href="%{idiomaEn}">
						<s:text name="inicio.idioma.ingles"></s:text>
					</s:a>
				</h2></td>
		</tr>
		<tr><td><p>&nbsp;</p> </td></tr>
		<tr>
			<td colspan="2">
			
			<div class="container">
				<div class="row">
					<div class="span13">
						<h3>¿Quiénes somos?</h3>
						<p>
						Las tecnologías de la información y la comunicación (TIC o bien NTIC para nuevas tecnologías de la información y de la comunicación) agrupan los elementos y las técnicas usados en el tratamiento y la transmisión de la información, principalmente la informática, Internet y las telecomunicaciones.
Por extensión, designan un sector de actividad económica.
«Las tecnologías de la información y la comunicación no son ninguna panacea ni fórmula mágica, pero pueden mejorar la vida de todos los habitantes del planeta. Se dispone de herramientas para llegar a los Objetivos de Desarrollo del Milenio, de instrumentos que harán avanzar la causa de la libertad y la democracia y de los medios necesarios para propagar los conocimientos y facilitar la comprensión mutua» (Kofi Annan, Secretario general de la Organización de las Naciones Unidas, discurso inaugural de la primera fase de la WSIS, Ginebra 2003)1
El uso de las tecnologías de la información y la comunicación ayudaría a disminuir la brecha digital aumentando el conglomerado de usuarios que las utilicen como medio tecnológico para el desarrollo de sus actividades.
						</p>
					</div>
					<div class="span13">
					 
						<div id="myCarousel" class="carousel slide"> 
							<div class="carousel-inner" align="left">
								<div class="active item">
									<img alt="gnt_trabajo_001" src="img/gente/gnt001.jpg">
									<div class="carousel-caption">
                  						<h4>Bienvenidos!</h4>
                  						<p>Cras justo tretus, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                					</div>
								</div>
    							<div class="item">
									<img alt="gnt_trabajo_002" src="img/gente/gnt002.jpg">
									<div class="carousel-caption">
                  						<h4>Visón Empresarial</h4>
                  						<p>Cras justo tretus, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                					</div>
								</div>
								<div class="item">
									<img alt="gnt_trabajo_003" src="img/gente/gnt003.jpg">
									<div class="carousel-caption">
                  						<h4>Misón Empresarial</h4>
                  						<p>Cras justo tretus, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                					</div>
								</div>
								
							</div>
							<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
							<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
						</div>					
					</div>
				</div>
			</div>
			
            </td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="pages/footer.jsp"></jsp:include>
			</td>
		</tr>
		<tr><td><p>&nbsp;</p> </td></tr>
	</table>
</body>
</html>