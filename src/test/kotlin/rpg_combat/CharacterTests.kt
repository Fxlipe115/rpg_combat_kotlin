package rpg_combat

import org.junit.Before
import kotlin.test.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CharacterTests {
    var character: Character = Character()

    @Before fun initialize() {

    }

    @Test fun `has 1000 health`() {
        val health: Int = this.character.health
        assertEquals(1000, health)
    }

    @Test fun `has level 1`() {
        val level: Int = this.character.level
        assertEquals(1, level)
    }

    @Test fun `is alive`() {
        val alive: Boolean = this.character.alive
        assertTrue(alive)
    }

    @Test fun `damage should reduce an enemy's health`() {
        val enemy = Character()
        this.character.attack(enemy, 100)
        assertEquals(900, enemy.health)
    }

    @Test fun `heal should increase own health`() {
        val enemy = Character()
        enemy.attack(character, 500)
        this.character.heal(100)
        assertEquals(600, character.health)
    }

    @Test fun `enemy should die when health reaches 0`() {
        val enemy = Character()
        character.attack(enemy,1000)
        assertFalse(enemy.alive)
    }

    @Test fun `enemy's health can't be less than 0`() {
        val enemy = Character()
        character.attack(enemy,1100)
        assertEquals(0, enemy.health)
    }

    @Test fun `character can't damage itself`() {
        assertFailsWith(Exception::class) {
            character.attack(character, 100)
        }
    }

    @Test fun `character health cannot exceed 1000 after healing`() {
        val enemy = Character()
        enemy.attack(character, 500)
        this.character.heal(600)
        assertEquals(1000, character.health)
    }

    @Test fun `dead character cannot be healed`() {
        val enemy = Character()
        enemy.attack(character, 8001)
        assertFailsWith(Exception::class) {
            this.character.heal(600)
        }
    }

    @Test fun `half damage if enemy is 5 or more levels above character`() {
        val enemy = Character().apply {
            level = 6
        }
        character.attack(enemy, 200)
        assertEquals(900, enemy.health)
    }

    @Test fun `150% damage if enemy is 5 or more levels below character`() {
        val enemy = Character()
        character.level = 6
        character.attack(enemy, 200)
        assertEquals(700, enemy.health)
    }

    @Test fun `Melee fighters have an attack range of 2 meters`() {
        character = MeleeFighter()
        assertEquals(2, character.maxAttackRange)
    }

    @Test fun `Ranged fighters have an attack range of 20 meters`() {
        character = RangedFighter()
        assertEquals(20, character.maxAttackRange)
    }
}