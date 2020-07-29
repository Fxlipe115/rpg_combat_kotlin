package rpg_combat

open class Attack(baseDamage : Int) {
    open val damage = baseDamage

    companion object Factory{
        fun createAttack(type: AttackType, baseDamage: Int) : Attack = when (type) {
            AttackType.NORMAL -> Attack(baseDamage)
            AttackType.ADVANTAGE -> AdvantageAttack(baseDamage)
            AttackType.DISADVANTAGE -> DisadvantageAttack(baseDamage)
        }
    }
}

class AdvantageAttack(baseDamage : Int) : Attack(baseDamage) {
    override val damage: Int
        get() = (super.damage * 1.5).toInt()
}

class DisadvantageAttack(baseDamage : Int) : Attack(baseDamage) {
    override val damage: Int
        get() = (super.damage * 0.5).toInt()
}