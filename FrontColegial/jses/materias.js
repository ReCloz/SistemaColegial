userToken = document.cookie

console.log(userToken)

document.getElementById('addbutton').onclick = async function () {
    matAdd = document.getElementById('matadd').value

    data = { 'nome': turAdd }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/materia/add?'+'nome='+matAdd,
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
    matBusca = document.getElementById('matbusca').value

    data = { 'nome': matBusca }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/materia/read?'+'nome='+matBusca,
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
        alert("ERROR")
    } else {
        alert("Sucesso")
    }

}


document.getElementById('deletebutton').onclick = async function () {
    matDelete = document.getElementById('matdelete').value

    data = { 'nome': matDelete }

    console.log(data)
    sent = await fetch(
        'http://localhost:8080/materia/remove?'+'nome='+matDelete,
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