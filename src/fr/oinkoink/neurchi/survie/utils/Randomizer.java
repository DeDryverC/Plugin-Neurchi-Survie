package fr.oinkoink.neurchi.survie.utils;

import java.util.Random;

public class Randomizer {

    private static Random random = new Random();

    public static boolean getPercentage(double percentage) { return (percentage / 100.0D >= random.nextDouble()); }

    public static int getRandomInt(int max) { return random.nextInt(max) + 1; }

    public static float getRandomFloat(float max) { return (float)random.nextDouble() * max; }

    public static float getRandomFloat(float min, float max) { return min + (float)random.nextDouble() * (max - min); }
}
