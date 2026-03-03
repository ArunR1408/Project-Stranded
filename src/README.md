# STRANDED — A Survival Java CLI Game

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![CLI](https://img.shields.io/badge/Interface-CLI-blue?style=for-the-badge)
![License: MIT](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)

> You wake up on a silent shore.  
> Your boat is gone. Your radio is damaged.  
> It needs **7 days** to charge.  
> **Survive until rescue arrives.**

**STRANDED** is a text-based survival simulation built in Java.  

------------------------------------------------------------------------

## Core Mechanics

Each day: - Resources decay automatically - Player chooses one action: -
Hunt - Rest - Explore - Random events may affect survival - Game ends if
any vital stat reaches zero

**Goal:** Survive 7 days and send the rescue signal.

------------------------------------------------------------------------

## Game Features

-   Resource management (Energy, Food, Morale)
-   7-day survival loop.
-   Daily resource decay system.
-   Action-based decision mechanics.
-   Random event outcomes.
-   State-dependent difficulty scaling.
-   Multiple ending conditions.
-   CLI-based immersive pacing.

------------------------------------------------------------------------

## Project Architecture

-   `Main.java` → Entry point
-   `GameEngine.java` → Game loop, decision logic, pacing
-   `Player.java` → Encapsulated player state and stat management

Concepts demonstrated:

-   Object-Oriented Programming (OOP)
-   Encapsulation
-   Conditional logic
-   Loop control
-   Randomized probability systems
-   Basic exception handling
-   Clean separation of responsibilities

------------------------------------------------------------------------

## How to Run

### Compile

``` bash
javac *.java
```

### Run

``` bash
java Main
```


------------------------------------------------------------------------

## 📜 License

This project is licensed under the MIT License.

------------------------------------------------------------------------

## 👤 Author

Arun R

PS: This is my first structured Java project.
