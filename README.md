# Лабораторная работа 9-10 Продвинутое ООП на Kotlin

### Описание
Лаба посвящена изучению продвинутых концепций ооп в Kotlin

### Структура проекта
Проект содержит примеры реализации продвинутых механизмов ООП, а также пояснение к ключевым
концепциям.

## Как запустить проект
1. Клонируйте репозиторий: ```bash
git clone <URL_репозитория>
``` 2. Откройте проект в IntelliJ IDEA. 3. Запустите любой пример через контекстное меню или напрямую из `main`. ## Автор
   Селиванов Павел Алексеевич, Беляев Владимир Александрович
## Лицензия
Проект создан в учебных целях


# Galaxy Outpost Manager

Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программирования и архитектурные приёмы языка.

## Sealed-классы

Sealed-классы используются для представления ограниченного набора состояний или результатов, которые известны на этапе компиляции.

Они позволяют:

- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию `when` без `else`;
- удобно описывать состояния, события и результаты действий.

### Пример: результат работы модуля

```kotlin
sealed class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ) : ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}
```
## Object в Kotlin
object — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton).
### Особенности:
   - создаётся при первом обращении;
   - существует в одном экземпляре;
   - не имеет конструктора.

### Пример: глобальный логгер
object Logger {
private var counter = 0
```
    fun log(message: String) {
        counter++
        println("[$counter] $message")
    }
}
```
### Использование: 
```
Logger.log("Инициализация системы")
Logger.log("Модуль запущен")
```
object удобно использовать для:
   - логгеров
   - конфигураций
   - состояний без данных в sealed-классах
   - утилитарных классов
### Пример object в sealed-классе:

```
sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()  // ← object вместо data class
}
```

# Делегирование свойств
Делегирование свойств позволяет передать логику хранения и обработки значения другому объекту.
В Kotlin это реализуется с помощью ключевого слова by.

Преимущества:

   - уменьшение дублирования кода;

   - централизованная логика проверки и обработки данных;

   - более чистый и читаемый код.

### Пример: отслеживание изменений энергии

```
import kotlin.properties.Delegates

var energy: Int by Delegates.observable(100) { _, old, new ->
    println("Энергия изменилась: $old -> $new")
}
```
# Lazy (ленивая инициализация)

lazy позволяет инициализировать объект только при первом обращении к нему.

### Это полезно, если:

   - объект создаётся не всегда;

   - его создание ресурсоёмкое;

   - нужно отложить инициализацию.

### Пример:
```
val resourceManager by lazy {
    ResourceManager()
}
```
Объект ResourceManager будет создан только при первом использовании.

# Observer-паттерн (наблюдатель)

Observer-паттерн позволяет объектам реагировать на изменения состояния другого объекта.
### В проекте Galaxy Outpost Manager наблюдатели могут:
   - реагировать на изменение ресурсов;
   - логировать события;
   - уведомлять пользователя.
### Пример идеи:
```
// ResourceManager изменяет ресурсы
class ResourceManager {
    var minerals: Int by Delegates.observable(0) { _, old, new ->
        println("Ресурс Minerals изменён: $old → $new")
    }
}
```
Наблюдатель выводит сообщение в консоль при изменении ресурса.

# Сохранение состояния
Для сохранения состояния проекта используется сериализация в файл.

### Это позволяет:
   - сохранять данные между запусками программы;
   - хранить состояние в человекочитаемом формате;
   - легко перенести логику в Android-приложение.
### Пример:
```
object FileStorage {
    private const val FILE_NAME = "outpost_state.txt"
    
    fun save(resources: List<OutpostResource>) {
        // Сохранение в файл
    }
    
    fun load(): List<OutpostResource> {
        // Загрузка из файла
    }
}
```

