package rpg_combat

class AttackFactory {
    companion object {
        fun createAttack(type: AttackType, baseDamage: Int) : Attack = when (type) {
            AttackType.NORMAL -> Attack(baseDamage)
            AttackType.ADVANTAGE -> AdvantageAttack(baseDamage)
            AttackType.DISADVANTAGE -> DisadvantageAttack(baseDamage)
        }
    }
}