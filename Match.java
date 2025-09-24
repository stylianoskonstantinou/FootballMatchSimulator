import java.util.*;

// Κλάση που αναπαριστά έναν ποδοσφαιρικό αγώνα ανάμεσα σε δύο ομάδες
public class Match {
    Team homeTeam;    // Γηπεδούχος ομάδα
    Team awayTeam;    // Φιλοξενούμενη ομάδα
    int homeGoals = 0; // Γκολ της γηπεδούχου ομάδας
    int awayGoals = 0; // Γκολ της φιλοξενούμενης ομάδας
    Random random = new Random(); // Για τυχαία επιλογή παικτών

    // Constructor – αρχικοποιεί τον αγώνα με τις δύο ομάδες
    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    // Εμφανίζει τις συνθέσεις των δύο ομάδων πριν την έναρξη του αγώνα
    public void printDraft() {
        System.out.println("-----Παρουσίαση γηπεδούχου ομάδας: " + homeTeam.name + "-----");
        for (Player p : homeTeam.players) {
            System.out.println(p); // Χρήση της toString() του Player
        }
        System.out.println("-----Παρουσίαση φιλοξενούμενης ομάδας: " + awayTeam.name + "-----");
        for (Player p : awayTeam.players) {
            System.out.println(p);
        }
    }

    // Ξεκινάει τον αγώνα – περιλαμβάνει δύο ημίχρονα με 5 επιθέσεις ανά ομάδα σε κάθε ένα
    public void startGame() {
        System.out.println("\n----- ΠΡΩΤΟ ΗΜΙΧΡΟΝΟ -----");
        for (int i = 0; i < 5; i++) {
            offense(homeTeam, awayTeam); // Γηπεδούχος επιτίθεται
            offense(awayTeam, homeTeam); // Φιλοξενούμενος επιτίθεται
        }

        System.out.println("\n----- ΔΕΥΤΕΡΟ ΗΜΙΧΡΟΝΟ -----");
        for (int i = 0; i < 5; i++) {
            offense(homeTeam, awayTeam);
            offense(awayTeam, homeTeam);
        }
    }

    // Υλοποιεί μία επίθεση από την attacking ομάδα προς την defending ομάδα
    private void offense(Team attacker, Team defender) {
        // Τυχαίος επιθετικός και αμυντικός από τις αντίστοιχες λίστες
        Player attackerPlayer = getRandomPlayer(attacker.getPlayersByPosition("ATT"));
        Player defenderPlayer = getRandomPlayer(defender.getPlayersByPosition("DEF"));
        Player goalkeeper = defender.getGoalkeeper(); // Τερματοφύλακας της defending ομάδας

        // Εμφάνιση φάσης στην κονσόλα
        System.out.println("\n" + attacker.name + " επιτίθεται!");
        System.out.println("Επιθετικός: " + attackerPlayer.name + " (Ικανότητα " + attackerPlayer.skill + ")");
        System.out.println("Αμυντικός: " + defenderPlayer.name + " (Ικανότητα " + defenderPlayer.skill + ")");

        // Αν ο επιθετικός έχει μεγαλύτερη ικανότητα από τον αμυντικό
        if (attackerPlayer.skill > defenderPlayer.skill) {
            defenderPlayer.timesDefeated++; // Καταγραφή ήττας στον αμυντικό
            System.out.println("Ο επιθετικός πέρασε τον αμυντικό!!");

            // Αν έχει μεγαλύτερη ικανότητα και από τον τερματοφύλακα
            if (attackerPlayer.skill > goalkeeper.skill) {
                attackerPlayer.goalsScored++; // Καταγραφή γκολ στον επιθετικό
                if (attacker == homeTeam) homeGoals++;
                else awayGoals++;
                System.out.println("ΓΚΟΛΑΡΑ από τον " + attackerPlayer.name + "!");
            } else {
                System.out.println("Απόκρουση από τον τερματοφύλακα " + goalkeeper.name + "!");
            }
        } else {
            System.out.println("Ο αμυντικός " + defenderPlayer.name + " σταμάτησε την επίθεση.");
        }
    }

    // Επιλέγει τυχαία έναν παίκτη από λίστα
    private Player getRandomPlayer(List<Player> players) {
        return players.get(random.nextInt(players.size()));
    }

    // Εκτύπωση τελικού σκορ αγώνα
    public void printResults() {
        System.out.println("\n----- Τελικό Σκορ -----");
        System.out.println(homeTeam.name + ": " + homeGoals);
        System.out.println(awayTeam.name + ": " + awayGoals);
    }

    // Εμφανίζει τους καλύτερους επιθετικούς κάθε ομάδας
    public void printBestOffencePlayer() {
        System.out.println("\nΚαλύτεροι επιθετικοί ανά ομάδα:");

        // --- ΟΛΥΜΠΙΑΚΟΣ ---
        List<Player> homeAttackers = homeTeam.getPlayersByPosition("ATT");
        int maxHomeGoals = homeAttackers.stream().mapToInt(p -> p.goalsScored).max().orElse(0);
        System.out.println("ΟΛΥΜΠΙΑΚΟΣ (με " + maxHomeGoals + " γκολ):");

        if (maxHomeGoals == 0) {
            System.out.println("- Κανένας παίκτης δεν σκόραρε.");
        } else {
            for (Player p : homeAttackers) {
                if (p.goalsScored == maxHomeGoals) {
                    System.out.println("- " + p.name);
                }
            }
        }

        // --- ΠΑΝΑΘΗΝΑΙΚΟΣ ---
        List<Player> awayAttackers = awayTeam.getPlayersByPosition("ATT");
        int maxAwayGoals = awayAttackers.stream().mapToInt(p -> p.goalsScored).max().orElse(0);
        System.out.println("ΠΑΝΑΘΗΝΑΙΚΟΣ (με " + maxAwayGoals + " γκολ):");

        if (maxAwayGoals == 0) {
            System.out.println("- Κανένας παίκτης δεν σκόραρε.");
        } else {
            for (Player p : awayAttackers) {
                if (p.goalsScored == maxAwayGoals) {
                    System.out.println("- " + p.name);
                }
            }
        }
    }

    // Εμφανίζει τους χειρότερους αμυντικούς κάθε ομάδας
    public void printWorstDefencePlayer() {
        System.out.println("\nΧειρότεροι αμυντικοί ανά ομάδα:");

        // --- ΟΛΥΜΠΙΑΚΟΣ ---
        List<Player> homeDefenders = homeTeam.getPlayersByPosition("DEF");
        int maxHomeDefeated = homeDefenders.stream().mapToInt(p -> p.timesDefeated).max().orElse(0);
        System.out.println("ΟΛΥΜΠΙΑΚΟΣ (νικήθηκε/αν " + maxHomeDefeated + " φορές):");

        if (maxHomeDefeated == 0) {
            System.out.println("- Κανένας αμυντικός δεν νικήθηκε.");
        } else {
            for (Player p : homeDefenders) {
                if (p.timesDefeated == maxHomeDefeated) {
                    System.out.println("- " + p.name);
                }
            }
        }

        // --- ΠΑΝΑΘΗΝΑΙΚΟΣ ---
        List<Player> awayDefenders = awayTeam.getPlayersByPosition("DEF");
        int maxAwayDefeated = awayDefenders.stream().mapToInt(p -> p.timesDefeated).max().orElse(0);
        System.out.println("ΠΑΝΑΘΗΝΑΙΚΟΣ (νικήθηκε/αν " + maxAwayDefeated + " φορές):");

        if (maxAwayDefeated == 0) {
            System.out.println("- Κανένας αμυντικός δεν νικήθηκε.");
        } else {
            for (Player p : awayDefenders) {
                if (p.timesDefeated == maxAwayDefeated) {
                    System.out.println("- " + p.name);
                }
            }
        }
    }
}
