package practica02

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhonScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight")
    }
}

class FoldablePhone(var isFolded: Boolean = true) : Phone() {
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        } else {
            println("Cannot switch on: The phone is folded")
        }
    }

    fun fold() {
        isFolded = true
        switchOff() // Apagar plantalla al plegar
        println("The phone is now folded")
    }

    fun unfold() {
        isFolded = false
        println("The phone is now unfolded")
    }
}

fun main() {
    val myFoldable = FoldablePhone()

    // Intento de encender mientras está plegado
    myFoldable.switchOn()
    myFoldable.checkPhonScreenLight()

    // Desplegar y encender
    myFoldable.unfold()
    myFoldable.switchOn()
    myFoldable.checkPhonScreenLight()

    // Plegar de nuevo
    myFoldable.fold()
    myFoldable.checkPhonScreenLight()
}