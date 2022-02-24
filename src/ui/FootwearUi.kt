package ui

import data.Footwear

interface FootwearUi {
    fun showMenu(): String?
    fun input(data: String): String?
    fun viewFootwear(footwears: List<Footwear>)
    fun showActionInput(action: String): String?
    fun showActionSuccessMessage(action: String)
    fun showNoActionMessage(action: String)
}