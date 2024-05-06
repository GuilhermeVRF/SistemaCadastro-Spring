const tabelaCadastros = document.querySelector("table");
document.body.onload= gerarTabela();

function preencherTabela(){
    fetch("http://localhost:8080/usuarios")
    .then((resp) => resp.json())
    .then(function(cadastros) {
        console.log(cadastros)
        for(pos = 0; pos < cadastros.length; pos++){
            let novaLinha = document.createElement("tr");
    
            let tdNome = document.createElement("td");
            tdNome.innerHTML = cadastros[pos].nome;
            novaLinha.appendChild(tdNome);
    
            let tdEmail = document.createElement("td");
            tdEmail.innerHTML = cadastros[pos].email;
            novaLinha.appendChild(tdEmail);
    
            let tdTelefone = document.createElement("td");
            tdTelefone.innerHTML = cadastros[pos].telefone;
            novaLinha.appendChild(tdTelefone);
    
            let tdEndereco = document.createElement("td");
            tdEndereco.innerHTML = cadastros[pos].endereco;
            novaLinha.appendChild(tdEndereco);
    
            let tdSenha = document.createElement("td");
            tdSenha.innerHTML = cadastros[pos].senha;
            novaLinha.appendChild(tdSenha);
    
            tabelaCadastros.appendChild(novaLinha);
        }
    })
    .catch(function(res) {console.log(res)});
}

function gerarCabecalho(){
    const atributosTabela = ["Nome", "E-mail", "Telefone","Endereço", "Senha"];
    for(pos = 0; pos < 5; pos++){
        let th = document.createElement("th");
        th.innerHTML = atributosTabela[pos];
        tabelaCadastros.appendChild(th);
    }
}

function gerarTabela(){
    gerarCabecalho();
    preencherTabela();
}