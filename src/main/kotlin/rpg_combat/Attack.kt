package rpg_combat

open class Attack(baseDamage : Int) {
    open val damage = baseDamage
}

class AdvantageAttack(baseDamage : Int) : Attack(baseDamage) {
    override val damage: Int
        get() = (super.damage * 1.5).toInt()
}

class DisadvantageAttack(baseDamage : Int) : Attack(baseDamage) {
    override val damage: Int
        get() = (super.damage * 0.5).toInt()
}