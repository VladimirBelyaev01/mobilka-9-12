import modules.EnergyGenerator
import modules.ResearchLab
import modules.ModuleResult
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


fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced -> println("Ресурс произведён: ${result.resourceName} (+${result.amount})")
        is ModuleResult.NotEnoughResources -> println("Недостаточно ресурсов: ${result.resourceName}")
        is ModuleResult.Error -> println("ОШИБКА: ${result.reason}")
    }
}

fun main() {
    val manager = ResourceManager()

    manager.add(OutpostResource(id = 1, name = "Minerals", amount = 300))
    manager.add(OutpostResource(id = 2, name = "Gas", amount = 100))

    val generator = EnergyGenerator()
    val lab = ResearchLab()

    println("Запуск модулей:")
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)

    handleModuleResult(generatorResult)
    handleModuleResult(labResult)

    println("Ресурсы базы:")
    manager.printAll()
}

