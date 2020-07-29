package rpg_combat

import rpg_combat.rpg_combat.Position

open class Character {
    var health: Int = 1000
        private set(value) {
            field = if (value < 0) 0 else if (value > 1000) 1000 else value
        }

    var level: Int = 1

    val alive: Boolean
        get() = this.health > 0

    open val maxAttackRange = 2

    var position = Position(0.0, 0.0)

    fun attack(enemy: Character, baseDamage: Int) {
        if (attackingSelf(enemy)) {
            throw Exception("Can't attack yourself")
        }
        if (!isInRange(enemy)) {
            throw Exception("Enemy is too far")
        }
        val attackType = attackType(enemy)
        val attack = Attack.Factory.createAttack(attackType, baseDamage)
        enemy.health -= attack.damage
    }

    private fun attackingSelf(enemy: Character) = this === enemy

    private fun attackType(enemy: Character): AttackType {
        val levelDifference = this.level - enemy.level
        return if (levelDifference >= 5) {
            AttackType.ADVANTAGE
        } else if (levelDifference <= -5) {
            AttackType.DISADVANTAGE
        } else {
            AttackType.NORMAL
        }
    }

    private fun isInRange(enemy: Character): Boolean {
        return this.position.distanceTo(enemy.position) < this.maxAttackRange
    }

    fun heal(lifePoints: Int) {
        if (!this.alive) {
            throw Exception("Character is dead")
        }
        this.health += lifePoints
    }
}

class MeleeFighter : Character() {
    override val maxAttackRange: Int
        get() = 2
}

class RangedFighter : Character() {
    override val maxAttackRange: Int
        get() = 20
}