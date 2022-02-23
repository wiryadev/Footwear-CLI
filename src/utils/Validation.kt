package utils

object Validation {

    fun validateName(nameInput: String?): Boolean {
        return validate(nameInput) { name ->
            name.length in 3..25
        }
    }

    fun validatePrice(priceInput: String?): Boolean {
        return validate(priceInput) { price ->
            price.toInt() > 10000
        }
    }

    fun validateHeelsHeight(heightInput: String?): Boolean {
        return validate(heightInput) { height ->
            height.toDouble() in 1.0..9.0
        }
    }

    fun validateTotalWheel(wheelInput: String?): Boolean {
        return validate(wheelInput) { wheel ->
            wheel.toInt() in 2..4
        }
    }

    private fun validate(input: String?, block: (String) -> Unit): Boolean {
        return input?.let { data ->
            if (data.isNotEmpty()) {
                validate(block, data)
            } else {
                false
            }
        } ?: false
    }

    private fun validate(block: (String) -> Unit, data: String): Boolean {
        return try {
            block.invoke(data)
            true
        } catch (e: Exception) {
            false
        }
    }

}