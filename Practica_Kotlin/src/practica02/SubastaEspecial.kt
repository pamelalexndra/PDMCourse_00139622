package practica02

fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}")
    println("Item B is sold at ${auctionPrice(null, 3000)}")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimunPrice: Int): Int {
    if (bid == null)
        return minimunPrice
    else
        return bid.amount

    // También se puede resolver con el operador Elvis
    // return bid?.amount ?: minimumPrice
}