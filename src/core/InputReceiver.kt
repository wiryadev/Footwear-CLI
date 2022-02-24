package core

interface InputReceiver {
    fun getName(): String
    fun getPrice(): Int
    fun getType(): String
    fun getHeelsHeight(): Double
    fun getTotalWheel(): Int
}