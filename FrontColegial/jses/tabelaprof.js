userToken = document.cookie
dados = ''

console.log(userToken)

printtabela = async function(){
    sent = await fetch(
        'http://localhost:8080/professor/all',
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + userToken
            },
            
        }
    )
    
    dados = await sent.json()
    
    if (sent.status != 200) {
        alert("ERROR")
        return 
    } 
    
    tabela = dados.map((table)=> {
        return '<tr><td>' + table.nome + '</td><td>' + table.cpf + '</td></tr>'
    })
    
    document.getElementById('tabela').innerHTML = tabela
}

printtabela()