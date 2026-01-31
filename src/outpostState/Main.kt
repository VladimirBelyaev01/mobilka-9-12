package outpostState

fun main() {
    println("1. Проверяем ленивую инициализацию:")
    println("Сейчас менеджер ещё не создан...")
    println("Обращаемся к менеджеру:")
    manager
    println("Обращаемся снова (ничего не выводится):")
    manager

    println("2. Создаём ресурсы:")
    val wood = ObservableResource("Дерево", 50)
    val stone = ObservableResource("Камень", 30)

    println("3. Добавляем ресурсы в менеджер:")
    manager.addResource(wood)
    manager.addResource(stone)
    println("Ресурсы добавлены!")

    println("4. Меняем количество ресурсов:")
    println("Добавляем 20 дерева:")
    wood.amount = 70

    println("Добавляем 15 камня:")
    stone.amount = 45

    println("5. Сохраняем в файл:")
    StateStorage.save(manager.getAllResources())

    println("6. Загружаем из файла:")
    val loaded = StateStorage.load()
    println("Загружено ресурсов: ${loaded.size}")
}