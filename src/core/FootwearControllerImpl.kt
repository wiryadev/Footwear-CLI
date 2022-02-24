package core

import data.Footwear
import ui.FootwearUi
import utils.*
import java.util.*

class FootwearControllerImpl(private val footwearUi: FootwearUi) : FootwearController(footwearUi) {

    init {
        super.controlMenu()
    }

    override fun add() {
        executeAction(
            action = Action.ADD,
        ) {
            var name = ""

            do {
                getNameInput()?.let {
                    if (it.validateName()) {
                        name = it
                    }
                }
            } while (name.isEmpty())

            var price = 0
            do {
                getPriceInput()?.let {
                    if (it.validatePrice()) {
                        price = it.toInt()
                    }
                }
            } while (price == 0)

            var type = ""
            do {
                getTypeInput()?.let {
                    if (it.validateType()) {
                        type = it
                    }
                }
            } while (type.isEmpty())

            when (type) {
                "Heels" -> {
                    var height = 0.0
                    do {
                        getHeightInput()?.let {
                            if (it.validateHeelsHeight()) {
                                height = it.toDouble()
                            }
                        }
                    } while (height == 0.0)

                    footwears.add(
                        Footwear.Heels(
                            name = name,
                            price = price,
                            height = height
                        )
                    )
                }
                "RollerSkate" -> {
                    var wheels = 0
                    do {
                        getWheelInput()?.let {
                            if (it.validateTotalWheel()) {
                                wheels = it.toInt()
                            }
                        }
                    } while (wheels == 0)

                    footwears.add(
                        Footwear.RollerSkate(
                            name = name,
                            price = price,
                            totalWheel = wheels
                        )
                    )
                }
            }
        }
    }

    override fun view() {
        executeAction(
            action = Action.VIEW,
        ) {
            footwearUi.viewFootwear(footwears)
        }
    }

    override fun update() {
    }

    override fun delete() {
    }

    private fun executeAction(action: Action, block: () -> Unit) {
        val actionName = action.toString().replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
        }

        when (action) {
            Action.ADD -> {
                block.invoke()
                footwearUi.showActionSuccessMessage(actionName)
            }
            else -> {
                if (footwears.isEmpty()) {
                    footwearUi.showNoActionMessage(actionName)
                } else {
                    block.invoke()
                    footwearUi.showActionSuccessMessage(actionName)
                }
            }
        }
    }

    private fun getNameInput() = footwearUi.input("name [3 - 15 characters]")
    private fun getPriceInput() = footwearUi.input("price [more than 10000]")
    private fun getTypeInput() = footwearUi.input("type [Heels / RollerSkate]")
    private fun getHeightInput() = footwearUi.input("height [1.0 - 9.0 inclusive]")
    private fun getWheelInput() = footwearUi.input("total wheel [2 - 4 inclusive]")
}

enum class Action {
    ADD, VIEW, UPDATE, DELETE,
}