$.ajax({
    url : `/API/obterConsumoTotalPorDispositivos/${cdResidencia}`,
    type: 'POST',
    dataType : 'json',
    success : function(response) {
        if (response.length > 0) {
			json = response
			let nomes = []
			let consumos = []
			for(let i = 0; i < json.length; i++) {
			    let obj = json[i];
			    nomes.push(obj.nomeDispositivo)
				consumos.push(obj.consumoTotal)		
			}
			
			inicializaGraficoAnual(nomes, consumos)
		}
    },
    error : function(response) {
        console.log("Access Fail "+ response)
    }
})

function inicializaGraficoAnual(nomes, consumos) {	
	montaGraficoConsumoTotalPorDispositivo('gasto-total-por-dispositivo', nomes, consumos)
}

function montaGraficoConsumoTotalPorDispositivo(nomeCanvas, nomes, consumos) {
	let ctx = document.getElementById(nomeCanvas)
	
	new Chart(ctx, {
        type: 'pie',
        data: {
  			labels: nomes,
  			datasets: [{
	    		label: 'Consumo total',
	    		data: consumos,
	    		fill: false,
  			}]
  		},
        options: {
			responsive: true,
		    plugins: {
			  legend: {
				position: "left",
			  },
			  title: {
		        display: true,
		        text: 'Gestão de gasto atual',
		        align: 'start',
				font: {
		          size: 20,
		          family: 'lexand exa',
		          weight: 'bold',
		        },
		      }
		    }
		}
    })
}