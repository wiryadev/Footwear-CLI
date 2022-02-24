package core

import data.Footwear
import ui.FootwearUi
import utils.validateMenu
import kotlin.system.exitProcess

abstract class FootwearController(private val footwearUi: FootwearUi) {

    internal val footwears = mutableListOf<Footwear>()

    fun controlMenu() {
        val option = footwearUi.showMenu()?.let {
            if (it.validateMenu()) it.toInt() else 0
        } ?: 0

        when (option) {
            1 -> {
                add()
                controlMenu()
            }
            2 -> {
                view()
                controlMenu()
            }
            3 -> {
                update()
                controlMenu()
            }
            4 -> {
                delete()
                controlMenu()
            }
            5 -> exitProcess(0)
            else -> controlMenu()
        }
    }

    abstract fun add()
    abstract fun view()
    abstract fun update()
    abstract fun delete()

}