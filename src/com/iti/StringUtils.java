package com.iti;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class StringUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean isBetter(String s1, String s2){
        /* Function that takes two strings and compare between them in length and return a boolean of which is bigger */
        return s1.length() > s2.length();
    }

    public static String betterString(String s1, String s2, BiPredicate<String, String> c){
        /* Function that calls a BiPredicate and passes two strings to compare between them */
        if(c.test(s1, s2)){
            return s1;
        } else {
            return s2;
        }
    }

    public static boolean allLetters(char i){
        /* Function that takes a single character and check if its a letter and return a boolean */
        return Character.isLetter(i);
    }

    public static boolean characterCheck(String word, Predicate<Character> c){
        /* Function that calls a Predicate and passes a character */
        for(int i =0; i < word.length(); i++){
            if(!c.test(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean on = true;
        while(on){
            System.out.println("Please choose one of these options: ");
            System.out.println("""
                    1: Compare between two strings.
                    2: Check if the string contains only letters.
                    3: Exit""");
            switch (scanner.nextLine()) {
                case "1" -> {
                    System.out.println("Please enter the first name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Please enter the second name: ");
                    String secondName = scanner.nextLine();
                    String final_string = betterString(firstName, secondName, StringUtils::isBetter);
                    System.out.println(final_string + " is a better string.\n");
                }
                case "2" -> {
                    System.out.println("Please enter your string: \r");
                    String word = scanner.nextLine();
                    boolean isLettersOnly = characterCheck(word, character -> allLetters(character));
                    System.out.println("The input string is letters only: " + isLettersOnly + "\n");
                }
                case "3" -> on = false;
                default -> System.out.println("Wrong letter.\nPlease try again.\n\n\n\n");
            }
        }
        scanner.close();
    }
}
