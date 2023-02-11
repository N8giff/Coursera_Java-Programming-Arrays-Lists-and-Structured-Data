
/**
 * Write a description of ooCaesar2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ooCaesar2 {
    private String alphabetUpper; //fields (instance variables)
    private String alphabetLower;
    private String shiftedAlphabetUpper1;
    private String shiftedAlphabetLower1;
    private String shiftedAlphabetUpper2;
    private String shiftedAlphabetLower2;
    
    private int mainKey1;
    private int mainKey2;
    
    public ooCaesar2(int key1, int key2){
        alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLower = "abcdefghijklmnopqrstuvwxyz";
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
        
        mainKey1 = key1;
        mainKey2 = key2;
    }
        
    public String encryptTwoKeys(String input){
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        
        ooCaesar oocc1 = new ooCaesar(mainKey1);
        ooCaesar oocc2 = new ooCaesar(mainKey2);
       
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            
            if (i % 2 == 0 || i == 0) {
                encrypted.replace(i,i+1,oocc1.encrypt(input.substring(i,i+1)));
            }
            else {
                encrypted.replace(i,i+1,oocc2.encrypt(input.substring(i,i+1)));
            }
        }
        return encrypted.toString();
    }
    
        public String decryptTwoKeys(String input){
        ooCaesar2 cc = new ooCaesar2(26-mainKey1, 26-mainKey2);
        String answer = cc.encryptTwoKeys(input);
        return answer;
    }
    
}


/* OLD CODE
 * //Look at the ith character of encrypted (call it currChar)
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
 */