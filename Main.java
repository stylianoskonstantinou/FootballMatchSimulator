// Κύρια κλάση που εκκινεί το πρόγραμμα
public class Main {
    public static void main(String[] args) {

        // Δημιουργία δύο ομάδων: Ολυμπιακός (γηπεδούχος) και Παναθηναϊκός (φιλοξενούμενος)
        Team home = new Team("ΟΛΥΜΠΙΑΚΟΣ");
        Team away = new Team("ΠΑΝΑΘΗΝΑΙΚΟΣ");

        // --- Προσθήκη παικτών στον Ολυμπιακό (home team) ---
        home.addPlayer(new Player(1, "Αντώνης Νικοπολίδης", 38, "GK", 80));       // Τερματοφύλακας
        home.addPlayer(new Player(2, "Τάσος Πάντος", 35, "DEF", 55));             // Αμυντικός 1
        home.addPlayer(new Player(3, "Ανδρέας Νινιάδης", 34, "DEF", 70));         // Αμυντικός 2
        home.addPlayer(new Player(4, "Γρηγόρης Γεωργάτος", 33, "DEF", 87));       // Αμυντικός 3
        home.addPlayer(new Player(5, "Παναγιώτης Κελεσίδης", 36, "DEF", 72));     // Αμυντικός 4
        home.addPlayer(new Player(6, "Μιχάλης Κασναφέρης", 34, "DEF", 65));       // Αμυντικός 5
        home.addPlayer(new Player(7, "Τζιοβάνι Σίλβα ντε Ολιβέιρα", 35, "ATT", 80)); // Επιθετικός 1
        home.addPlayer(new Player(8, "Πρέντραγκ Τζόρτζεβιτς", 36, "ATT", 78));    // Επιθετικός 2
        home.addPlayer(new Player(9, "Αλέκος Αλεξανδρής", 37, "ATT", 82));        // Επιθετικός 3
        home.addPlayer(new Player(10, "Σέρτζιο Κονσεϊσάο", 34, "ATT", 60));       // Επιθετικός 4
        home.addPlayer(new Player(11, "Μιχάλης Κωνσταντίνου", 33, "ATT", 76));    // Επιθετικός 5

        // --- Προσθήκη παικτών στον Παναθηναϊκό (away team) ---
        away.addPlayer(new Player(1, "Γιόζεφ Βάντσικ", 38, "GK", 77));             // Τερματοφύλακας
        away.addPlayer(new Player(2, "Γιάννης Γκούμας", 36, "DEF", 75));           // Αμυντικός 1
        away.addPlayer(new Player(3, "Νίκος Βύντρα", 35, "DEF", 73));              // Αμυντικός 2
        away.addPlayer(new Player(4, "Ρενέ Χένρικσεν", 37, "DEF", 70));            // Αμυντικός 3
        away.addPlayer(new Player(5, "Άγγελος Μπασινάς", 36, "DEF", 85));          // Αμυντικός 4
        away.addPlayer(new Player(6, "Ντάνιελ Σαριέγκι", 34, "DEF", 59));          // Αμυντικός 5
        away.addPlayer(new Player(7, "Κριστόφ Βαζέχα", 39, "ATT", 77));            // Επιθετικός 1
        away.addPlayer(new Player(8, "Γιώργος Καραγκούνης", 37, "ATT", 81));       // Επιθετικός 2
        away.addPlayer(new Player(9, "Τζιμπρίλ Σισέ", 35, "ATT", 79));             // Επιθετικός 3
        away.addPlayer(new Player(10, "Φάνης Γκέκας", 36, "ATT", 59));             // Επιθετικός 4
        away.addPlayer(new Player(11, "Νίκος Λυμπερόπουλος", 38, "ATT", 54));      // Επιθετικός 5

        // Δημιουργία της αναμέτρησης μεταξύ των δύο ομάδων
        Match match = new Match(home, away);

        // Εμφάνιση των συνθέσεων των ομάδων
        match.printDraft();

        // Έναρξη του αγώνα (πρώτο και δεύτερο ημίχρονο)
        match.startGame();

        // Εμφάνιση τελικού σκορ
        match.printResults();

        // Εμφάνιση του παίκτη (ή των παιχτών) με τα περισσότερα γκολ
        match.printBestOffencePlayer();

        // Εμφάνιση του παίκτη (ή των παιχτών) που νικήθηκε/αν πιο πολλές φορές στην άμυνα
        match.printWorstDefencePlayer();
    }
}
