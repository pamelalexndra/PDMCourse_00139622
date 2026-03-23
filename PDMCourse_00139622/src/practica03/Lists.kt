package practica03

fun main() {
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars")
    println(solarSystem.size)

    println(solarSystem[2])
    println(solarSystem.get(3))

    println(solarSystem.indexOf("Earth"))
    println(solarSystem.indexOf("Pluto"))

    for (plant in solarSystem) {
        println(plant)
    }

    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")

    solarSystem[3] = "Future Moon"
    solarSystem.removeAt(9)

    println(solarSystem.contains("Pluto"))
    println("Future Moon" in solarSystem)
}