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



}


