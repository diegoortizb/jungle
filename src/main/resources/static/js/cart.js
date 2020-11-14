

function addTotalsCart() {
    var total;
    let cart = document.getElementById("cart");
    for (var i = 0; i < cart.length; i++) {
        let itemPrice = cart[i].getElementsByTagName("price");
        total = itemPrice;
    }
    document.getElementById('totalSum').innerHTML = total;
}