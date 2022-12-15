
userLogin = ''
pword = ''
userToken = ''



document.getElementById('submit').onclick = function () {
    userLogin = document.getElementById('user').value
    pword = document.getElementById('pword').value

    getToken()
}

async function getToken() {
    console.log('eae')

    data = { 'username': userLogin, 'password': pword }

    gotToken = await fetch('http://localhost:8080/api/v1/auth',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },

            body: JSON.stringify(data)
        }
    )

    dados = await gotToken.json()

    userToken = dados.token
    console.log(userToken)

    document.cookie = userToken

    if (gotToken.status != 200) {
        alert("ERROR")
    } else {
        window.location.href = "http://127.0.0.1:5500/SATO/index.html";
    }
}
