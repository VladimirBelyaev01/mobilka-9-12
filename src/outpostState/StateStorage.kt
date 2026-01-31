package outpostState

import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpost_state_save.txt"

    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        val text = resources.joinToString("\n") { resource ->
            "${resource.name};${resource.amount}"
        }
        file.writeText(text)
        println("Состояние сохранено в файл: $FILE_NAME")
    }

    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) {
            println("Файл сохранения не найден. Начинаем с чистого листа.")
            return emptyList()
        }

        return file.readLines().mapNotNull { line ->
            val parts = line.split(";")
            if (parts.size == 2) {
                ObservableResource(parts[0], parts[1].toInt())
            } else {
                null
            }
        }.also {
            println("Загружено ${it.size} ресурсов из файла.")
        }
    }
}