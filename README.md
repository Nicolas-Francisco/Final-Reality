Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, 
a game developed by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and 
a group of enemies controlled by the computer.

Assumptions
---
- There are only 5 classes of players, which two of them are magical ones (Black Mage and
White Mage), and can equip only one weapon at a time. 

- Enemies cannot equip weapons, and the damage inflicted to the players is determined
by their attack attribute.

- The "Tarea 1" Version only modifies the Design and construction of the Characters and
Weapons, it is not necessary to implement spells, adverse effects, Double Dispatch nor 
Inventory.

- An enemy can attack to a player or another enemy, and a player can attack to an enemy 
or another player.

- The Thief can equip swords, knives and bows.
- The Knight can equip swords, knives and axes.
- The Engineer can equip axes and bows.
- The White Mage can only equip staffs.
- The Black Mage can equip staffs and knives.

- There are two and only two parties in the controller, one exclusive for the players
, and the other one exclusive for the enemies.

- The game will end in two possible ways: If all the enemies die, the player party wins, and the victory method
triggers. However, if all the players die, then the enemy party wins, and the gameOver method 
triggers.



Original Version Design
---
To create the different Characters of this game, we create the Interface **ICharacter** 
that unifies all kinds of characters (both playable and not playable), which is 
implemented by the abstract class **AbstractCharacter**.

From **AbstractCharacter** we extend two classes, Enemy class and Player class. The Enemy
class represents all the enemies of the game, and the Player Class represents every 
playable character. In **AbstractCharacter** we implement two methods that, depending 
on the class, it might work one way or the other, these methods are waitTurn() and
equip() (Enemies can't equip weapons).

Both Weapons and Players have a new parameter called WeaponType and CharacterClass 
respectively, and all the characters can equip only certain types of weapons depending
on the CharacterClass.
 
"Tarea 1" version Design
---

To create the different Characters of this game, we create the Interface **ICharacter** 
that unifies all kinds of characters (both playable and not playable), which is 
implemented by the abstract class **AbstractCharacter**. All the characters from the 
game have the same parameters such as a name, hp (health points), defense, and a 
BlockingQueue for the combat.

The class **Enemy** extends **AbstractCharacter**, this is a character controlled by
the computer and has new parameters, weight and attack. This class also has a waitTurn()
method for the combat.

The abstract class **AbstractPlayerCharacter** extends **AbstractCharacter**, this 
represents a playable character of the game. In this class we have two new important 
methods, waitTurn() (which works different from the enemies' homonym method), and the
equip() method that equips a weapon to the player.

Every character from the game has a specific class, and depending on the class, the 
player might have MP (magic points) to use spells or not, or could equip certain
types of weapons or nat. If we implement a parameter that discriminates these 
abilities (such as CharacterClass parameter) this will make the code extendable (Double
Dispatch). Hence, the classes will figure this out and implement these ideas by themselves.

By the other hand, we have an Interface **IWeapon** which unifies every weapon in the 
game, and for the same reason we don't have a parameter that determines the character 
class, we make different classes depending on the type of weapon, which extends 
**AbstractWeapon** class.

In this version all the original tests are changed in order to test this new Design.

"Entrega Parcial 1 - Tarea 2" version Design
---

The previous design (Tarea 1) does not implement an Inteface for the Player (it is not a good
design to call an Abstract Class, therefore, there must be an Interface). In this new version
we modify this error and create a new Interface IPlayer, which has all equip() methods (described
in the next paragraph) and the get/set methods for the equipped weapon.

Besides this, the design (Tarea 1) stays the same except for equip() method. Using Double
Dispatch we implement a base equip_weapon() for every weapon in the AbstractPlayer Class
that is not implemented in order to avoid errors if we try to equip a weapon that some 
class should not equip. Therefore, every player class overrides equip_weapon() and 
implements it if the weapon type can be used for the player.  

Also, we implement new methods to the Interface ICharacter (shared between players and 
enemies), these methods are attackTo(), attackedBy() and IsAlive(). attackTo() method attacks the 
another character, and IsAlive() method returns a boolean depending on the character's HP.
attackTo() works different if the character that attacks is an enemy or a player, because an
enemy has a specific attribute called attack while the player does not (the damage inflicted
by the player depends on the equipped weapon's damage).


"Tarea 2" version Design
---

In this version we created the controller of the game (GameController class), the inventory of the game
 (controller by the GameController), and the observer for the players and enemies 
 within the game. The IEventHandler interface extends the PropertyChangeListener,
which is extended by two new handlers (PlayerHandler and EnemyHandler, where both are observers of the
players and enemies). Whenever a player or an enemy dies, the onDeadPlayer or on DeadEnemy methods of 
the controller triggers to see if all the enemies or players had died.  

In the controller class we implement all the creation methods to put in both parties and inventory. 
The ones that create characters (such as createKnight, createEnemy, etc.) create the character and adds it
to its party depending on it's class (player or enemy). By the other hand the ones that create
weapons (such as createKnife, createStaff, etc.) create the weapon and then adds it to the inventory.

The inventory is represented by a HashMap using a string as a key (the name of the weapon), 
eliminating the "Inventory" class, while the party is represented by an ArrayList of characters,
 eliminating the "User" class.



Testing
---
To execute the testings of this work you will need to change the coverage settings as
shown in this [video](https://www.youtube.com/watch?v=VVxERw4cpOY&list=PLUt1A-R2OH5788r_u0y9XeuUVx6thIVkI&index=3).
Then you only have to right-click on **test** package and select **Run 'tests in 
'final...'' with Coverage'**.
