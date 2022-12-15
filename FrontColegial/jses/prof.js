userToken = document.cookie

console.log(userToken)

document.getElementById('tabprofbutton').onclick = function(){
    window.location.href = "http://127.0.0.1:5500/SATO/tabelaprof.html"
}

document.getElementById('addbutton').onclick = async function () {
    cpfAdd = document.getElementById('cpfadd').value
    nomeAdd = document.getElementById('nomeadd').value
    

    data = { 'nome': nomeAdd, 'cpf': raAdd }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/professor/add?'+'nome='+nomeAdd+'&'+'ra='+cpfAdd,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + userToken
            },
            body: JSON.stringify(data)
        }
    )

    if (sent.status != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

document.getElementById('buscabutton').onclick = async function () {
    cpfBsuca = document.getElementById('cpfbusca').value
       

    data = { 'cpf': cpfBusca }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/professor/read?'+'cpf='+cpfBusca,
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + userToken
            },
            body: JSON.stringify(data)
        }
    )

    if (sent.status != 200) {
        alert(dados.ra +' '+ dados.nome)
    } else {
        alert("Sucesso")
    }

}

document.getElementById('deletebutton').onclick = async function () {
    cpfDelete = document.getElementById('cpfadd').value
        

    data = { 'cpf': cpfDelete }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/professor/remove?'+'ra='+cpfDelete,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + userToken
            },
            body: JSON.stringify(data)
        }
    )

    if (sent.status != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

document.getElementById('conbutton').onclick = async function () {
    cpfCon = document.getElementById('cpfcon').value
    matCon = document.getElementById('matcon').value
    

    data = { 'cpf': cpfCon, 'mat': matCon }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/professor/contrato?'+'cpf='+cpfCon+'&'+'mat='+matCon,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + userToken
            },
            body: JSON.stringify(data)
        }
    )

    if (sent.status != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

document.getElementById('addbutton').onclick = async function () {
    cpfTur = document.getElementById('cpftur').value
    turTur = document.getElementById('turtur').value
    

    data = { 'cpf': cpfTur, 'classe': turTur }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/professor/aulas?'+'cpf='+cpfTur+'&'+'classe='+turTur,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + userToken
            },
            body: JSON.stringify(data)
        }
    )

    if (sent.status != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

