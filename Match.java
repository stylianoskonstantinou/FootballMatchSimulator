import java.util.*;

// Class representing a football match between two teams
public class Match {
    Team homeTeam;      // Home team
    Team awayTeam;      // Away team
    int homeGoals = 0;  // Goals scored by home team
    int awayGoals = 0;  // Goals scored by away team
    Random random = new Random(); // For random player selection

    // Constructor – initializes the match with two teams
    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    // Displays the lineups of both teams before the match starts
    public void printDraft() {
        System.out.println("----- Home Team Lineup: " + homeTeam.name + " -----");
        for (Player p : homeTeam.players) {
            System.out.println(p); // Uses Player's toString()
        }
        System.out.println("----- Away Team Lineup: " + awayTeam.name + " -----");
        for (Player p : awayTeam.players) {
            System.out.println(p);
        }
    }

    // Starts the match – includes two halves with 5 attacks per team each half
    public void startGame() {
        System.out.println("\n----- FIRST HALF -----");
        for (int i = 0; i < 5; i++) {
            offense(homeTeam, awayTeam); // Home team attacks
            offense(awayTeam, homeTeam); // Away team attacks
        }
        System.out.println("\n----- SECOND HALF -----");
        for (int i = 0; i < 5; i++) {
            offense(homeTeam, awayTeam);
            offense(awayTeam, homeTeam);
        }
    }

    // Implements an attack from the attacking team against the defending team
    private void offense(Team attacker, Team defender) {
        // Random attacker and defender from respective lists
        Player attackerPlayer = getRandomPlayer(attacker.getPlayersByPosition("ATT"));
        Player defenderPlayer = getRandomPlayer(defender.getPlayersByPosition("DEF"));
        Player goalkeeper = defender.getGoalkeeper(); // Defender team's goalkeeper

        // Display the play phase in the console
        System.out.println("\n" + attacker.name + " is attacking!");
        System.out.println("Attacker: " + attackerPlayer.name + " (Skill " + attackerPlayer.skill + ")");
        System.out.println("Defender: " + defenderPlayer.name + " (Skill " + defenderPlayer.skill + ")");

        // If attacker has higher skill than defender
        if (attackerPlayer.skill > defenderPlayer.skill) {
            defenderPlayer.timesDefeated++; // Record defender defeat
            System.out.println("The attacker got past the defender!!");

            // If attacker also has higher skill than goalkeeper
            if (attackerPlayer.skill > goalkeeper.skill) {
                attackerPlayer.goalsScored++; // Record goal for attacker
                if (attacker == homeTeam) homeGoals++;
                else awayGoals++;
                System.out.println("GOAL by " + attackerPlayer.name + "!");
            } else {
                System.out.println("Save by goalkeeper " + goalkeeper.name + "!");
            }
        } else {
            System.out.println("Defender " + defenderPlayer.name + " stopped the attack.");
        }
    }

    // Selects a random player from a list
    private Player getRandomPlayer(List<Player> players) {
        return players.get(random.nextInt(players.size()));
    }

    // Prints the final match score
    public void printResults() {
        System.out.println("\n----- Final Score -----");
        System.out.println(homeTeam.name + ": " + homeGoals);
        System.out.println(awayTeam.name + ": " + awayGoals);
    }

    // Displays the best attackers of each team
    public void printBestOffencePlayer() {
        System.out.println("\nBest attackers per team:");

        // --- HOME TEAM ---
        List<Player> homeAttackers = homeTeam.getPlayersByPosition("ATT");
        int maxHomeGoals = homeAttackers.stream().mapToInt(p -> p.goalsScored).max().orElse(0);
        System.out.println(homeTeam.name + " (with " + maxHomeGoals + " goals):");
        if (maxHomeGoals == 0) {
            System.out.println("- No player scored.");
        } else {
            for (Player p : homeAttackers) {
                if (p.goalsScored == maxHomeGoals) {
                    System.out.println("- " + p.name);
                }
            }
        }

        // --- AWAY TEAM ---
        List<Player> awayAttackers = awayTeam.getPlayersByPosition("ATT");
        int maxAwayGoals = awayAttackers.stream().mapToInt(p -> p.goalsScored).max().orElse(0);
        System.out.println(awayTeam.name + " (with " + maxAwayGoals + " goals):");
        if (maxAwayGoals == 0) {
            System.out.println("- No player scored.");
        } else {
            for (Player p : awayAttackers) {
                if (p.goalsScored == maxAwayGoals) {
                    System.out.println("- " + p.name);
                }
            }
        }
    }

    // Displays the worst defenders of each team (most times defeated)
    public void printWorstDefencePlayer() {
        System.out.println("\nWorst defenders per team:");

        // --- HOME TEAM ---
        List<Player> homeDefenders = homeTeam.getPlayersByPosition("DEF");
        int maxHomeDefeated = homeDefenders.stream().mapToInt(p -> p.timesDefeated).max().orElse(0);
        System.out.println(homeTeam.name + " (defeated " + maxHomeDefeated + " times):");
        if (maxHomeDefeated == 0) {
            System.out.println("- No defender was defeated.");
        } else {
            for (Player p : homeDefenders) {
                if (p.timesDefeated == maxHomeDefeated) {
                    System.out.println("- " + p.name);
                }
            }
        }

        // --- AWAY TEAM ---
        List<Player> awayDefenders = awayTeam.getPlayersByPosition("DEF");
        int maxAwayDefeated = awayDefenders.stream().mapToInt(p -> p.timesDefeated).max().orElse(0);
        System.out.println(awayTeam.name + " (defeated " + maxAwayDefeated + " times):");
        if (maxAwayDefeated == 0) {
            System.out.println("- No defender was defeated.");
        } else {
            for (Player p : awayDefenders) {
                if (p.timesDefeated == maxAwayDefeated) {
                    System.out.println("- " + p.name);
                }
            }
        }
    }
}
