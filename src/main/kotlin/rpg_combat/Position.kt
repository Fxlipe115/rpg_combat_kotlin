package rpg_combat.rpg_combat

import kotlin.math.sqrt
import kotlin.math.pow

class Position(var x : Double, var y : Double) {
    fun distanceTo(other: Position): Double {
        return sqrt((other.x - this.x).pow(2) + (other.y - this.y).pow(2))
    }
}
