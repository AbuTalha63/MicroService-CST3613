package edu.citytech.counter.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import jakarta.inject.Singleton;



@Singleton
public class ABCService {

    Map<String, Supplier <List<String>>> map = new HashMap<>();

    //way u know its a constructor: same name as class
    public ABCService() {
        System.out.println("I am alive: " + new Date());
        map.put("upper-vowels",this::getVowelsUpper);
        map.put("upper-all",this::getVowelsUpper);
        map.put("upper-consonants",this::getVowelsUpper);
        map.put("lower-vowels",this::getVowelsUpper);
        map.put("lower-all",this::getVowelsUpper);
        map.put("lower-consonants",this::getVowelsUpper);
    }

    public List<String> getData(String key) { 
        List<String> data = map.get(key).get();
        return data;
    }

    private static final String ABC = "abcdefghijklmnopqrstuvwxyz";

    private static final String[] alphabet = ABC.split("");
    private static final String[] _alphabet = ABC.toUpperCase().split("");


    public List<String> getabc() {
        return Arrays.asList(alphabet);
    }

    public List<String> getABC() {
        return Arrays.asList(_alphabet);
    }

    public boolean isVowel(String letter){
        return "AEIOUaeiou".indexOf(letter) >= 0; //if you don't put >=, "A" will not show up, as it is in the index 0
    }
    public List<String> getVowelsUpper() {

        var letters = Arrays.asList(_alphabet);
        var vowels = new ArrayList<String>();
        for (String letter : letters) {
            if (isVowel(letter))
                vowels.add(letter);
            }
        return vowels;
    }
        public List<String> getVowelsLower() {

        var letters = Arrays.asList(alphabet);
        var vowels = new ArrayList<String>();
        for (String letter : letters) {
            if (isVowel(letter))
                vowels.add(letter);
            }
        return vowels;
    }
            public List<String> getConsonantsLower() {

        var letters = Arrays.asList(alphabet);
        var vowels = new ArrayList<String>();
        for (String letter : letters) {
            if (!isVowel(letter))
                vowels.add(letter);
            }
        return vowels;
    }
            public List<String> getConsonantsUpper() {

        var letters = Arrays.asList(_alphabet);
        var vowels = new ArrayList<String>();
        for (String letter : letters) {
            if (!isVowel(letter))
                vowels.add(letter);
            }
        return vowels;
    }
}