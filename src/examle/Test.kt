package examle/*
import kotlin.io.path.fileVisitor

abstract class Human(val name: String){

    abstract var age: Int

    abstract fun hello()

    */
/*fun hello(){
        println("My name is $name")
    }*//*

}

class Person(name: String, override var age: Int): Human(name) {

    override fun hello(){println("My name is $name")}
}

data class Item(
    val id: Int,
    val name: String,
    val quantity: Int
){
    override fun toString(): String {
        return "Id предмета: $id\nName: $name\nKol-vo: $quantity\n"
    }
}

abstract class Figure{
    abstract fun perimeter(): Float
    abstract fun area(): Float
}

class Rectangle(val width: Float, val height: Float) : Figure() {
    override fun perimeter(): Float {
        return 2 * (width + height)
    }
    override fun area(): Float {
        return width * height
    }
}

*/
/*var age: Int = 18
    set(value){
        if((value > 0) and (value < 110))
            field = value
    }*//*


fun characters.characters.resources.main() {
    */
/*println(age)
    age = 45
    println(age)
    age = -345
    println(age)*//*


    val sword = Item(1,"Sword",1)
    val betterSword = sword.copy(quantity = 2)
    println(sword.toString())
    println(betterSword.toString())

    val(id, name, quantity) = betterSword
    println("$id, $name, $quantity")

    val denis: Person = Person("Denis")
    val pavel: Human = Person("Pavel")
    denis.hello()
    pavel.hello()
}*/
