function calcul(event){
	event.preventDefault();
	let a = parseInt(document.querySelector("#a").value, 10);
	let b = parseInt(document.querySelector("#b").value, 10);
	let result = a + b;
	document.getElementById('myForm:result').value = result;
}

function setJSValue(){
	document.getElementById('myForm:jsValue').value = "Hello JS";
}