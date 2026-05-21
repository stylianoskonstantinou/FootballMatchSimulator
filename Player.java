// The Player class represents a football player with basic attributes and statistics
public class Player {
    // Jersey number (e.g., 7, 10, etc.)
    int number;
    // Player's full name
    String name;
    // Player's age
    int age;
    // Position on the field (GK = Goalkeeper, DEF = Defender, ATT = Attacker)
    String position;
    // Player skill level (number from 1 to 100)
    int skill;
    // Number of goals scored by the player (only for attackers)
    int goalsScored = 0;
    // Number of times defeated by an attacker (only for defenders)
    int timesDefeated = 0;

    // Constructor – initializes all basic attributes of the player
    public Player(int number, String name, int age, String position, int skill) {
        this.number = number;       // Jersey number
        this.name = name;           // Name
        this.age = age;             // Age
        this.position = position;   // Position
        this.skill = skill;         // Skill level
    }

    // Defines how the player is displayed when printed with System.out.println()
    @Override
    public String toString() {
        return "#" + number + " " + name + " (" + position + ", Skill: " + skill + ")";
    }
}
