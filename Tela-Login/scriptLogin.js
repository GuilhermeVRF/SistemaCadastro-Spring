const formulario = document.querySelector("form");
const inputEmail = document.getElementById("email");
const inputSenha = document.getElementById("senha");

function logar(){
    fetch("http://localhost:8080/usuarios/login",
        {
            headers:{
                "Accept": "application/json",
                "Content-Type": "application/json"
            },

            method: "POST",
            body: JSON.stringify({
                email: inputEmail.value,
                senha: inputSenha.value
            })
        })
        .then(function(res) {console.log(res)})
        .catch(function(res){console.log(res)})
}

function limpar(){
    inputEmail.value = ""; 
    inputSenha.value = ""; 
}

formulario.addEventListener("submit", function (event){
    event.preventDefault();
    logar();    
})