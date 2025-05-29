package demoqa.builders;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    public static Faker fakerRU = new Faker(new Locale("ru", "RU"));
    public static Faker fakerEN = new Faker(new Locale("en", "US"));
}


