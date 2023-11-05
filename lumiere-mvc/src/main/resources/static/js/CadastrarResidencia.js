addEventListener("load", () => {
	let imgsIconeElement = document.querySelectorAll('[name="iconePerfil"]');
	
	imgsIconeElement[0].classList.add('foto-selecionada');
	
	imgsIconeElement.forEach(imgIconeElement => {
	    imgIconeElement.addEventListener('click', () => {
			let imgIconeSelecionada = document.querySelector('.foto-selecionada');
            imgIconeSelecionada.classList.remove('foto-selecionada');
            imgIconeSelecionada = imgIconeElement;
            imgIconeSelecionada.classList.add('foto-selecionada');
            
            let iconeSelecionadoElement = document.getElementById('iconeSelecionado');
	        let idIcone = imgIconeElement.id;
	        iconeSelecionadoElement.value = idIcone;
	    });
	})
})