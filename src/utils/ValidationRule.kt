package utils

fun String?.validateMenu(): Boolean {
    return Validation.validate(this) { option ->
        option.toInt() in 1..5
    }
}

fun String?.validateName(): Boolean {
    return Validation.validate(this) { name ->
        name.length in 3..25
    }
}

fun String?.validatePrice(): Boolean {
    return Validation.validate(this) { price ->
        price.toInt() > 10000
    }
}

fun String?.validateType(): Boolean {
    return Validation.validate(this) { name ->
        name == "Heels" || name == "RollerSkate"
    }
}

fun String?.validateHeelsHeight(): Boolean {
    return Validation.validate(this) { height ->
        height.toDouble() in 1.0..9.0
    }
}

fun String?.validateTotalWheel(): Boolean {
    return Validation.validate(this) { wheel ->
        wheel.toInt() in 2..4
    }
}