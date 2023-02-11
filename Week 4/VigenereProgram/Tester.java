
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Tester {

    public void testCaesar(){
        int key = 2;
        char testLetter = 'a';
        FileResource fr = new FileResource();
        String testMessage = fr.asString();
        
        CaesarCipher cc = new CaesarCipher(key);
        
        char encryptLetter = cc.encryptLetter(testLetter);
        char decryptLetter = cc.decryptLetter(encryptLetter);
        
        String encryptMessage = cc.encrypt(testMessage);
        String decryptMessage = cc.decrypt(encryptMessage);
        
        System.out.println("Test letter: " + testLetter);
        System.out.println("Encrypted Letter: " + encryptLetter);
        System.out.println("Decrypted Letter: " + decryptLetter);
        
        System.out.println("\n");
        
        System.out.println("Test message: " + testMessage);
        System.out.println("Encrypted message: " + encryptMessage);
        System.out.println("Decrypted message: " + decryptMessage);
        
        System.out.println("\n");
        System.out.println("FINISHED");
    }
    
    public void testCaesarCracker(){
        FileResource fr = new FileResource();
        String testMessage = fr.asString();
        
        CaesarCracker ccr = new CaesarCracker();
        
        int key = ccr.getKey(testMessage);
        String decryptMessage = ccr.decrypt(testMessage);
        
        System.out.println("Decryption Key: " + key);
        
        System.out.println("\n");

        System.out.println("Decrypted message: " + decryptMessage);
        
        System.out.println("\n");
        System.out.println("FINISHED");
    }
    
    public void testVigenereCipher(){
        FileResource fr = new FileResource();
        String testMessage = fr.asString();
        
        int [] array = new int[]{17,14,12,4};
        
        VigenereCipher vc = new VigenereCipher(array);
        
        String encryptMessage = vc.encrypt(testMessage);
        String decryptMessage = vc.decrypt(encryptMessage);
        
        System.out.println("Encrypted Message: " + encryptMessage);
        
        System.out.println("\n");

        System.out.println("Decrypted message: " + decryptMessage);
        
        System.out.println("\n");
        System.out.println("FINISHED");
    
    }
    
    public void testVigenereBreaker(){
        
        VigenereBreaker vb = new VigenereBreaker();
        
        String answer1 = vb.sliceString("abcdefghijklm", 0, 3); //should return "adgjm"
        
        String answer2 = vb.sliceString("abcdefghijklm", 1, 3); //should return "behk"

        String answer3 = vb.sliceString("abcdefghijklm", 2, 3); // should return "cfil"

        String answer4 = vb.sliceString("abcdefghijklm", 0, 4); // should return "aeim"

        String answer5 = vb.sliceString("abcdefghijklm", 1, 4); // should return "bfj"

        String answer6 = vb.sliceString("abcdefghijklm", 2, 4); // should return "cgk"

        String answer7 = vb.sliceString("abcdefghijklm", 3, 4); // should return "dhl"

        String answer8 = vb.sliceString("abcdefghijklm", 0, 5); // should return "afk"

        String answer9 = vb.sliceString("abcdefghijklm", 1, 5); // should return "bgl"

        String answer10 = vb.sliceString("abcdefghijklm", 2, 5); // should return "chm"

        String answer11 = vb.sliceString("abcdefghijklm", 3, 5); // should return "di"

        String answer12 = vb.sliceString("abcdefghijklm", 4, 5); // should return "ej"
        
        System.out.println("//      //      //      //      //");
        
        System.out.println("Test 1 should return 'adgjm' and returns: " + answer1);
        System.out.println("Test 2 should return 'behk' and returns: " + answer2);
        System.out.println("Test 3 should return 'cfil' and returns: " + answer3);
        System.out.println("Test 4 should return 'aeim' and returns: " + answer4);
        System.out.println("Test 5 should return 'bfj' and returns: " + answer5);
        System.out.println("Test 6 should return 'cgk' and returns: " + answer6);
        System.out.println("Test 7 should return 'dhl' and returns: " + answer7);
        System.out.println("Test 8 should return 'afk' and returns: " + answer8);
        System.out.println("Test 9 should return 'bgl' and returns: " + answer9);
        System.out.println("Test 10 should return 'chm' and returns: " + answer10);
        System.out.println("Test 11 should return 'di' and returns: " + answer11);
        System.out.println("Test 12 should return 'ej' and returns: " + answer12);
        
        System.out.println("FINISHED");
    }
}
