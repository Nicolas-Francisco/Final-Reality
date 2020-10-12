package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EngineerTest extends AbstractPlayerCharacterTest {

    @BeforeEach
    void setUp() {
        basicSetUp();
        testPlayers.add(new Engineer(ENGINEER_NAME, turns));
    }

    @Test
    void constructorTest() {
        checkConstruction(new Engineer(ENGINEER_NAME, turns),
                testPlayers.get(0),
                new Engineer("Tony", turns),
                new Knight("Solaire", turns));
    }

    @Test
    void equipWeaponTest() {
        Engineer engineer = new Engineer(ENGINEER_NAME, turns);
        assertNull(engineer.getEquippedWeapon());
        engineer.equip(testWeapon);
        assertEquals(testWeapon, engineer.getEquippedWeapon());
    }
}