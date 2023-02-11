
/**
 * Object oriented Caesar Cipher
 * 
 * @Nate Giffard 12/10/22
 *
 * @version (a version number or a date)
 */
public class ooCaesar {
    private String alphabetUpper; //fields (instance variables)
    private String alphabetLower;
    private String shiftedAlphabetUpper;
    private String shiftedAlphabetLower;
    private int mainKey;
    
    public ooCaesar(int key){
        alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabetUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0,key);
        shiftedAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0,key);
        mainKey = key;
    }
        
    public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);

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
    
    public String decrypt(String input){
        ooCaesar cc = new ooCaesar(26-mainKey);
        String answer = cc.encrypt(input);
        return answer;
    }
    
    
}
    
    

