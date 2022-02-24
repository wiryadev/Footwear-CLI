package core

import data.Footwear
import ui.FootwearUi
import utils.*
import kotlin.system.exitProcess

abstract class FootwearController(private val footwearUi: FootwearUi) : InputReceiver {

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

    override fun getName(): String {
        var name = ""
        do {
            inputName()?.let {
                if (it.validateName()) {
                    name = it
                }
            }
        } while (name.isEmpty())
        return name
    }

    override fun getPrice(): Int {
        var price = 0
        do {
            inputPrice()?.let {
                if (it.validatePrice()) {
                    price = it.toInt()
                }
            }
        } while (price == 0)
        return price
    }

    override fun getType(): String {
        var type = ""
        do {
            inputType()?.let {
                if (it.validateType()) {
                    type = it
                }
            }
        } while (type.isEmpty())
        return type
    }

    override fun getHeelsHeight(): Double {
        var height = 0.0
        do {
            inputHeight()?.let {
                if (it.validateHeelsHeight()) {
                    height = it.toDouble()
                }
            }
        } while (height == 0.0)
        return height
    }

    override fun getTotalWheel(): Int {
        var wheels = 0
        do {
            inputWheel()?.let {
                if (it.validateTotalWheel()) {
                    wheels = it.toInt()
                }
            }
        } while (wheels == 0)
        return wheels
    }

    private fun inputName() = footwearUi.input("name [3 - 15 characters]")
    private fun inputPrice() = footwearUi.input("price [more than 10000]")
    private fun inputType() = footwearUi.input("type [Heels / RollerSkate]")
    private fun inputHeight() = footwearUi.input("height [1.0 - 9.0 inclusive]")
    private fun inputWheel() = footwearUi.input("total wheel [2 - 4 inclusive]")

}