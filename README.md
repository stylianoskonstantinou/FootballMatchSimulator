# Football Match Simulator - Master's Project

## Description

This project is a football match simulator implemented in Java as part of my master's thesis at the University of Thessaly. The program creates two football teams, each with 11 players, and simulates a full match consisting of two halves. The simulation is based on each player's skill level and random events, which determine the result of each attack and scoring.

Through this project, concepts such as object-oriented programming, collections management, random number generation, and basic game simulation principles are demonstrated.

## Features

- Creation and management of football teams and players with attributes (name, position, age, skill).
- Simulation of a match between two teams with two halves, where goals are determined by players' abilities and random factors.
- Display of each team's line-up before the match begins.
- Calculation and presentation of the final score and player statistics, including identifying top attackers and least effective defenders.
- Emphasis on clean code and proper structure, suited for educational purposes.

## Program Structure

- **Player.java**: Represents a player with individual attributes and performance statistics.
- **Team.java**: Stores and manages the players of a team.
- **Match.java**: Implements match rules and flow, including scoring logic.
- **Main.java**: Entry point that creates teams, runs the match, and displays results.

## Prerequisites

- Java Development Kit (JDK) version 8 or later
- A terminal or Integrated Development Environment (IDE) that supports Java

## Step-by-Step Execution Instructions

1. **Download or Clone the Repository**
   
   Open your terminal and run:
   ```
   git clone https://github.com/stylianoskonstantinou/FootballMatchSimulator.git
   cd FootballMatchSimulator
   ```
   Alternatively, download the ZIP file from the repository page and extract it.

2. **Compile the Java Files**
   
   At the repository directory, execute:
   ```
   javac *.java
   ```
   This command will compile all the project's source files and generate the corresponding `.class` files.

3. **Run the Program**
   
   Start the simulator by running:
   ```
   java Main
   ```
   This will launch the match simulation, display line-ups, proceed through both halves, and present results and player statistics at the end.

4. **Usage Notes**
   - Ensure that all `.java` files (Player.java, Team.java, Match.java, Main.java) exist in the same directory before compiling and running.
   - The output will appear directly in the terminal, showing both teams' line-ups, scoring events, and detailed stats.
   - No external libraries are needed; only standard Java is required.

## Expected Results

- Display of both teams before the match with player details.
- Simulation of a game with two halves, goals resulting from a combination of skills and randomness.
- Presentation of final match score and detailed statistics for each player (best attackers, least effective defenders, etc.).

## Future Extensions

- Implementation of more detailed simulation features, including tactical changes and player substitutions.
- Save and load match results from files.
- Development of a graphical user interface (GUI).
- Addition of automated unit tests for code reliability and educational use.

## Author

Stylianos Konstantinou  
Postgraduate student in Applied Informatics, Department of Electrical and Computer Engineering, University of Thessaly.

