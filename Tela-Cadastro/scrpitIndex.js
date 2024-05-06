const formulario = document.querySelector("form");
const inputNome = document.getElementById("nome");
const inputEmail = document.getElementById("email");
const inputTelefone = document.getElementById("telefone");
const inputEndereco = document.getElementById("endereco");
const inputSenha = document.getElementById("senha");

//Gerando um arquivo JSON e enviando para o endpoint
function cadastrar(){
    fetch("http://localhost:8080/usuarios", 
        {
            headers:{
                "Accept": "application/json",
                "Content-Type": "application/json" 
            },

            method: "POST",
            body: JSON.stringify({
                nome: inputNome.value,
                email: inputEmail.value,
                telefone: inputTelefone.value,
                endereco: inputEndereco.value,
                senha: inputSenha.value
            })
        })
        .then(function(res) {console.log(res)})
        .catch(function(res){console.log(res)})
}

function limpar(){
    inputNome.value = "";
    inputEmail.value = "";    
    inputTelefone.value = "";
    inputEndereco.value = "";
    inputTelefone.value = "";
    inputSenha.value = "";
}

formulario.addEventListener("submit", function (event){
    event.preventDefault();
    cadastrar();
    limpar();
});
