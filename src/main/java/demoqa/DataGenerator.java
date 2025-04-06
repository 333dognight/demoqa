package demoqa;

import java.time.Year;
import java.util.Random;

public class DataGenerator {

    public String randomPhoneNumber(int length) {
        Random randomPhone = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(randomPhone.nextInt(10)); // Generates a random digit (0-9)
        }

        return sb.toString();
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


