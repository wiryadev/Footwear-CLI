package ui

import data.Footwear

class FootwearUiImpl : FootwearUi {

    override fun showMenu(): String? {
        println("Just DU It !!")
        println("=============")
        println("1. Add Footwear")
        println("2. View Footwear")
        println("3. Update Footwear")
        println("4. Delete Footwear")
        println("5. Exit")
        print(">> ")
        return readlnOrNull()
    }

    override fun input(data: String): String? {
        print("Footwear $data: ")
        return readlnOrNull()
    }

    override fun viewFootwear(footwears: List<Footwear>) {
        println("=========================================================================")
        println("| No\t| Name\t\t\t\t\t| Price\t\t| Height\t| Total Wheel\t|")
        println("=========================================================================")

        for ((index, footwear) in footwears.withIndex()) {
            val height = if (footwear is Footwear.Heels) "${footwear.height} cm" else " -\t"
            val wheels = if (footwear is Footwear.RollerSkate) "${footwear.totalWheel} Wheels" else " -\t"
            println("| ${index + 1}\t\t| ${footwear.name}\t| ${footwear.price}\t| $height\t| $wheels\t|")
        }

        println("=========================================================================")
    }

    override fun showActionInput(action: String): String? {
        print("Input footwear index to $action: ")
        return readlnOrNull()
    }

    override fun showActionSuccessMessage(action: String) {
        println("Footwear $action successfully !!")
    }

    override fun showNoActionMessage(action: String) {
        println("There are no footwear to $action !")
    }
}