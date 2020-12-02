package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import java.util.Objects;

/**
 * A class that holds all the information of a sword.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class Sword extends AbstractWeapon{

    /**
     * Creates a new Sword of the game.
     *
     * @param name
     *     the Sword's name
     * @param damage
     *     the Sword's damage
     * @param weight
     *     the Sword's weight
     */
    public Sword(final String name, final int damage, final int weight) {
        super (name, damage, weight);
    }

    /**
     * equips an Axe using Double Dispatch
     */
    public void equipToKnight(Knight knight){
        knight.setEquippedWeapon(this);
    }

    public void equipToThief(Thief thief){
        thief.setEquippedWeapon(this);
    }

    /**
     * both methods equals() and hashcode() are different depending of the type of weapon
     * hence this methods cannot be used with inheritance
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sword)) {
            return false;
        }
        final IWeapon weapon = (IWeapon) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight());
    }
}
