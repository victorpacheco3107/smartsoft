/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.victorpacheco.smartsoft;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author victor
 */
public class Riddle {

    private static final String LOWER_CASE_PATTER = "[a-z]+";
    private static final String CHARACTER_TO_REPLACE = "?";
    private static final Character[] ALPHABET = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private final Pattern patternValidate;

    public Riddle() {
        patternValidate = Pattern.compile(LOWER_CASE_PATTER);
    }

    public String solution(String riddle) {
        StringBuilder solution = new StringBuilder();
        if (validateRiddle(riddle)) {
            throw new RuntimeException("The riddle contains characters other than lowercase letters.");
        }
        if(!riddle.contains(CHARACTER_TO_REPLACE)){
            return riddle;
        }
        int lastIndex = 0;
        int nextIndex;
        while(riddle.contains(CHARACTER_TO_REPLACE)){
            nextIndex = riddle.indexOf(CHARACTER_TO_REPLACE);
            solution.append(riddle.substring(lastIndex, nextIndex));
            char previousChar = riddle.charAt(nextIndex - 1);
            char nextChar = riddle.charAt(nextIndex + 1);
            Character newChar = getValidChar(previousChar, nextChar);
            solution.append(newChar);
            riddle = riddle.replaceFirst("\\?", newChar.toString());
            lastIndex = nextIndex;
        }
        solution.append(riddle.substring(lastIndex + 1));
        return solution.toString();
    }

    private boolean validateRiddle(String riddle) {
        Matcher matcher = patternValidate.matcher(riddle);
        return matcher.matches();
    }
    
    private char getValidChar(char previus, char next){
        for(Character currentChar : ALPHABET){
            if(currentChar != previus && currentChar != next){
                return currentChar;
            }
        }
        throw new RuntimeException("No char diferent to " + previus + " and " + next);
    }
    
    private Character getValidChar(char previus){
        for(char currentChar : ALPHABET){
            if(currentChar != previus){
                return currentChar;
            }
        }
        throw new RuntimeException("No char diferent to " + previus);
    }

}
