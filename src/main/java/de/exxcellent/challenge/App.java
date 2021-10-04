package de.exxcellent.challenge;

import de.exxcellent.challenge.Analyzer.SmallestValueFinder;
import de.exxcellent.challenge.Exceptions.ColumnNotFoundException;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws ColumnNotFoundException, IOException {

        // Your preparation code …


        SmallestValueFinder smallestValueByWeather = SmallestValueFinder.createSmallestValueFinder("weather.csv");
        int day = smallestValueByWeather.findRow("Day");
        int mxt = smallestValueByWeather.findRow("MxT");
        int mnt = smallestValueByWeather.findRow("MnT");
        String dayWithSmallestTempSpread = smallestValueByWeather.findSmallestValue(day, mxt, mnt);     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        SmallestValueFinder smallestValueByFootball = SmallestValueFinder.createSmallestValueFinder("football.csv");
        int team = smallestValueByFootball.findRow("Team");
        int goals = smallestValueByFootball.findRow("Goals");
        int goalsAllowed = smallestValueByFootball.findRow("Goals Allowed");


        String teamWithSmallestGoalSpread = smallestValueByFootball.findSmallestValue(team,goals,goalsAllowed); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
