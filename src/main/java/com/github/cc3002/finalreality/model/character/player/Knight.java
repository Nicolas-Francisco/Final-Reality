package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a knight class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */

public class Knight extends AbstractPlayerCharacter {

    /**
     * Creates a new player.
     *
     * @param name
     *     the player's name
     * @param turnsQueue
     *     the queue with the player waiting for their turn
     * @param hp
     *     the player's health points
     * @param defense
     *     the character's defense
     */
    public Knight(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                  @NotNull int hp,
                  @NotNull int defense) {
        super(name, turnsQueue, hp, defense);
    }

    /**
     * equips a sword to the knight.
     * A knight class can only equip a sword, an axe or a knife. Hence, we create equipSword,
     * equipAxe and equipKnife to make sure the knight can only equip this types of weapons.
     */
    public void equip(Sword sword){
        if (this.IsAlive()){
            this.setEquippedWeapon(sword);
        }
    }

    /**
     * equips an axe to the knight.
     * A knight class can only equip a sword, an axe or a knife. Hence, we create equipSword,
     * equipAxe and equipKnife to make sure the knight can only equip this types of weapons.
     */
    public void equip(Axe axe){
        if (this.IsAlive()){
            this.setEquippedWeapon(axe);
        }
    }

    /**
     * equips a knife to the knight.
     * A knight class can only equip a sword, an axe or a knife. Hence, we create equipSword,
     * equipAxe and equipKnife to make sure the knight can only equip this types of weapons.
     */
    public void equipKnife(Knife knife){
        if (this.IsAlive()){
            this.setEquippedWeapon(knife);
        }
    }


    /**
     * both methods equals() and hashcode() are different depending of the type of character and
     * the type of Character, hence this methods cannot be used with inheritance
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHP(), getDefense());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Knight)) {
            return false;
        }
        final Knight that = (Knight) o;
        return getName() == that.getName() &&
                getHP() == that.getHP() &&
                getDefense() == that.getDefense();
    }
}
