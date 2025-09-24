import java.util.ArrayList;
import java.util.List;

// Η κλάση Team αναπαριστά μία ποδοσφαιρική ομάδα
public class Team {

    // Όνομα της ομάδας (π.χ. "Ολυμπιακός", "Παναθηναϊκός")
    String name;

    // Λίστα που περιέχει όλους τους παίκτες της ομάδας (11 στο σύνολο)
    List<Player> players;

    // Κατασκευαστής – αρχικοποιεί το όνομα της ομάδας και δημιουργεί μια κενή λίστα παικτών
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    // Μέθοδος για να προσθέσουμε έναν παίκτη στη λίστα της ομάδας
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Επιστρέφει λίστα παικτών με βάση τη θέση τους (π.χ. "DEF", "ATT", "GK")
    public List<Player> getPlayersByPosition(String position) {
        List<Player> list = new ArrayList<>();
        for (Player p : players) {
            // Η σύγκριση γίνεται χωρίς διάκριση πεζών/κεφαλαίων (π.χ. "att" = "ATT")
            if (p.position.equalsIgnoreCase(position)) {
                list.add(p);
            }
        }
        return list; // Επιστρέφει τους παίκτες της ζητούμενης θέσης
    }

    // Επιστρέφει τον τερματοφύλακα της ομάδας (τον πρώτο παίκτη με θέση "GK")
    public Player getGoalkeeper() {
        return getPlayersByPosition("GK").get(0); // Υποθέτουμε ότι υπάρχει πάντα 1 GK
    }
}
