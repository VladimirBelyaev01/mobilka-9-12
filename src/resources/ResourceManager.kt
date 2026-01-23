package resources

/*
class ResourceManager {
    private val resources = mutableListOf<resources.OutpostResource>()

    fun add(resource: resources.OutpostResource){
        resources.add(resource)
        println("Добавлен ресурс: ${resource.name}")
    }
    fun get(name: String): resources.OutpostResource?{
        return resources.find { it.name == name }
    }
    fun printAll(){
        println("Ресурсы базы")
        resources.forEach { println("${it.name}: ${it.amount}") }
    }
}*/
class ResourceManager {
    private val resources = mutableListOf<OutpostResource>()

    fun add(resource: OutpostResource) {
        resources.add(resource)
    }

    fun get(name: String): OutpostResource? {
        return resources.find { it.name == name }
    }

    fun printAll() {
        println("Все ресурсы:")
        resources.forEach { println("- ${it.name}: ${it.amount}") }
    }
}