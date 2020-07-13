package rpg_combat

import kotlin.math.max

class Character {
    var health: Int = 1000
    var level: Int = 1
    var alive: Boolean = true

    fun attack(enemy: Character, damage: Int) {
        enemy.health -= damage
        if (enemy.health <= 0) {
            enemy.health = 0
            enemy.alive = false
        }
    }

    fun heal(ally: Character, lifePoints: Int) {
        if (!ally.alive) {
            return
        }
        ally.health += lifePoints
        if (ally.health > 1000) {
            ally.health = 1000
        }
    }
}