
fun main(){
    val squareCabin = SquareCabin(5)

//    println("\nSquare Cabin\n===========")
//    println("Capacity: ${squareCabin.capacity}")
//    println("Material: ${squareCabin.buildingMaterial}")
//    println("Has room? ${squareCabin.hasRoom()}")

    with(squareCabin){
        println("\nSquare Cabin\n========")
        println("Cpacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }

    val roundHut = RoundHut(3)
    with(roundHut){
        println("\nRound Hut\n============")
        println("Material: ${buildingMaterial}")
        println("Cpacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }

    val roundTower = RoundTower(4)
    with(roundTower){
        println("\nRound Tower\n========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room: ${hasRoom()}")
    }
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean{
        return residents < capacity
    }
}

class SquareCabin(residents: Int) : Dwelling(residents){
    override val buildingMaterial = "Wood"
    override val capacity = 6
}

open class RoundHut(residents: Int) : Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
}

class RoundTower(residents: Int) : RoundHut(residents){
    override val buildingMaterial = "Stone"
    override val capacity = 4
}


