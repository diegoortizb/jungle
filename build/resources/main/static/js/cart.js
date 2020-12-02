
document.addEventListener('DOMContentLoaded',() => {
    document.getElementById("submit").addEventListener("click", function () {
        let name = document.getElementById('name').value
        let cc = document.getElementById('cc').value
        let exp = document.getElementById('exp').value
        let amount = document.getElementById('amount').value
        let trans = document.getElementById('trans').value
        let vendor = document.getElementById('vendor').value

        let request = new XMLHttpRequest()
        request.open('POST', 'http://blitz.cs.niu.edu/CreditCard/')
        request.setRequestHeader('Content-Type', 'application/json')
        request.setRequestHeader('Accept', 'application/json')

        let formData = JSON.stringify({
            'name': name,
            'cc': cc,
            'exp': exp,
            'amount': amount,
            'trans': trans,
            'vendor': vendor
        })

        request.send(formData)

        console.log(request.response)

    })
})
