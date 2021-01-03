package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.controller.observer.EnemyHandler;
import com.github.cc3002.finalreality.model.controller.observer.IEventHandler;
import com.github.cc3002.finalreality.model.controller.observer.PlayerHandler;
import com.github.cc3002.finalreality.model.controller.observer.TurnHandler;
import com.github.cc3002.finalreality.model.controller.state.GameState;
import com.github.cc3002.finalreality.model.controller.state.StartState;
import com.github.cc3002.finalreality.model.weapon.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The "final reality" game controller.
 *
 * @author Nicolás García Ríos
 */
public class GameController {
    private HashMap<String, IWeapon> inventory;
    private int maxCharacters = 4;
    private ArrayList<IPlayer> gamerParty;
    private ArrayList<Enemy> cpuParty;
    private int alivePlayers;
    private int aliveEnemies;
    private final IEventHandler DeadPlayerHandler = new PlayerHandler(this);
    private final IEventHandler DeadEnemyHandler = new EnemyHandler(this);
    private final IEventHandler TurnHandler = new TurnHandler(this);
    private GameState state;
    protected BlockingQueue<ICharacter> turnsQueue;
    protected int enemies;
    private ICharacter characterTurn;
    private boolean lockTurn1 = false;
    private boolean lockTurn2 = false;

    public GameController(){
        this.state = new StartState(this);
        this.turnsQueue = new LinkedBlockingQueue<ICharacter>();
        this.inventory = new HashMap<String, IWeapon>();
        this.gamerParty = new ArrayList<IPlayer>();
        this.cpuParty = new ArrayList<Enemy>();
        this.aliveEnemies = 0;
        this.alivePlayers = 0;
    }


    /**
     * tryToStart() method tries to start the game
     */
    public void tryToStart(){
        this.state.tryToStart();
    }

    /**
     * tryToBeginTurn() method tries to begin the next turn, asking the state pattern
     */
    public void tryToBeginTurn(){
        if (!lockTurn1){
            lockTurn1 = true;
            this.state.tryToBeginTurn();
        }
    }

    /**
     * tryToEquip() method tries to equip a weapon to the player. Assuming the player can only change
     * the equipped weapon in a turn, and not between two.
     */
    public void tryToEquip(int playerIndex, String weaponName){
        this.state.equip(playerIndex, weaponName);
    }

    /**
     * tryToAttack() method tries to attack a character. Assuming that some character can attack to another
     * during a turn only, and not between two.
     */
    public void tryToAttack(ICharacter attackerCharacter, ICharacter attackedCharacter){
        this.state.attack(attackerCharacter, attackedCharacter);
    }

    /**
     * setState() method changes the state of the game.
     */
    public void setState(GameState state){
        this.state = state;
    }

    /**
     * startQueue() method puts all the characters to the turns queue.
     */
    public void startQueue(){
        if (this.gamerParty.size() == this.maxCharacters){
            int numberPlayer = 0;
            int numberEnemies = 0;
            while (numberPlayer < this.gamerParty.size()){
                IPlayer player = this.getPlayer(numberPlayer);
                player.waitTurn();
                numberPlayer ++;
            }
            while (numberEnemies < this.cpuParty.size()) {
                Enemy enemy = this.getEnemy(numberEnemies);
                enemy.waitTurn();
                numberEnemies++;
            }
            this.state.waiting();
        }
    }

    /**
     * beginTurn() method designs the character who owns the actual turn. If the character is dead, then it
     * ends it's turn immediately, passing to the next alive character. By the other hand if the character
     * is an enemy, it only attacks a random player and finishes it's turn (through tryToAttack method).
     */
    public void beginTurn(){
        if (!lockTurn2){
            lockTurn2 = true;
            this.characterTurn = turnsQueue.peek();
            if(this.characterTurn.IsAlive()){
                this.state.beginTurn();
                System.out.println(this.characterTurn.getName() + "'s turn");
                this.characterTurn.useTurn(this);
            }
            else {
                this.state.endTurn();
            }
        }
    }

    /**
     * attackRandomPlayer() is called when an enemy just started it's turn. It only attacks a random player
     * from the player party, and if the player chosen is dead, we repeat the process using recursion.
     */
    public void attackRandomPlayer(){
        int rand = new Random().nextInt(4);
        if (this.getPlayer(rand).IsAlive()){
            attack(this.characterTurn, this.getPlayer(rand));
        } else {
            attackRandomPlayer();
        }
        return;
    }

    /**
     * endTurn() method ends the actual turn, making the last character wait.
     */
    public void endTurn(){
        System.out.println(this.characterTurn.getName() + "´s turn has ended");
        turnsQueue.poll();
        this.getCharacterTurn().waitTurn();
        state.waiting();
        lockTurn1 = false;
        lockTurn2 = false;
        if(!turnsQueue.isEmpty()){
            tryToBeginTurn();
        }
    }

    /**
     * attack() method attacks the second character using the first one. Then it ends its turn
     */
    public void attack(ICharacter attackerCharacter, ICharacter attackedCharacter){
        System.out.println(attackerCharacter.getName() + " attacks " + attackedCharacter.getName());
        attackerCharacter.attackTo(attackedCharacter);
        if (!this.state.isVictoryState()){
            System.out.println(attackedCharacter.getName() + "'s current hp: " + attackedCharacter.getHP());
            endTurn();
        }
    }

    /**
     * equip() method equips a weapon to the player
     */
    public void equip(int playerIndex, String weaponName){
        IWeapon weapon = this.inventory.get(weaponName);
        IPlayer player = this.getPlayer(playerIndex);
        IWeapon currentWeapon = player.getEquippedWeapon();
        player.equip(weapon);
        if (currentWeapon == null){
            if (player.getEquippedWeapon() != null){
                inventory.remove(weapon.getName());
                System.out.println(player.getName() + " equips " + player.getEquippedWeapon().getName());
                System.out.println(player.getEquippedWeapon().getName() + "'s damage: " +
                        player.getEquippedWeapon().getDamage());
            }
        } else {
            if (player.getEquippedWeapon().hashCode() == weapon.hashCode()){
                inventory.remove(weapon.getName());
                inventory.put(currentWeapon.getName(), currentWeapon);
                System.out.println(player.getName() + " equips " + weapon.getName());
                System.out.println(currentWeapon.getName() + " saved");
                System.out.println(weapon.getName() + "'s damage: " + weapon.getDamage());
            }
        }
    }

    /**
     * onDeadEnemy() method is triggered when an enemy dies (EnemyHandler). This method reduces the amount
     * of aliveCharacters in the User class and then checks if the gamer wins.
     */
    public void onDeadEnemy(Enemy enemy) {
        this.aliveEnemies --;
        System.out.println(enemy.getName() + " of the Enemy party has died");
        if (this.getAliveEnemies() == 0){
            this.state.victory();
        }
    }

    /**
     * onDeadEnemy() method is triggered when a player dies (PlayerHandler). This method reduces the amount
     * of aliveCharacters in the User class and then checks if the gamer loses.
     */
    public void onDeadPlayer(IPlayer player) {
        this.alivePlayers --;
        System.out.println(player.getName() + " of the Player party has died");
        if (this.getAlivePlayers() == 0){
            this.state.gameOver();
        }
    }


    /**
     * putInPlayerParty() method adds a player to the gamer party, with a limit given by the user
     */
    public void putInPlayerParty(IPlayer player){
        if (gamerParty.size() < this.maxCharacters){
            gamerParty.add(player);
            this.alivePlayers ++;
            player.addListenerDead(DeadPlayerHandler);
            player.addListenerTurn(TurnHandler);
        }
    }

    /**
     * putInEnemyParty() method adds an enemy to the gamer party, with a limit given by the user
     */
    public void putInEnemyParty(Enemy enemy){
        if (cpuParty.size() < this.enemies){
            cpuParty.add(enemy);
            this.aliveEnemies ++;
            enemy.addListenerDead(DeadEnemyHandler);
            enemy.addListenerTurn(TurnHandler);
        }
    }

    /**
     * createKnight() method creates a Knight with the information given and then it is added to the party
     */
    public Knight createKnight(String name, int hp , int defense){
        Knight knight = new Knight(name, turnsQueue, hp, defense);
        this.putInPlayerParty(knight);
        return knight;
    }

    /**
     * createThief() method creates a Thief with the information given and then it is added to the party
     */
    public Thief createThief(String name, int hp , int defense){
        Thief thief = new Thief(name, turnsQueue, hp, defense);
        this.putInPlayerParty(thief);
        return thief;
    }

    /**
     * createEngineer() method creates an Engineer with the information given and then it is added to the party
     */
    public Engineer createEngineer(String name, int hp , int defense){
        Engineer engineer = new Engineer(name, turnsQueue, hp, defense);
        this.putInPlayerParty(engineer);
        return engineer;
    }

    /**
     * createWhiteMage() method creates a White Mage with the information given and then it is added to the party
     */
    public WhiteMage createWhiteMage(String name, int hp , int defense, int mp){
        WhiteMage whitemage = new WhiteMage(name, turnsQueue, hp, defense, mp);
        this.putInPlayerParty(whitemage);
        return whitemage;
    }

    /**
     * createBlackMage() method creates a Black Mage with the information given and then it is added to the party
     */
    public BlackMage createBlackMage(String name, int hp , int defense, int mp){
        BlackMage blackmage = new BlackMage(name, turnsQueue, hp, defense, mp);
        this.putInPlayerParty(blackmage);
        return blackmage;
    }

    /**
     * createEnemy() method creates an Enemy with the information given, and then it is added to the EnemyParty
     */
    public void createEnemy(String name, int hp, int defense, int attack, int weight){
        Enemy enemy = new Enemy(name, turnsQueue, weight, hp, defense, attack);
        this.putInEnemyParty(enemy);
    }

    /**
     * createAxe() method creates an axe with the information given and then it is added to the inventory
     */
    public void createAxe(String name, int damage, int weight){
        Axe axe = new Axe(name, damage, weight);
        inventory.put(axe.getName(), axe);
    }

    /**
     * createBow() method creates a bow with the information given and then it is added to the inventory
     */
    public void createBow(String name, int damage, int weight){
        Bow bow = new Bow(name, damage, weight);
        inventory.put(bow.getName(), bow);
    }

    /**
     * createKnife() method creates a knife with the information given and then it is added to the inventory
     */
    public void createKnife(String name, int damage, int weight){
        Knife knife = new Knife(name, damage, weight);
        inventory.put(knife.getName(), knife);
    }

    /**
     * createStaff() method creates a staff with the information given and then it is added to the inventory
     */
    public void createStaff(String name, int damage, int weight){
        Staff staff = new Staff(name, damage, weight);
        inventory.put(staff.getName(), staff);
    }

    /**
     * createSword() method creates a sword with the information given and then it is added to the inventory
     */
    public void createSword(String name, int damage, int weight){
        Sword sword = new Sword(name, damage, weight);
        inventory.put(sword.getName(), sword);
    }

    /**
     * gameOver() finalizes the game when the gamer loses.
     */
    public void gameOver(){
        System.out.println("YOU DIED");
    }

    /**
     * victory() finalizes the game when the gamer wins.
     */
    public void victory(){
        System.out.println("HEIR OF FIRE DESTROYED");
    }

    /**
     * setter for the amount of enemies.
     */
    public void setNumberOfEnemies(int num){
        this.enemies = num;
    }

    /**
     * getters methods.
     */

    public ArrayList<String> getInventoryKeys(){
        ArrayList<String> keys = new ArrayList<>();
        this.getInventory().forEach((key, weapon) -> {
            keys.add(key);
        });
        return keys;
    }

    public int getNumberOfEnemies(){return this.enemies;}

    public ArrayList<IPlayer> getGamerParty(){return this.gamerParty;}

    public ArrayList<Enemy> getCpuParty(){return this.cpuParty;}

    public HashMap<String, IWeapon> getInventory(){return this.inventory;}

    public int getAlivePlayers(){return this.alivePlayers;}

    public int getAliveEnemies(){return this.aliveEnemies;}

    public Enemy getEnemy(int enemyIndex){
        return this.getCpuParty().get(enemyIndex);
    }

    public IPlayer getPlayer(int playerIndex){
        return this.getGamerParty().get(playerIndex);
    }

    public ICharacter getCharacterTurn(){
        return this.characterTurn;
    }

    public IWeapon getEquippedWeapon(int playerIndex){
        return this.getPlayer(playerIndex).getEquippedWeapon();
    }
}