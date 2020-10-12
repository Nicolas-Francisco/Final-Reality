package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KnightTest extends AbstractPlayerCharacterTest {

    @BeforeEach
    void setUp() {
        basicSetUp();
        testPlayers.add(new Knight(KNIGHT_NAME, turns));
    }

    @Test
    void constructorTest() {
        checkConstruction(new Knight(KNIGHT_NAME, turns),
                testPlayers.get(0),
                new Knight("Solaire", turns),
                new Thief("Lautrec", turns));
    }

    @Test
    void equipWeaponTest() {
        Knight knight = new Knight(KNIGHT_NAME, turns);
        assertNull(knight.getEquippedWeapon());
        knight.equip(testWeapon);
        assertEquals(testWeapon, knight.getEquippedWeapon());
    }
}