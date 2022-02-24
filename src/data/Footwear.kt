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

/**
 * Dummy Data
 *
 * Prada Platform Pump      1000000     7.00 cm     -
 * Mlyzhe Deformation       2000000     -           2 Wheels
 * CK Peep-Toe Platform     3000000     4.00 cm     -
 * Beppi Roller Sneakers    4000000     -           3 Wheels
 */