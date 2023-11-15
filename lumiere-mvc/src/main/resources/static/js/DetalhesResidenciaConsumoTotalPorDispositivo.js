$.ajax({
    url : `/API/obterConsumoTotalPorDispositivos/${cdResidencia}`,
    type: 'POST',
    dataType : 'json',
    success : function(response) {
        if (response.length > 0) {
			json = response
			let consumos = [];
			let nomes = [];
			for(let i = 0; i < json.length; i++) {
			    let obj = json[i];
			    nomes.push(obj.nomeDispositivo);
				consumos.push(obj.consumoTotal);			
			}
			
			console.log(consumos);
			console.log(nomes);
		}
    },
    error : function(response) {
        console.log("Access Fail "+ response);
    }
})