package demoqa.builders;

import net.datafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    public static Faker fakerRU = new Faker(new Locale("ru", "RU"));
    public static Faker fakerEN = new Faker(new Locale("en", "US"));
}


