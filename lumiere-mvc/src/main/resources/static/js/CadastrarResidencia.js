addEventListener("load", () => {
	let imgsIconeElement = document.querySelectorAll('[name="iconePerfil"]');
	let iconeSelecionadoElement = document.getElementById('iconeSelecionado');
	
	imgsIconeElement[0].classList.add('foto-selecionada');
	iconeSelecionadoElement.value = imgsIconeElement[0].id;
	
	imgsIconeElement.forEach(imgIconeElement => {
	    imgIconeElement.addEventListener('click', () => {
			let imgIconeSelecionada = document.querySelector('.foto-selecionada');
            imgIconeSelecionada.classList.remove('foto-selecionada');
            imgIconeSelecionada = imgIconeElement;
            imgIconeSelecionada.classList.add('foto-selecionada');
            
	        let idIcone = imgIconeElement.id;
	        iconeSelecionadoElement.value = idIcone;
	    });
	})
})