package edu.gatech.cs2340.spacetrader.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class that represents the universe of the game
 */
public class Universe implements Serializable {

    public static final int COORDINATE_MAX_BOUND = 2001;
    public static final int RESOURCE_MAX_NUM = 13;
    private SolarSystem[] solarSystems;

    /**
     * Constructor for the class
     */
    public Universe() {
        this.solarSystems = new SolarSystem[10];

        String[] SolarSystemName =
                {
                        "Acamar",
                        "Adahn",        // The alternate personality for The Nameless One in "Planescape: Torment"
                        "Aldea",
                        "Andevian",
                        "Antedi",
                        "Balosnee",
                        "Baratas",
                        "Brax",            // One of the heroes in Master of Magic
                        "Bretel",        // This is a Dutch device for keeping your pants up.
                        "Calondia",
                        "Campor",
                        "Capelle",        // The city I lived in while programming this game
                        "Carzon",
                        "Castor",        // A Greek demi-god
                        "Cestus",
                        "Cheron",
                        "Courteney",    // After Courteney Cox…
                        "Daled",
                        "Damast",
                        "Davlos",
                        "Deneb",
                        "Deneva",
                        "Devidia",
                        "Draylon",
                        "Drema",
                        "Endor",
                        "Esmee",        // One of the witches in Pratchett's Discworld
                        "Exo",
                        "Ferris",        // Iron
                        "Festen",        // A great Scandinavian movie
                        "Fourmi",        // An ant, in French
                        "Frolix",        // A solar system in one of Philip K. Dick's novels
                        "Gemulon",
                        "Guinifer",        // One way of writing the name of king Arthur's wife
                        "Hades",        // The underworld
                        "Hamlet",        // From Shakespeare
                        "Helena",        // Of Troy
                        "Hulst",        // A Dutch plant
                        "Iodine",        // An element
                        "Iralius",
                        "Janus",        // A seldom encountered Dutch boy's name
                        "Japori",
                        "Jarada",
                        "Jason",        // A Greek hero
                        "Kaylon",
                        "Khefka",
                        "Kira",            // My dog's name
                        "Klaatu",        // From a classic SF movie
                        "Klaestron",
                        "Korma",        // An Indian sauce
                        "Kravat",        // Interesting spelling of the French word for "tie"
                        "Krios",
                        "Laertes",        // A king in a Greek tragedy
                        "Largo",
                        "Lave",            // The starting system in Elite
                        "Ligon",
                        "Lowry",        // The name of the "hero" in Terry Gilliam's "Brazil"
                        "Magrat",        // The second of the witches in Pratchett's Discworld
                        "Malcoria",
                        "Melina",
                        "Mentar",        // The Psilon home system in Master of Orion
                        "Merik",
                        "Mintaka",
                        "Montor",        // A city in Ultima III and Ultima VII part 2
                        "Mordan",
                        "Myrthe",        // The name of my daughter
                        "Nelvana",
                        "Nix",            // An interesting spelling of a word meaning "nothing" in Dutch
                        "Nyle",            // An interesting spelling of the great river
                        "Odet",
                        "Og",            // The last of the witches in Pratchett's Discworld
                        "Omega",        // The end of it all
                        "Omphalos",        // Greek for navel
                        "Orias",
                        "Othello",        // From Shakespeare
                        "Parade",        // This word means the same in Dutch and in English
                        "Penthara",
                        "Picard",        // The enigmatic captain from ST:TNG
                        "Pollux",        // Brother of Castor
                        "Quator",
                        "Rakhar",
                        "Ran",            // A film by Akira Kurosawa
                        "Regulas",
                        "Relva",
                        "Rhymus",
                        "Rochani",
                        "Rubicum",        // The river Ceasar crossed to get into Rome
                        "Rutia",
                        "Sarpeidon",
                        "Sefalla",
                        "Seltrice",
                        "Sigma",
                        "Sol",            // That's our own solar system
                        "Somari",
                        "Stakoron",
                        "Styris",
                        "Talani",
                        "Tamus",
                        "Tantalos",        // A king from a Greek tragedy
                        "Tanuga",
                        "Tarchannen",
                        "Terosa",
                        "Thera",        // A seldom encountered Dutch girl's name
                        "Titan",        // The largest moon of Jupiter
                        "Torin",        // A hero from Master of Magic
                        "Triacus",
                        "Turkana",
                        "Tyrus",
                        "Umberlee",        // A god from AD&D, which has a prominent role in Baldur's Gate
                        "Utopia",        // The ultimate goal
                        "Vadera",
                        "Vagra",
                        "Vandor",
                        "Ventax",
                        "Xenon",
                        "Xerxes",        // A Greek hero
                        "Yew",            // A city which is in almost all of the Ultima games
                        "Yojimbo",        // A film by Akira Kurosawa
                        "Zalkon",
                        "Zuul"            // From the first Ghostbusters movie
                };

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 10) {

            int random = randomGenerator.nextInt(SolarSystemName.length);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        int[] x = new int[10];

        for (int i = 0; i < 10; i++) {
            x[i] = randomGenerator.nextInt(COORDINATE_MAX_BOUND) - 1000;
        }

        int[] y = new int[10];

        for (int i = 0; i < 10; i++) {
            y[i] = randomGenerator.nextInt(COORDINATE_MAX_BOUND) - 1000;
        }

        //Todo: deal with the case where planets overlap

        int[] tech = new int[10];

        for (int i = 0; i < 10; i++) {
            tech[i] = randomGenerator.nextInt(8);
        }

        int[] resource = new int[10];

        for (int i = 0; i < 10; i++) {
            resource[i] = randomGenerator.nextInt(RESOURCE_MAX_NUM);
        }

        for (int i = 0; i < 10; i++) {
            solarSystems[i] = new SolarSystem(SolarSystemName[numbers.get(i)], x[i], y[i], tech[i], resource[i]);
        }

    }

    /**
     * Gets the number of solar systems in the universe
     * @return the number of solar systems
     */
    public int getNumSolarSystems() {
        return solarSystems.length;
    }

    /**
     * Gets the given solar system by index
     * @param pos the index we are searching for
     * @return the solar system found
     */
    public SolarSystem getSolarSystem(int pos) {
        return solarSystems[pos];
    }

}
