package demoqa;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.time.Year;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    Faker faker = new Faker();

    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public String randomFirstName() {
       return faker.name().firstName();
    }

    public String randomLastName() {
        return faker.name().lastName();
    }

    public String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static Long randomNumber(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String randomPhone(String prefix, Long min, Long max) {
        return prefix + randomNumber(min, max);
    }

    public static int randomInt(int min, int max) {
        Random randomInt = new Random();
        return randomInt.nextInt((max - min) + 1) + min;
    }

    public static String randomEmail(int len) {
        return randomString(10) + "@gmail.com";
    }

    public static String randomSubjectItem(String[] values) {
        int index = randomInt(0, values.length);
        return values[index];
    }

    public String RandomDate() {
        Random randomDate = new Random();
        int currentYear = Year.now().getValue();
        int minAgeForLoan = currentYear - 20;
        int maxAgeForLoan = currentYear - 65;
        int year = randomDate.nextInt(minAgeForLoan - maxAgeForLoan + 1) + maxAgeForLoan; // Random year
        int month = randomDate.nextInt(12) + 1; // Random month between 1 and 12
        int day = switch (month) {
            case 2 -> // February
                    randomDate.nextInt(isLeapYear(year) ? 29 : 28) + 1;
            case 4, 6, 9, 11 -> // Months with 30 days
                    randomDate.nextInt(30) + 1;
            default -> // Months with 31 days
                    randomDate.nextInt(31) + 1;
        };

        // Determine the maximum days in the given month

        // Format the date
        return String.format("%02d-%02d-%d", day, month, year);

    }

    private static boolean isLeapYear(int year) {

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
