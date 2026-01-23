import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

/*fun characters.characters.resources.main(){
    val manager = resources.ResourceManager()
    val minerals = resources.OutpostResource(1,"Minerals", 300)
    val gas = resources.OutpostResource(2,"Gas",100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()

    val bonus = minerals.copy(amount = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")
}*/

/*
fun characters.characters.resources.main() {

    val car = examle.Car(model = "LADA", number = "134LAD")
    val aircraft = examle.Aircraft(model = "Boeing", number = "737")


    car.move()
    car.stop()
    aircraft.move()
    aircraft.stop()

    println()

    examle.travel(car)
    examle.travel(aircraft)

    println()


    val movableCar: examle.Movable = examle.Car(model = "Toyota", number = "123ABC")
    val movableAircraft: examle.Movable = examle.Aircraft(model = "Airbus", number = "A320")

    movableCar.move()
    movableAircraft.move()

    println()


    val pavel = examle.WorkingStudent(name = "Pavel")
    pavel.work()
    pavel.study()

    println()

    val player = examle.MediaPlayer()
    player.play()
}*/


fun main() {
    val manager = ResourceManager()

    manager.add(OutpostResource(id = 1, name = "Minerals", amount = 120))
    manager.add(OutpostResource(id = 2, name = "Gas", amount = 40))

    val generator = EnergyGenerator()
    val lab = ResearchLab()

    generator.performAction(manager)
    lab.performAction(manager)

    println()
    manager.printAll()


    fun handleModuleResult() {

        println("\n Запуск модулей ")

        val generatorResult = generator.performAction(manager)
        val labResult = lab.performAction(manager)


        handleModuleResult(generatorResult)
        handleModuleResult(labResult)


        println("\nРесурсы базы:")
        manager.printAll()
    }
}

