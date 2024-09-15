package com.webapp;

import java.util.HashMap;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
                String a = "danger";
                String b = "andergg";
                System.out.println(isAnagram(a,b));
    }

    public static boolean isAnagram(String a, String b){
        if (a.length() != b.length()) return false;

        HashMap<Character, Integer > counter = new HashMap<>();

        for(int i=0; i<a.length(); i++){
            counter.put(a.charAt(i), counter.getOrDefault(a.charAt(i), 0) + 1 );
        }

        for(int i=0; i<b.length(); i++){
            char charB= b.charAt(i);
            if(!counter.containsKey(charB)){
                return false;
            }
            counter.put(charB, counter.get(charB) - 1);
            if(counter.get(charB) == 0){
                counter.remove(charB);
            }
        }
        return counter.isEmpty();
    }
}