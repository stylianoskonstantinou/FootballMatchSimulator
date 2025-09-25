// Η κλάση Player αναπαριστά έναν ποδοσφαιριστή με βασικά χαρακτηριστικά και στατιστικά
public class Player {

    // Νούμερο φανέλας (π.χ. 7, 10 κλπ)
    int number;

    // Ονοματεπώνυμο παίκτη
    String name;

    // Ηλικία παίκτη
    int age;

    // Θέση στο γήπεδο (GK = Τερματοφύλακας, DEF = Αμυντικός, ATT = Επιθετικός)
    String position;

    // Ικανότητα παίκτη (αριθμός από 1 έως 100)
    int skill;

    // Πόσα γκολ έχει πετύχει ο παίκτης (μόνο για επιθετικούς)
    int goalsScored = 0;

    // Πόσες φορές έχει νικηθεί από επιθετικό (μόνο για αμυντικούς)
    int timesDefeated = 0;

    // Κατασκευαστής της κλάσης – αρχικοποιεί όλα τα βασικά χαρακτηριστικά του παίκτη
    public Player(int number, String name, int age, String position, int skill) {
        this.number = number;         // Νούμερο φανέλας
        this.name = name;             // Όνομα
        this.age = age;               // Ηλικία
        this.position = position;     // Θέση
        this.skill = skill;           // Ικανότητα
    }

    // Η μέθοδος που καθορίζει πώς θα εμφανίζεται ο παίκτης όταν τον τυπώνουμε με System.out.println()
    @Override
    public String toString() {
        return "#" + number + " " + name + " (" + position + ", Skill: " + skill + ")";
    }
}

