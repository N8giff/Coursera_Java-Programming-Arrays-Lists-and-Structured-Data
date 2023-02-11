
/**
 * Write a description of testCaesarCipher2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class testCaesarCipher2 {

        private int [] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for(int k = 0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alph.indexOf(ch);
            
            if (index != -1){
                counts[index] += 1;
            }
        }
        return counts;
    }
    
    private int maxIndex(int[] values){
        int index = 0;
        int max = 0;
        
        for(int i = 0; i < values.length; i++){
            if(values[i] > max){
                max = values[i];
                index = i;
            }
        }
        return index;
    }
    
    private String halfOfString(String message, int start){
        String answer = "";
        for(int i = start; i < message.length(); i += 2){
            answer = answer + message.charAt(i);
        }
        return answer;
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        ooCaesar2 cc = new ooCaesar2(0,0);
        
        System.out.println("//      //      //      //      //      //");
        
        String encrypted = cc.encryptTwoKeys(message);
        System.out.println("Encrypted message: \n" + encrypted);
        
        String decryptedAuto = breakCaesarCipher(encrypted);
        System.out.println("The auto decrypted message: \n" + decryptedAuto);
        
        String decrypted = cc.decryptTwoKeys(encrypted);
        System.out.println("Decrypted message: \n" + decrypted);
    }
    
    public String breakCaesarCipher(String s){
        String s1 = halfOfString(s,0);
        String s2 = halfOfString(s,1);
        
        int[] freqs1 = countLetters(s1);
        int maxIndex1 = maxIndex(freqs1);
        
        int[] freqs2 = countLetters(s2);
        int maxIndex2 = maxIndex(freqs2);
        
        int dKey1 = maxIndex1 - 4;
        int dKey2 = maxIndex2 - 4;
        
        if(maxIndex1 <4){
            dKey1 = 26 - (4 - maxIndex1);
        }
        
        if(maxIndex2 <4){
            dKey2 = 26 - (4 - maxIndex2);
        }
        
        ooCaesar2 cc = new ooCaesar2(26 - dKey1, 26 - dKey2);
        
        String answer = cc.encryptTwoKeys(s);
        
        System.out.println("Key 1: " + dKey1 + "  " + "Key 2: " + dKey2);
        return answer;
    }
    
    
}
