<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
</head>
 
<body>
 
	<select id="miSelect">
	</select>
 
</body>
</html>
 
<script>
 
var miSelect=document.getElementById("miSelect");
 
// Creamos un objeto option
var miOption=document.createElement("option");
 
// Añadimos las propiedades value y label
miOption.setAttribute("value","1");
miOption.setAttribute("label","casa");
 
// Añadimos el option al select
miSelect.appendChild(miOption);
 
 
var miOption2=document.createElement("option");
miOption2.setAttribute("value","2");
miOption2.setAttribute("label","avion");
 
// Dejamos seleccionado este valor por defecto
miOption2.setAttribute("selected","true");
 
miSelect.appendChild(miOption2);
 
 
var miOption3=document.createElement("option");
 
miOption3.setAttribute("value","3");
miOption3.setAttribute("label","moto");
 
// Dejamos este valor desactivado
miOption3.setAttribute("disabled","true");
 
miSelect.appendChild(miOption3);
 
</script>