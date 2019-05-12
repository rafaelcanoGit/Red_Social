
document.querySelector('#boton').addEventListener('click', function() { 
		traerDatos2('#table72','https://www.datos.gov.co/resource/fi6s-bvhz.json')
	});

function traerDatos() {
	console.log("En la funcion traerDatos");

	const xhttp = new XMLHttpRequest();

	xhttp.open('GET', 'https://www.datos.gov.co/resource/ax3m-2qmb.json');

	xhttp.send();
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			let datos = JSON.parse(this.responseText);

			let res = document.querySelector('#res');
			res.innerHTML = '';

			for(let item of datos) {
				res.innerHTML += `<tr>
	      				<td>${item.municipio}</td>
	      				<td>${item.direcci_n}</td>
	      				<td>${item.estado}</td>
	    			</tr>`;
			}
		}
	}
}

function traerDatos2(destino, fuente) {
	console.log("En la funcion traerDatos");

	const xhttp = new XMLHttpRequest();

	xhttp.open('GET', fuente);

	xhttp.send();
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);

			let datos = JSON.parse(this.responseText);

			let res = document.querySelector(`${destino} tbody`);
			res.innerHTML = '';

			let cab = document.querySelector(`${destino} thead`);

			let item = datos [0]; 
			let cabecera = '';
			for (var key in item) {
				cabecera += `<th>${key}</th>`;
			}
			cab.innerHTML += `<tr>${cabecera}</tr>`;


			for(let item of datos) {
				resul = '';
				for (var key in item) {
					resul += `<td>${item[key]}</td>`;
				}
				res.innerHTML += `<tr>
	      				${resul}
	    			</tr>`;
			}
		}
	}
}

function traerDatos() {
	console.log("En la funcion traerDatos");

	const xhttp = new XMLHttpRequest();

	xhttp.open('GET', 'https://www.datos.gov.co/resource/ax3m-2qmb.json');

	xhttp.send();
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			let datos = JSON.parse(this.responseText);

			let res = document.querySelector('#res');
			res.innerHTML = '';

			for(let item of datos) {
				res.innerHTML += `<tr>
	      				<td>${item.municipio}</td>
	      				<td>${item.direcci_n}</td>
	      				<td>${item.estado}</td>
	    			</tr>`;
			}
		}
	}
}