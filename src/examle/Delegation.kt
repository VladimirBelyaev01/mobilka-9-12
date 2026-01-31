package example

import kotlin.properties.Delegates

interface Base {
    fun someFun()
}

class BaseImpl() : Base {
    override fun someFun() {}
}

class Derived(someBase: Base) : Base by someBase

interface Messenger {
    fun send(message: String)
}

class InstantMessenger(val programName: String) : Messenger {
    override fun send(message: String) {
        println("Message '$message' has been sent")
    }
}

class SmartPhone1(val name: String, m: Messenger): Messenger by m

interface PhotoDevice {
    fun takePhoto()
}
class PhotoCamera: PhotoDevice {
    override fun takePhoto() = println("Take a photo")
}

class SmartPhone2(val name: String, m: Messenger, p: PhotoDevice) :
    Messenger by m, PhotoDevice by p

interface MessengerAdvanced {
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessengerAdvanced(val programName: String) : MessengerAdvanced {
    override fun sendTextMessage() = println("Send text message")
    override fun sendVideoMessage() = println("Send video message")
}

class SmartPhone3(
    val name: String,
    m: MessengerAdvanced
): MessengerAdvanced by m {
    override fun sendTextMessage() = println("Send sms")
}

var counter: Int by Delegates.observable(initialValue = 0) { _, old, new ->
    println("Счётчик изменился: $old -> $new")
}
class User {
    var name: String by Delegates.observable(initialValue = "<no name>") { _, old, new ->
        println("Имя изменено: '$old' -> '$new'")
    }
}

fun main() {
    val max = InstantMessenger(programName = "MAX")
    val phone1 = SmartPhone1(name = "YotaPhone", m = max)
    phone1.send("Hello Kotlin")
    phone1.send("Learn delegation")

    val camera = PhotoCamera()
    val phone2 = SmartPhone2(name = "YotaPhone", m = max, p = camera)
    phone2.send("Hello Kotlin")
    phone2.takePhoto()

    val maxAdv = InstantMessengerAdvanced(programName = "MAX")
    val phone3 = SmartPhone3(name = "YotaPhone", m = maxAdv)
    phone3.sendTextMessage()
    phone3.sendVideoMessage()

    counter = 1
    counter = 5
}