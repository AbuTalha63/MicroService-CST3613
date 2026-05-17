package edu.citytech.counter.services;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
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
    //Constructor; as its name is the same as the class name

    
    public ABCService() {
        System.out.println("I am alive: " + new Date());
        map.put("upper-vowels",this::getVowelsUpper);
        map.put("upper-all",this::getABC);
        map.put("upper-consonants",this::getConsonantsUpper);

        map.put("lower-vowels",this::getVowelsLower);
        map.put("lower-all",this::getabc);
        map.put("lower-consonants",this::getConsonantsLower);
    }

    public Object getData(String key) { 
        
        List<String> data = map.get(key).get();

        Map<String, Object> mapResult = new HashMap<>();
        
        mapResult.put("Developer", "Usman, Muhammad");
        mapResult.put("size", data.size());
        mapResult.put("data", data);

        return mapResult;
    }

    private static final String ABC = "abcdefghijklmnopqrstuvwxyz";

    private static final String[] alphabet = ABC.split("");
    private static final String[] _alphabet = ABC.toUpperCase().split("");

    //Full alphabet
    public List<String> getABC() {
        return Arrays.asList(_alphabet);
    }
    public List<String> getabc() {
        return Arrays.asList(alphabet);
    }
    //Vowels
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
    //Consonants
    public List<String> getConsonantsUpper() {

        var letters = Arrays.asList(_alphabet);
        var vowels = new ArrayList<String>();
        for (String letter : letters) {
            if (!isVowel(letter))
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
}