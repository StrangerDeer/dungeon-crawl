
# Dungeon Crawl

## About the project

This project was a task on OOP module in Codecool. We liked this project, because we love videogames.
We got a skeleton code, this skeleton code contains the Java Fx featuers, and we added the gameplay, new design.
Our background story is The Duck wants to save the world from the evil chicken priccess sorcerer and her terrifying minons.
The gameplay is basic, but it revives the old age videogames.
You can read belove what were our tasks on that week.


## The features implemented by

[rBabett](https://github.com/rBabett)
[StrangerDeer](https://github.com/StrangerDeer)

## Story

[Roguelikes](https://en.wikipedia.org/wiki/Roguelike) are one of the oldest
types of video games. The earliest ones were made in the 70s, and they were inspired
a lot by tabletop RPGs. Roguelikes usually have the following features in common.

- They are tile-based.
- The game is divided into turns, that is, you take one action, then the other
  entities (monsters, allies, and so on, controlled by the CPU) take one.
- The task is usually to explore a labyrinth and retrieve some treasure from its
  bottom.
- They feature permadeath: if you die, it's game over, you need to start from the
  beginning again.
- They rely heavily on procedural generation: Levels, monster placement, items, and so on
  are randomized, so the game does not get boring.

Your task is to create a roguelike. You can deviate from the rules above,
the important bit is that it should be fun.

## What are you going to learn?

- Get more practice in OOP.
- Understand design patterns: layer separation. (All of the game logic, such as player
  movement, game rules, and so on), is in the `logic` package, completely
  independent of user interface code. In principle, you could implement a
  completely different interface, such as terminal, web, Virtual Reality, and so on, for
  the same logic code.)

## Tasks

1. Analyze the project\
   Understand the existing code, classes, and tests so you can make changes. Do this before planning anything else. It helps you understand what is going on.
   - A plan is created with task lists.

2. Restrict movement\
   Create a game logic which restricts the movement of the player so they cannot run into walls and monsters.
    - The hero is not able to move into walls.
    - The hero is not able to move into monsters.

3. Dungeon items\
There are items lying around the dungeon. They are visible in the GUI. 
   - There are at least two item types, such as a key and a sword.
   - There can be one item in a map square.
   - A player can stand on the same square as an item.
   - The item must be displayed on screen (unless somebody stands on the same square).

4. Pick up items\
Create a feature that allows the hero to pick up an item.
   - There is a way to pick up items.
   - After the player picks up the item, the item the hero is standing on is gone from map.

5. Show picked up items\
   Show picked up items in the inventory list.
   - There is an `Inventory` list on the screen.
   - After the hero picks up an item, it appears in the inventory.

6. Attack monsters\
   Make the hero able to attack monsters by moving into them.
   - Attacking a monster removes 5 health points. If the health of a monster goes below 0, it dies and disappears.
   - If the hero attacks a monster and it does not die, it also attacks the hero at the same time (it only removes 2 health points).
   - Having a weapon increases attack strength.
   - Different monsters have different health and attack strengths.

7. Doors and keys\
   Create doors in the dungeon that are opened using keys.
   - There are two new square types, closed door and open door.
   - The hero cannot pass through a closed door unless there is a key in the inventory. After moving through, the closed door becomes an open door.

8. Different monsters\
   Create three different monster types with different behaviors.
    - There are at least three different monster types with different behaviors.
    - One type of monster does not move at all.
    - One type of monster moves randomly. It cannot go trough walls or open doors.

9. **OPTIONAL TASK:** Better movement AI\
   Create a more sophisticated movement AI.
    - One type of monster moves around randomly and teleports to a random free square every few turns.
    - A custom movement logic is implemented (such as Ghosts that can move trough walls, or a monster that chases the player).

10. More map features\
    Create maps that have more varied scenery. Take a look at the tile sheet (tiles.png). Get inspired!
    - At least three more tiles are used. These can be more monsters, items, or background. At least one of them must be not purely decorative, but have some effect on gameplay.

