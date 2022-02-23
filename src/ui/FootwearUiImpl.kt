package ui

import data.Footwear

class FootwearUiImpl: FootwearUi {

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

    override fun viewFootwear(list: List<Footwear>) {
        println("")
    }

    override fun showActionSuccessMessage(action: String) {
        println("Footwear $action successfully !!")
    }

    override fun showNoActionMessage(action: String) {
        println("There are no footwear to $action !")
    }
}