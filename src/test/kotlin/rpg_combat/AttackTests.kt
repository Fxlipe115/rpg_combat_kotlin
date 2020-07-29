package rpg_combat

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AttackTests {
    @Test
    fun `Factory can create normal attack`(){
        val attack = Attack.Factory.createAttack(AttackType.NORMAL, 100)
        assertTrue(attack is Attack)
    }

    @Test
    fun `Factory can create attack with advantage`(){
        val attack = Attack.Factory.createAttack(AttackType.ADVANTAGE, 100)
        assertTrue(attack is AdvantageAttack)
    }

    @Test
    fun `Factory can create attack with disadvantage`(){
        val attack = Attack.Factory.createAttack(AttackType.DISADVANTAGE, 100)
        assertTrue(attack is DisadvantageAttack)
    }

    @Test
    fun `Normal attack has damage equals to base damage`(){
        val attack = Attack.Factory.createAttack(AttackType.NORMAL, 100)
        assertEquals(100, attack.damage)
    }

    @Test
    fun `Advantage attack multiplies base damage by 1,5`(){
        val attack = Attack.Factory.createAttack(AttackType.ADVANTAGE, 100)
        assertEquals(150, attack.damage)
    }

    @Test
    fun `Advantage attack multiplies base damage by 0,5`(){
        val attack = Attack.Factory.createAttack(AttackType.DISADVANTAGE, 100)
        assertEquals(50, attack.damage)
    }
}