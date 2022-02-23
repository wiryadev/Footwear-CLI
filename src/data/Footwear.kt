package data

sealed interface Footwear {
    var name: String
    var price: Int

    data class Heels(
        override var name: String,
        override var price: Int,
        var height: Double,
    ) : Footwear

    data class RollerSkate(
        override var name: String,
        override var price: Int,
        var totalWheel: Int,
    ) : Footwear

}