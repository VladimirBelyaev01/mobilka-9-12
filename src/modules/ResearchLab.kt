/*
package modules

import resources.ResourceManager

class ResearchLab : OutpostModule(
    name = "Исследовательская лаборатория"
) {
    fun performAction(manager: ResourceManager) {
        val minerals = manager.get("Minerals")

        if (minerals == null || minerals.amount < 30) {
            println("Недостаточно минералов для исследования")
            return
        }

        minerals.amount -= 30
        println("Лаборатория проводит исследование (минералы -30)")
    }
}*/
package modules

import resources.ResourceManager

class ResearchLab : OutpostModule(name = "Исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager): ModuleResult {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30) {
            return ModuleResult.NotEnoughResources(
                resourceName = "Minerals",
                required = 30,
                available = minerals?.amount ?: 0
            )
        }
        minerals.amount -= 30
        return ModuleResult.Success(message = "Исследование завершено")
    }
}
