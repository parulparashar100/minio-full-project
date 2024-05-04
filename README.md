## Problem Statement
Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute, and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. Any two players can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack” value multiplied by the outcome of the attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by the attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. The game ends when any player's health reaches 0.

Player with lower health attacks first at the start of a match.

Assume two players. Player A: 50 health, 5 strength, 10 attack. Player B: 100 health, 10 strength, and 5 attack. Attacking die and Defending die are both 6-sided die with values ranging from 1 to 6.

Player A attacks and rolls die. Die roll: 5. Player B defends and rolls die. Die roll: 2.

Attack damage is 5 * 10 = 50; Defending strength = 10 * 2 = 20; Player B health reduced by 30 to 70.

Player B attacks and rolls die. Die roll: 4. Player A defends and rolls die. Die Roll: 3.

Attack damage is 4 * 5 = 20; Defending strength = 5 * 3 = 15; Player A health reduced by 5 to 45.

And so on.

**Rules of the Game:**

You can use Java, Go, or Node.js to implement the solution, without using any third-party libraries or frameworks (common and essential helper libs and packages are allowed, e.g., math.rand() is ok).
The code should NOT be hosted on GitHub or made public. Create a zip of the folder with local git history and you should provide us with the zip.
You should provide a README file in the repository that explains how to run the code and any other relevant information.
You should provide unit tests for your solution.
We expect you to commit frequently with relevant commit messages. Multiple incremental commits are valued over one all-inclusive commit.

---

Certainly! Below is a README file outlining the steps you provided:

---

# Magical Arena Game

This project implements a simple text-based game called "Magical Arena" in Java. In this game, two players battle each other in an arena until one of them loses all their health.


## Instructions for Development

1. **Java Project Setup**: Set up a Java project in your preferred IDE (I am working in SpringBoot).
   
2. **Implement Game Logic**:
   - Create a Java class named `MagicalArena`.
   - Implement the game logic within this class, including player attributes, dice rolling, and the main game loop. **Code you can find inside MagicalArena_Swiggy-->src-->MagicalArena**
   - Ensure to commit your changes regularly with descriptive commit messages.

3. **Write Unit Tests**:
   - Create a JUnit test class named `MagicalArenaTests`.
   - Write test cases to validate the behavior of the `MagicalArena` class methods. **Code you can find inside MagicalArena_Swiggy-->src-->MagicalArenaTests**    
   - Run the tests to ensure the correctness of the implementation.

4. **Commit Changes**: Make frequent commits to track your progress and ensure version control. Use meaningful commit messages to describe the changes made.

5. **Review Code**: Review your code to ensure readability, maintainability, and adherence to best practices.

6. **Run Tests**: Regularly run the unit tests to verify the correctness of the implementation.


## Project Structure

- `MagicalArena.java`: This class contains the main logic for the Magical Arena game. It handles player attributes, dice rolling, and game flow.
- `MagicalArenaTests.java`: This JUnit test class contains test cases to verify the functionality of the `MagicalArena` class.

![project_heirarchy](https://github.com/parulparashar100/minio-full-project/assets/74699172/910fdf7c-f6f9-4310-bda9-c4ffad2610cd)



## Dependencies

- Java Development Kit (JDK)
- JUnit (for unit testing)
