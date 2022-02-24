package utils

fun String?.validateName(nameInput: String?): Boolean {
    return Validation.validate(nameInput) { name ->
        name.length in 3..25
    }
}

fun String?.validatePrice(priceInput: String?): Boolean {
    return Validation.validate(priceInput) { price ->
        price.toInt() > 10000
    }
}

fun String?.validateHeelsHeight(heightInput: String?): Boolean {
    return Validation.validate(heightInput) { height ->
        height.toDouble() in 1.0..9.0
    }
}

fun String?.validateTotalWheel(wheelInput: String?): Boolean {
    return Validation.validate(wheelInput) { wheel ->
        wheel.toInt() in 2..4
    }
}