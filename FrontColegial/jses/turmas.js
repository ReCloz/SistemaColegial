userToken = document.cookie

console.log(userToken)

document.getElementById('addbutton').onclick = async function () {
    turAdd = document.getElementById('turadd').value

    data = { 'nome': turAdd }

    console.log(data)
    sentAdd = await fetch(
        'http://localhost:8080/turma/add?'+'nome='+turAdd,
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


document.getElementById('buscabutton').onclick = async function () {
    turBusca = document.getElementById('turbusca').value

    data = { 'nome': turBusca }

    console.log(data)
    sentAdd = await fetch(
        'http://localhost:8080/turma/read?'+'nome='+turBusca,
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

    if (sentAdd.status != 200) {
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}


document.getElementById('deletebutton').onclick = async function () {
    turDelete = document.getElementById('turdelete').value

    data = { 'nome': turDelete }

    console.log(data)
    sentAdd = await fetch(
        'http://localhost:8080/turma/remove?'+'nome='+turDelete,
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