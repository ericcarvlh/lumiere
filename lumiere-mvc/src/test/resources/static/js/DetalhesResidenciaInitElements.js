function inicializaElementosConsumoMedioAnual(anos) {	
	// criando os elementos para o relatório anual
	let relatorioAnualElement = document.getElementById("relatorioAnual")
	
	let year = 0;
	let quantidadeAnos = anos.length
	if (quantidadeAnos > 1) {
		for (let index = 0; index <= quantidadeAnos; index++) {
			let label = document.createElement('label')
		    label.setAttribute('for', index)
		    
		    if (index == 0) {
		    	label.textContent = `Últimos ${quantidadeAnos} anos`
		    	year = (new Date().getFullYear() - (quantidadeAnos)) - 1
		    } else 
				label.textContent = year
						
			let radio = document.createElement('input')
			radio.setAttribute('class', 'radio')
			radio.setAttribute('type', 'radio')
			radio.setAttribute('name', 'opcaoRelatorioAnual')
			radio.setAttribute('value', year)
			radio.setAttribute('id', year)
		
			relatorioAnualElement.appendChild(radio)
			relatorioAnualElement.appendChild(label)
			
			year += 1
		}
		
		let radiosButton = document.getElementsByClassName('radio')
		radiosButton[0].checked = true	
	}
}