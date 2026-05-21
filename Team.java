import java.util.ArrayList;
import java.util.List;

// The Team class represents a football team
public class Team {
    // Team name (e.g., "Olympiacos", "Panathinaikos")
    String name;
    // List containing all players of the team (11 in total)
    List<Player> players;

    // Constructor – initializes the team name and creates an empty list of players
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    // Method to add a player to the team's list
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Returns a list of players based on their position (e.g., "DEF", "ATT", "GK")
    public List<Player> getPlayersByPosition(String position) {
        List<Player> list = new ArrayList<>();
        for (Player p : players) {
            // Comparison is case-insensitive (e.g., "att" = "ATT")
            if (p.position.equalsIgnoreCase(position)) {
                list.add(p);
            }
        }
        return list; // Returns players of the requested position
    }

    // Returns the goalkeeper of the team (the first player with position "GK")
    public Player getGoalkeeper() {
        return getPlayersByPosition("GK").get(0); // Assumes there is always 1 GK
    }
}
