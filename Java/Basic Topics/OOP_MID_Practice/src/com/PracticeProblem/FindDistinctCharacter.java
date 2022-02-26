package com.PracticeProblem;

import java.util.*;

public class FindDistinctCharacter {
    public static void main(String[] args) {

        String data = "HELLO WORLD";
        Vector<Character> charVect = new Vector<>();
        Set<Character> uniqChar = new LinkedHashSet<>();
        Map<Character, Integer> wordFreq = new LinkedHashMap<>();

        for(int i=0; i<data.length(); i++){
            if(data.charAt(i) != ' ') uniqChar.add(data.charAt(i));
            charVect.add(data.charAt(i));
        }

        System.out.println("Total unique Character: " + uniqChar.size());
        Iterator<Character> it = uniqChar.iterator();
        while(it.hasNext()){
            char ch = it.next();
            int freq = Collections.frequency(charVect, ch);
            wordFreq.put(ch, freq);
            System.out.print(ch + " ");
        }

        System.out.println("\nWORD FREQUENCY: ");
        Set<Character> keys = wordFreq.keySet();
        for(Character ch: keys){
            System.out.println(ch + " -- " + wordFreq.get(ch));
        }

    }
}
