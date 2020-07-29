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
            throw Exception("Can't attack yourself")
        }
        val attackType = actualDamage(enemy)
        val attack = AttackFactory.createAttack(attackType, baseDamage)
        enemy.health -= attack.damage
    }

    private fun actualDamage(enemy: Character): AttackType {
        val levelDifference = this.level - enemy.level
        return if (levelDifference >= 5) {
            AttackType.ADVANTAGE
        } else if (levelDifference <= -5) {
            AttackType.DISADVANTAGE
        } else {
            AttackType.NORMAL
        }
    }

    fun heal(lifePoints: Int) {
        if (!this.alive) {
            throw Exception("Character is dead")
        }
        this.health += lifePoints
    }
}