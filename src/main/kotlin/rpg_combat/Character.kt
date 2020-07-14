package rpg_combat

class Character {
    var health: Int = 1000
        private set(value) {
            field = if (value < 0) 0 else if (value > 1000) 1000 else value
        }

    var level: Int = 1

    val alive: Boolean
        get() = this.health > 0

    fun attack(enemy: Character, damage: Int) {
        if (this !== enemy) {
            enemy.health -= damage
        }
    }

    fun heal(lifePoints: Int) {
        if (this.alive) {
            this.health += lifePoints
        }
    }
}