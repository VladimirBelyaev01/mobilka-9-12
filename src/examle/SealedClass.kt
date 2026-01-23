package examle
sealed class NetworkResult{
    data class Success(val data: String): NetworkResult()
    data class Error(val message: String, val code: Int): NetworkResult()
    object Loading: NetworkResult()
}
fun handleResult(result: NetworkResult){
    when(result){
        is NetworkResult.Success -> {
            println("Успех: ${result.data}")
        }
        is NetworkResult.Error -> {
            println("Ошибка ${result.code}: ${result.message}")
        }
        NetworkResult.Loading -> {
            println("Загрузка...")
        }
    }
}
sealed class OrderStatus{
    object Created : OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}
fun handleOrder(status: OrderStatus){
    when (status) {
        OrderStatus.Created -> println("Заказ создан")
        OrderStatus.Paid -> println("Заказ оплачен")
        OrderStatus.Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled -> println("Отменен: ${status.reason}")
    }
}
fun main(){
    val success = NetworkResult.Success("Данные получены")
    val error = NetworkResult.Error("Сервер не отвечает", code=500)
    val loading = NetworkResult.Loading
    handleResult(success)
    handleResult(error)
    handleResult(loading)
    handleOrder(OrderStatus.Created)
    handleOrder(OrderStatus.Paid)
    handleOrder(OrderStatus.Shipped)
    handleOrder(OrderStatus.Cancelled("Нет товара на складе"))
}


