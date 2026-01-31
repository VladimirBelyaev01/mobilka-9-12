package outpostState

class ResourceObserver {
    fun onResourceChanged(resourceName: String, oldValue: Int, newValue: Int) {
        println("[НАБЛЮДАТЕЛЬ] Ресурс '$resourceName' изменился: $oldValue → $newValue")
    }
}