package outpostState

class OutpostManager {
    private val resources = mutableListOf<ObservableResource>()

    fun addResource(resource: ObservableResource) {
        resources.add(resource)
    }

    fun getAllResources(): List<ObservableResource> = resources.toList()

    fun getResource(name: String): ObservableResource? {
        return resources.find { it.name == name }
    }
}

val manager by lazy {
    println("Менеджер аванпоста создан")
    OutpostManager()
}