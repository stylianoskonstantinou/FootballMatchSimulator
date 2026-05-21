// Main class that starts the program
public class Main {
    public static void main(String[] args) {
        // Create two teams: Olympiacos (home) and Panathinaikos (away)
        Team home = new Team("OLYMPIACOS");
        Team away = new Team("PANATHINAIKOS");

        // --- Add players to Olympiacos (home team) ---
        home.addPlayer(new Player(1, "Antonis Nikopolidis", 38, "GK", 80));        // Goalkeeper
        home.addPlayer(new Player(2, "Tasos Pantos", 35, "DEF", 55));             // Defender 1
        home.addPlayer(new Player(3, "Andreas Niniadis", 34, "DEF", 70));         // Defender 2
        home.addPlayer(new Player(4, "Grigoris Georgatos", 33, "DEF", 87));       // Defender 3
        home.addPlayer(new Player(5, "Panagiotis Kelesidis", 36, "DEF", 72));     // Defender 4
        home.addPlayer(new Player(6, "Michalis Kasnaferis", 34, "DEF", 65));      // Defender 5
        home.addPlayer(new Player(7, "Giovanni Silva de Oliveira", 35, "ATT", 80)); // Attacker 1
        home.addPlayer(new Player(8, "Predrag Djordjevic", 36, "ATT", 78));       // Attacker 2
        home.addPlayer(new Player(9, "Alekos Alexandris", 37, "ATT", 82));        // Attacker 3
        home.addPlayer(new Player(10, "Sergio Conceicao", 34, "ATT", 60));        // Attacker 4
        home.addPlayer(new Player(11, "Michalis Konstantinou", 33, "ATT", 76));   // Attacker 5

        // --- Add players to Panathinaikos (away team) ---
        away.addPlayer(new Player(1, "Jozef Wandzik", 38, "GK", 77));             // Goalkeeper
        away.addPlayer(new Player(2, "Giannis Goumas", 36, "DEF", 75));           // Defender 1
        away.addPlayer(new Player(3, "Nikos Vyntra", 35, "DEF", 73));             // Defender 2
        away.addPlayer(new Player(4, "Rene Henriksen", 37, "DEF", 70));           // Defender 3
        away.addPlayer(new Player(5, "Angelos Basinas", 36, "DEF", 85));          // Defender 4
        away.addPlayer(new Player(6, "Daniel Sariegi", 34, "DEF", 59));           // Defender 5
        away.addPlayer(new Player(7, "Christophe Dugarry", 39, "ATT", 77));       // Attacker 1
        away.addPlayer(new Player(8, "Giorgos Karagounis", 37, "ATT", 81));       // Attacker 2
        away.addPlayer(new Player(9, "Djibril Cissé", 35, "ATT", 79));            // Attacker 3
        away.addPlayer(new Player(10, "Fanis Gekas", 36, "ATT", 59));             // Attacker 4
        away.addPlayer(new Player(11, "Nikos Lymberopoulos", 38, "ATT", 54));     // Attacker 5

        // Create the match between the two teams
        Match match = new Match(home, away);

        // Print team lineups
        match.printDraft();

        // Start the game (first and second half)
        match.startGame();

        // Print final score
        match.printResults();

        // Print player(s) with most goals
        match.printBestOffencePlayer();

        // Print player(s) who was beaten most times in defense
        match.printWorstDefencePlayer();
    }
}
