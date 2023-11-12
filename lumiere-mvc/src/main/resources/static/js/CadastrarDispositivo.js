addEventListener("load", () => {
	const pathURL = (location.pathname).substring(1);
	const cdResidencia = pathURL.split("/")[2];
	
	let cdResidenciaElement = document.getElementById('cdResidencia');
	cdResidenciaElement.value = cdResidencia;
});