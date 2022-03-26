
/**
 * Program that implements classes for diferent kinds of dwellings.
 * Shows how to:
 * Create class hierarchy, variables and functions with inheritance,
 * abstract class, overriding, and private vs. public variables
 * */
import kotlin.math.PI
import kotlin.math.sqrt

fun main(){
    val squareCabin = SquareCabin(6, 50.0)

//    println("\nSquare Cabin\n===========")
//    println("Capacity: ${squareCabin.capacity}")
//    println("Material: ${squareCabin.buildingMaterial}")
//    println("Has room? ${squareCabin.hasRoom()}")

    with(squareCabin){
        println("\nSquare Cabin\n========")
        println("Cpacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    val roundHut = RoundHut(3, 10.0)
    with(roundHut){
        println("\nRound Hut\n============")
        println("Material: ${buildingMaterial}")
        println("Cpacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    val roundTower = RoundTower(4, 15.5)
    with(roundTower){
        println("\nRound Tower\n========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room: ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}


/**
 * Defines properties common to ass dwellings.
 * All dwellings have floorspace,
 * but its calculation is specific to the subclass.
 * Checking and getting a room are implemented her
 * beacuse they are the same for all Dwelling subclasses.
 *
 * @param residents Current number of residents
 * */
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    /**
     * Checks whether there is room for another resident.
     *
     * @return true if room available, false otherwise
     * */
    fun hasRoom(): Boolean{
        return residents < capacity
    }

    /**
     * Compares the capacity to the number of residents and
     * if capacity is larger than the number of residents,
     * add resident by increasing the number of residents.
     * Print the result
     * */
    fun getRoom(){
        if(capacity > residents){
            residents++
            println("You got a room")
        }else{
            println("Sorry, at capacity and no rooma left")
        }
    }
    /**
     * Calculates the floor area of the dwelling.
     * Implemented by subclasses where shape is determined.
     *
     * @return floor area
     * */
    abstract fun floorArea(): Double
}

/**
 * A square cabin dwelling
 *
 * @param residents Current number of residents
 * @param length Length
 * */
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents){
    override val buildingMaterial = "Wood"
    override val capacity = 6

    /**
     * Calculates floor area for a square dwelling
     *
     * @return floor area
     * */
    override fun floorArea(): Double {
        return length * length
    }
}

/**
 * Dwelling with circular floorspace
 *
 * @param residents Current number of residents
 * @param radius Radius
 * */
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    /**
     * Clculates the mac length for a square carpet
     * that fits the circular floor
     *
     * @return length of carpet
     * */
    fun calculateMaxCarpetSize(): Double{
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
 * Round tower with multiple stories
 *
 * @param residents Current number of residents
 * @param radius Radius
 * @param floors Number of stories
 * */
class RoundTower(residents: Int,
                 radius: Double,
                 val floors: Int = 2) : RoundHut(residents, radius){

    override val buildingMaterial = "Stone"
    //Capacity depends on the number of floors
    override val capacity = 4 * floors

    /**
     * Claculates the total floor area for a tower dwelling
     * with multiple stories
     *
     * @return floor area
     * */
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

/**
 * In this codelab you learned how to:
 *
 * *Create a class herarchy, that is a tree of classes where children inherit functionality
 * from parent classes. Properties and functions are inherited by subclasses
 *
 * *Create an abstract class where some functionality is left to be implemented
 * by its subclasses. An abstract class can therefore not be instantiated
 *
 * * Create subclasses of an abstract class
 *
 * *Use override keyword to override properties and functions in subclass
 *
 * *Use the super keyword to reference functions and properies in the parent class
 *
 * *Make a class open so that it can be subclassed
 * 
 * *Make a property private, so it can only be used inside the class
 *
 * *Use the with construct to make multiple calls on the same object instance
 *
 * *import functionality form the kotlin.math library
 *
 *
 * */
