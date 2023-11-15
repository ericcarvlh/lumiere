const pathURL = (location.pathname).substring(1)
const cdResidencia = pathURL.split("/")[2]

$.ajax({
    url : `/API/obterConsumoMedioAnual/${cdResidencia}`,
    type: 'POST',
    dataType : 'json',
    success : function(response) {
        if (response.length > 0) {
			json = response
			let anos = []
			let consumos = []
			for(let i = 0; i < json.length; i++) {
			    let obj = json[i]
			    anos.push(obj.ano)
				consumos.push(obj.consumoTotal)		
			}
			
			inicializaElementosConsumoMedioAnual(anos)
			teste(anos)
			inicializaConsumoAnual(consumos, anos)
		}
    },
    error : function(response) {
        console.log("Access Fail "+ response)
    }
})

function inicializaConsumoAnual(consumos, anos) {
	let relatorioAnualElement = document.getElementById('relatorioAnual')
	
	let div = document.createElement('div')
	div.setAttribute('style', 'margin-top: 5%;')
	div.setAttribute('id', 'div-relatorio-anual')
	relatorioAnualElement.appendChild(div)
	
	let canvas = document.createElement('canvas')
	canvas.setAttribute('id', 'canvas-relatorio-anual')
	canvas.setAttribute('style', 'max-width: 600px; max-height: 400px;')
	div.appendChild(canvas)
	
	montaGraficoConsumoAnual('canvas-relatorio-anual', consumos, anos)
}

function montaGraficoConsumoAnual(nomeCanvas, consumos, anos) {
	const ctx = document.getElementById(nomeCanvas)
		
	chartGastoMedioAnual = new Chart(ctx, {
        type: 'line',
        data: {
  			labels: anos,
  			datasets: [{
	    		label: 'Gasto Anual',
	    		data: consumos,
			    fill: false,
			    borderColor: 'rgb(255, 220, 114)',
			    tension: 0.1,
			    pointStyle: 'circle',
		        pointRadius: 10,
		        pointHoverRadius: 15
  			}]
  		},
        options: {
		    responsive: true,
		    plugins: {
		      title: {
		        display: true,
		        text: "Sua média de gasto Anual",
				font: {
		          size: 20,
		          family: 'lexand exa',
		          weight: 'bold',
		        },
		      },
		      legend: {
			    display: false
			  }
		    },
		    scales: {
				x: {
					display: true,
					title: {
						display: true,
						text: 'ANO',
					}
				},
				y: {
					display: true,
					title: {
						display: true,
						text: 'REAIS',
					}
				}
      		}
		}
    })
}