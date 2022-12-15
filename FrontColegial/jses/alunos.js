userToken = document.cookie

console.log(userToken)

document.getElementById('tabalunobutton').onclick = function(){
    window.location.href = "http://127.0.0.1:5500/SATO/tabelaalunos.html"
}

document.getElementById('notabutton').onclick = async function () {
    notaRA = document.getElementById('ranota').value
    notaMat = document.getElementById('materianota').value
    notanota = document.getElementById('notanota').value

    data = { 'ra': notaRA, 'nomeMateria': notaMat, 'nota': notanota }

    sentNota = await fetch(
        'http://localhost:8080/aluno/nota?'+'ra='+notaRa+'&'+'nomeMateria='+notaMat+'&'+'nota='+notanota,
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

    if (sentNota != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

document.getElementById('addbutton').onclick = async function () {
    raAdd = document.getElementById('raadd').value
    nomeAdd = document.getElementById('nomeadd').value
    

    data = { 'nome': nomeAdd, 'ra': raAdd }

    console.log(data)
    sentAdd = await fetch(
        'http://localhost:8080/aluno/add?'+'nome='+nomeAdd+'&'+'ra='+raAdd,
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

    if (sentAdd.status != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}


document.getElementById('matbutton').onclick = async function () {
    raMat = document.getElementById('ramat').value
    turMat = document.getElementById('turmat').value


    data = { 'ra': raMat, 'tur': turAdd }

    sentMat = await fetch(
        'http://localhost:8080/aluno/matricula?'+'ra='+raMat+'&'+'tur='+turAdd,
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

    if (sentMat != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

document.getElementById('attbutton').onclick = async function () {
    raAtt = document.getElementById('raatt').value
    nomeAtt = document.getElementById('nomeatt').value
    turAtt = document.getElementById('turatt').value

    data = { 'ra': raAtt, 'nome': nomeAtt, 'tur': turAtt }

    sentAtt = await fetch(
        'http://localhost:8080/aluno/update?'+'ra='+raAtt+'&'+'nome='+nomeAtt+'&'+'tur='+turAtt,
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

    if (sentAtt != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

document.getElementById('buscabutton').onclick = async function () {
    console.log('eae')
    raBusca = document.getElementById('rabusca').value


    data = { 'ra': raBusca }

    sentBusca = await fetch(
        'http://localhost:8080/aluno/read?'+'ra='+raBusca,
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + userToken
            },

        }
    )

    if (sentBusca.status != 200) {
        alert("ERROR")
    } else {
        alert(dados.ra +' '+ dados.nome)
    }

}


document.getElementById('deletebutton').onclick = async function () {
    raDelete = document.getElementById('radelete').value


    data = { 'ra': raDelete}

    sentBusca = await fetch(
        'http://localhost:8080/aluno/remove?'+'ra='+raDelete,
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

    if (sentBusca != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}

