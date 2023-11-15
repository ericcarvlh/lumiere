addEventListener("load", () => {	
	// criando os elementos para o relatório anual
	let relatorioAnualElement = document.getElementById("relatorioAnual")
	
	let year = 0;
	for (let index = 0; index <= 3; index++) {
		let label = document.createElement('label')
	    label.setAttribute('for', index)
	    
	    if (index == 0) {
	    	label.textContent = "Últimos 3 anos"
	    	year = new Date().getFullYear() - 3
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
})