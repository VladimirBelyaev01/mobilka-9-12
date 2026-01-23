package gameCharacter

fun main() {
    val hero = GameCharacter("Vova")
    hero.showInfo()
    println("Меняем состояния")
    hero.changeState(CharacterState.Running)
    hero.changeState(CharacterState.Attacking(50))
    hero.changeState(CharacterState.Dead("упал с горы"))
    println("Финальное состояние")
    hero.showInfo()
}