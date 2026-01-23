package gameCharacter

class GameCharacter(val name: String) {

    var state: CharacterState = CharacterState.Idle

    fun changeState(newState: CharacterState) {
        state = newState
        println("Персонаж $name сменил состояние на: $state")
    }

    fun showInfo() {
        println("Информация о персонаже")
        println("Имя: $name")
        println("Текущее состояние: $state")
    }
}