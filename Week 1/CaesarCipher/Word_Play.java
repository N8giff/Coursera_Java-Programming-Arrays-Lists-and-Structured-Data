
/**
 * Emphasize characters in a phrase based on even or odd index
 * Replace vowels in a phrase with a chosen character
 * 
 * @Nate Giffard 12/8/22
 * @version (a version number or a date)
 */

import edu.duke.*;

public class Word_Play {
    public String emphasize(String phrase, Character ch){
    
        //Make a StringBuilder with message (answer)
        StringBuilder answer = new StringBuilder(phrase);
        
        for(int i = 0; i < answer.length(); i++) {
            //Look at the ith character of answer (call it currChar)
            char currChar = answer.charAt(i);
            Character evenChar = '*';
            Character oddChar = '+';
            
            //if the index is even (odd location)
            if(i % 2 == 0 && Character.toLowerCase(currChar) == Character.toLowerCase(ch)){
                answer.setCharAt(i,evenChar);
            }
            
            if(i % 2 != 0 && Character.toLowerCase(currChar) == Character.toLowerCase(ch)){
                answer.setCharAt(i,oddChar);
            }

        }
        return answer.toString();
    }

    public void testEmphasize() {
        System.out.println("//      //      //      //      //  ");
        
        //test 1
        Character ch = 'a';
        String phrase = "dna ctgaaactga";
        String answer = emphasize(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);
        
        //test 2
        ch = 'a';
        phrase = "Mary Bella Abracadabra";
        answer = emphasize(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);;
        
        //test 3
        ch = 'T';
        phrase = "TT TT TT T";
        answer = emphasize(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);
        
        //test 4
        ch = 'O';
        phrase = "oo ooo oo ooo";
        answer = emphasize(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);
    }

    
    public String replaceVowel(String phrase, Character ch){
    
        //Make a StringBuilder with message (encrypted)
        StringBuilder answer = new StringBuilder(phrase);
        
        for(int i = 0; i < answer.length(); i++) {
            //Look at the ith character of answer (call it currChar)
            char currChar = answer.charAt(i);
            
            //if it's a vowel, replace with ch
            if(isVowel(currChar)){
                //index currChar in alphabet
                answer.setCharAt(i, ch);
            }
        }
        return answer.toString();
    }
    
    public void testReplaceVowel() {
        System.out.println("//      //      //      //      //  ");
        
        //test 1
        Character ch = 'o';
        String phrase = "Hello World";
        String answer = replaceVowel(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);
        
        //test 2
        ch = '*';
        phrase = "I LIKE PIZZA when it's COLD OUTSIDE!!";
        answer = replaceVowel(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);;
        
        //test 3
        ch = 'Y';
        phrase = "AAAAAAAA";
        answer = replaceVowel(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);
        
        //test 4
        ch = 'o';
        phrase = "HHHHhhhhhHHHHH";
        answer = replaceVowel(phrase, ch);
        
        System.out.println("The phrase is: " + phrase);
        System.out.println("The character being replaced is: " + ch);
        System.out.println("The test returns: " + answer);
    }
    
    
    public boolean isVowel(Character ch) {
        String vowels = "AEIOUaeiou";
        
        int idx = vowels.indexOf(ch);
        
            if(idx != -1){
                return true;
            } else {
            return false;
            }
    }
    
    public void testIsVowel() {
        System.out.println("//      //      //      //      //  ");
        
        //test 1
        Character ch = 'A';
        boolean answer = isVowel(ch);
        System.out.println("The character is: " + ch);
        System.out.println("Test should return true and returns: " + answer);
        
        //test 2
        ch = 'e';
        answer = isVowel(ch);
        System.out.println("The character is: " + ch);
        System.out.println("Test should return true and returns: " + answer);
        
        //test 3
        ch = 'D';
        answer = isVowel(ch);
        System.out.println("The character is: " + ch);
        System.out.println("Test should return false and returns: " + answer);
        
        //test 4
        ch = 'k';
        answer = isVowel(ch);
        System.out.println("The character is: " + ch);
        System.out.println("Test should return false and returns: " + answer);
    }
}
