package com.github.cc3002.finalreality.model.controller;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.ArrayList;

/**
 * This class represents a user in the "final reality".
 *
 * @author Nicolás García Ríos
 */
public class User {
    private ArrayList<ICharacter> party;
    private int max;
    private int aliveCharacters;

    public User(int max){
        this.party = new ArrayList<ICharacter>();
        this.max = max;
        this.aliveCharacters = max;
    }

    public ArrayList<ICharacter> getParty(){
        return this.party;
    }

    public void putInParty(ICharacter character){
        if (party.size() < max){
            this.getParty().add(character);
        }
    }

    public void removeFromParty(int characterIndex){
        this.getParty().remove(characterIndex);
    }

    public ICharacter getCharacter(int characterIndex){
        return (ICharacter) this.getParty().get(characterIndex);
    }

    public void killCharacter(){
        aliveCharacters --;
    }

    public int getAliveCharacters(){
        return this.aliveCharacters;
    }
}
