package ui

import data.Footwear

interface FootwearUi {
    fun showMenu(): String?
    fun input(data: String): String?
    fun viewFootwear(list: List<Footwear>)
    fun showActionSuccessMessage(action: String)
    fun showNoActionMessage(action: String)
}