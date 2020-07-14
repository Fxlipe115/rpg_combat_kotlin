package rpg_combat

import org.junit.Before
import kotlin.test.assertEquals
import org.junit.Test
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

    @Test fun `heal should increase ally's health`() {
        val ally = Character()
        this.character.attack(ally, 500)
        this.character.heal(ally, 100)
        assertEquals(600, ally.health)
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
        character.attack(character, 100)
        assertEquals(1000, character.health)
    }

    @Test fun `ally's health shouldn't exceed 1000`() {
        val ally = Character()
        this.character.attack(ally, 500)
        this.character.heal(ally, 600)
        assertEquals(1000, ally.health)
    }

    @Test fun `dead allies cannot be healed`() {
        val ally = Character()
        this.character.attack(ally, 8001)
        this.character.heal(ally, 600)
        assertEquals(0, ally.health)
    }
}