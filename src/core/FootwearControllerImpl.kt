package core

import data.Footwear
import ui.FootwearUi
import utils.*
import java.util.Locale

class FootwearControllerImpl(private val footwearUi: FootwearUi) : FootwearController(footwearUi) {

    init {
        super.controlMenu()
    }

    override fun add() {
        executeAction(
            action = Action.ADD,
        ) {
            footwears.add(createFootwear())
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
        executeAction(
            action = Action.UPDATE,
        ) {
            footwearUi.viewFootwear(footwears)
            val validRange = 1..footwears.size

            var position = 0
            do {
                footwearUi.showActionInput("update")?.let {
                    if (it.validateDataIndex(validRange)) {
                        position = it.toInt()
                    }
                }
            } while (position == 0)

            val index = position - 1
            footwears[index] = createFootwear(footwears[index])
        }
    }

    override fun delete() {
        executeAction(
            action = Action.DELETE
        ) {
            footwearUi.viewFootwear(footwears)
            val validRange = 1..footwears.size

            var position = 0
            do {
                footwearUi.showActionInput("delete")?.let {
                    if (it.validateDataIndex(validRange)) {
                        position = it.toInt()
                    }
                }
            } while (position == 0)

            val index = position - 1
            footwears.removeAt(index)
        }
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

    private fun createFootwear(footwear: Footwear? = null): Footwear {
        val name = getName()
        val price = getPrice()

        return if (footwear == null) {
            if (getType() == "Heels") {
                val height = getHeelsHeight()
                Footwear.Heels(
                    name = name,
                    price = price,
                    height = height
                )
            } else {
                val wheels = getTotalWheel()
                Footwear.RollerSkate(
                    name = name,
                    price = price,
                    totalWheel = wheels
                )
            }
        } else {
            when (footwear) {
                is Footwear.Heels -> {
                    val height = getHeelsHeight()
                    Footwear.Heels(
                        name = name,
                        price = price,
                        height = height
                    )
                }
                is Footwear.RollerSkate -> {
                    val wheels = getTotalWheel()
                    Footwear.RollerSkate(
                        name = name,
                        price = price,
                        totalWheel = wheels
                    )
                }
            }
        }
    }

}

enum class Action {
    ADD, VIEW, UPDATE, DELETE,
}