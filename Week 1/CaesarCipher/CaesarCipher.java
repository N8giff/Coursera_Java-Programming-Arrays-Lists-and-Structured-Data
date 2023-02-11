import edu.duke.*;

public class CaesarCipher {
    public String encryptTwoKeys(String input, int key1, int key2){
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        
        //Write down the alphabet
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        
        //Compute the shifted alphabet for key 1
        String shiftedAlphabetUpper1 = alphabetUpper.substring(key1)+
        alphabetUpper.substring(0,key1);
        
        String shiftedAlphabetLower1 = alphabetLower.substring(key1)+
        alphabetLower.substring(0,key1);
        
        //Compute the shifted alphabet for key 2
        String shiftedAlphabetUpper2 = alphabetUpper.substring(key2)+
        alphabetUpper.substring(0,key2);
        
        String shiftedAlphabetLower2 = alphabetLower.substring(key2)+
        alphabetLower.substring(0,key2);
        
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);

            //if it's lower case, use lower case alphabet
            if(Character.isLowerCase(currChar)){
                //index currChar in alphabet
                int idx = alphabetLower.indexOf(currChar,0);
                
                if(idx != -1 && i % 2 == 0){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetLower1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }
                    
                //If currChar is in alphabet and even position
                 if(idx != -1 && i % 2 != 0){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetLower2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }  
            }
            
            //if it's upper case, use upper case alphabet
            if(Character.isUpperCase(currChar)){
                //Find the index of currChar in the alphabet (call it idx)
                int idx = alphabetUpper.indexOf(currChar,0);

                  //If currChar is in alphabet and odd 
                 if(idx != -1 && i % 2 == 0){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetUpper1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }
                    
                //If currChar is in alphabet and even 
                 if(idx != -1 && i % 2 != 0){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetUpper2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }
            }
        }
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys() {
        System.out.println("//      //      //      //      //  ");
        
        int key1 = 14;
        int key2 = 24;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println(encrypted);
        
        String decrypted = encryptTwoKeys(encrypted, 26-key1, 26-key2);
        System.out.println(decrypted);
    }
    
    
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        
        //Write down the alphabet
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        
        //Compute the shifted alphabet
        String shiftedAlphabetUpper = alphabetUpper.substring(key)+
        alphabetUpper.substring(0,key);
        String shiftedAlphabetLower = alphabetLower.substring(key)+
        alphabetLower.substring(0,key);
        
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            
            //create index 
            int idx = 0;
            
            //if it's lower case, use lower case alphabet
            if(Character.isLowerCase(currChar)){
                //index currChar in alphabet
                idx = alphabetLower.indexOf(currChar);
                
                //If currChar is in alphabet
                 if(idx != -1){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetLower.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }
            }
            
            //if it's upper case, use upper case alphabet
            if(Character.isUpperCase(currChar)){
                //Find the index of currChar in the alphabet (call it idx)
                idx = alphabetUpper.indexOf(currChar);
                //If currChar is in the alphabet
                  if(idx != -1){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetUpper.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                    }
                //Otherwise: do nothing
            }
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void testEncrypt() {
        System.out.println("//      //      //      //      //  ");
        
        int key = 15;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    public void testCaesarMethod() {
        System.out.println("//      //      //      //      //  ");
        
        int key = 23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        System.out.println("The key is: " + key);
        String encrypted = encrypt(message, key);
        System.out.println("Encrypted message: " + encrypted);
        
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println("Decrypted message: " + decrypted);
    }
    
}

