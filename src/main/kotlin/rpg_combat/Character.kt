package rpg_combat

class Character {
    var health: Int = 1000
        private set(value) {
            field = if (value < 0) 0 else if (value > 1000) 1000 else value
        }

    var level: Int = 1

    val alive: Boolean
        get() = this.health > 0

    fun attack(enemy: Character, baseDamage: Int) {
        if (this === enemy) {
            return
        }
        enemy.health -= actualDamage(enemy, baseDamage)
    }

    private fun actualDamage(enemy: Character, baseDamage: Int): Int {
        val levelDifference = this.level - enemy.level
        return when {
            levelDifference >= 5 -> (baseDamage * 1.5).toInt()
            levelDifference <= -5 -> (baseDamage * 0.5).toInt()
            else -> baseDamage
        }
    }

    fun heal(lifePoints: Int) {
        if (this.alive) {
            this.health += lifePoints
        }
    }
}