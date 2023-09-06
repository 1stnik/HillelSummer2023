package com.hillel.lesson_30.ex;

public class Main {
    public static void main(String[] args) {
        String[] phoneNumbers = {
                "37061234567",
                "+37061234567",
                "+370(6)1234567",
                "+370(6)1234567",
                "+370 612 34 567",
                "+370-612-34-567"
        };

        for (String phoneNumber : phoneNumbers) {
            String normalizedNumber = normalizePhoneNumber(phoneNumber);
            System.out.println("Original: " + phoneNumber + " | Normalized: " + normalizedNumber);
        }
    }

    public static String normalizePhoneNumber(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");

        // Assuming you want to normalize to +37061234567 format
        if (digitsOnly.length() == 11 && digitsOnly.startsWith("370")) {
            return "" + digitsOnly;
        }

        // You can add more cases to handle different formats as needed
        // For example, handling different country codes or delimiters

        return phoneNumber; // Return the original number if it doesn't match any expected format
    }
}
