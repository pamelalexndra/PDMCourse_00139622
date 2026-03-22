package practica02

// Clase que pueda representar la estructura de una canción

class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, interpretada por $artist se lanzó en $yearPublished")
    }
}

fun main() {
    val myFavoriteSong = Song("Remember this", "NF", 2017, 57000000)

    myFavoriteSong.printDescription()

    if (myFavoriteSong.isPopular) {
        println("Esta canción es popular")
    } else {
        println("Esta canción no es tan popular")
    }
}