const pathURL = (location.pathname).substring(1);
const cdResidencia = pathURL.split("/")[2];

$.ajax({
    url : `/API/obterGastoMedioAnualPorResidencia/${cdResidencia}`,
    type: 'POST',
    dataType : 'json',
    success : function(response) {
        if (response.length > 0) {
			json = response
			let consumos = [];
			let anos = [];
			for(let i = 0; i < json.length; i++) {
			    let obj = json[i];
			    anos.push(obj.ano);
				consumos.push(obj.consumoTotal);			
			}
			
			inicializaGraficoRelatorioAnual(consumos, anos);
		}
    },
    error : function(response) {
        console.log("Access Fail "+ response);
    }
})

function inicializaGraficoRelatorioAnual(consumos, anos) {
	let relatorioAnualElement = document.getElementById('relatorioAnual');
	
	let div = document.createElement('div');
	div.setAttribute('style', 'margin-top: 5%;');
	div.setAttribute('id', 'div-relatorio-anual');
	relatorioAnualElement.appendChild(div);
	
	let canvas = document.createElement('canvas');
	canvas.setAttribute('id', 'canvas-relatorio-anual');
	canvas.setAttribute('style', 'max-width: 600px; max-height: 400px;');
	div.appendChild(canvas);
	
	montaGraficoRelatorioAnual('canvas-relatorio-anual', consumos, anos);	
}

function montaGraficoRelatorioAnual(nomeCanvas, consumos, anos) {
	let ctx = document.getElementById(nomeCanvas);
		
	new Chart(ctx, {
        type: 'line',
        data: {
  			labels: anos,
  			datasets: [{
	    		label: 'Sua média de gasto Anual',
	    		data: consumos,
	    		fill: false,
	    		borderColor: 'rgb(75, 192, 192)',
	    		tension: 0.1
  			}]
  		},
        options: {
		    responsive: true,
		    plugins: {
		      title: {
		        display: true,
		        text: (ctx) => 'Point Style: ' + ctx.chart.data.datasets[0].pointStyle,
		      }
		    }
		}
    })
}