
/**
 * Write a description of testCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class testCaesarCipher {

    public int [] countLetters(String message){
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
    
    public int maxIndex(int[] values){
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
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        ooCaesar cc = new ooCaesar(15);
        
        String encrypted = cc.encrypt(message);
        System.out.println("Encrypted message: " + encrypted);
        
        String decryptedAuto = breakCaesarCipher(encrypted);
        System.out.println("The auto decrypted message: " + decryptedAuto);
        
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted message: " + decrypted);
    }
    
    public String breakCaesarCipher(String s){
        int[] freqs = countLetters(s);
        int maxIndex = maxIndex(freqs);
        int dKey = maxIndex - 4;
        if(maxIndex <4){
            dKey = 26 - (4 - maxIndex);
        }
        
        ooCaesar cc = new ooCaesar(26 - dKey);
        
        String answer = cc.encrypt(s);
        
        return answer;
    }
    
    
}
