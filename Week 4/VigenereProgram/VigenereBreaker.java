import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = whichSlice; i < message.length(); i+=totalSlices){
            char currChar = message.charAt(i);
            answer.append(currChar);
        }
        return answer.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        
        for(int i = 0; i < klength; i++){
            String currSlice = sliceString(encrypted,i, klength);
            key[i] = cc.getKey(currSlice);
        }
        return key;
    }

    public void breakVigenere(){
       HashMap<String,HashSet<String>> dictionaries = new HashMap<String,HashSet<String>>();
       File folder = new File("dictionaries/");
       File[] fileList = folder.listFiles();
       for (int index=0;index<fileList.length;index++) {
           if (fileList[index].isFile()) {
               FileResource dictionaryFile = new FileResource(fileList[index]);
               HashSet<String> dictionary = readDictionary(dictionaryFile);
               dictionaries.put(fileList[index].getName(),dictionary);
               System.out.println("Reading in "+fileList[index]+" dictionary...");
           }
       }
       FileResource encryptedFile = new FileResource();
       breakForAllLangs(encryptedFile.asString(),dictionaries);
    }
    
    /*public void oldBreak () {
        FileResource fr = new FileResource();
        String encryptedMessage = fr.asString();
        
        FileResource fr2 = new FileResource();
        HashSet<String> dictionary = readDictionary(fr2);
        
        String decrypted = breakForLanguage(encryptedMessage, dictionary);
        
        System.out.println("//      //      //      //      //");
        System.out.println("\n");
        System.out.println(decrypted);
        System.out.println("//FINSIHED//");
        
    }
    
    public void oldOldBreak(){
        FileResource fr = new FileResource();
        String encryptedMessage = fr.asString();
        FileResource fr2 = new FileResource();
        HashSet<String> dictionary = readDictionary(fr2);
        
        int keyLength = 38;
        int[] key = tryKeyLength(encryptedMessage, keyLength, 'e');
        
        System.out.println("//      //      //      //      //      //");
        
        VigenereCipher vc = new VigenereCipher(key);
        
        String answer = vc.decrypt(encryptedMessage);
        int count = countWords(answer, dictionary);
        System.out.println("Valid words in message: " + count);
        System.out.println(answer);
    }
    */
   
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<String>();
        for(String line : fr.lines()){
            line = line.toLowerCase();
            dictionary.add(line);
        }
        return dictionary;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        message = message.toLowerCase();
       
        String[] allWords = message.split("\\W+");
        int count = 0;
        
        for(String word : allWords){
            if(dictionary.contains(word)){
                count = count + 1;
            }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        
        int[] bestKey = {};
        int keyLength = 0;
        int max = 0;
        String bestDecryption = "";
        
        for(int i = 1; i < 100; i++){
            char mostCommonChar = mostCommonCharIn(dictionary);
            int[] key  = tryKeyLength(encrypted, i, mostCommonChar);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            
            int count = countWords(decrypted, dictionary);
            
            if(count > max){
                bestKey = key;
                keyLength = i;
                max = count;
                bestDecryption = decrypted;
            }
        }
        System.out.println("Decryption key: " + bestKey);
        System.out.println("Key length: " + keyLength);
        System.out.println("Word count: " + max);
        return bestDecryption;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character,Integer> characterCounter = new HashMap<Character,Integer>();
        for (String word : dictionary) {
            char[] letters = word.toCharArray();
            for (int index=0;index<letters.length;index++) {
                if (!characterCounter.containsKey(letters[index])) {
                    characterCounter.put(letters[index],1);
                }
                else {
                    characterCounter.replace(letters[index],characterCounter.get(letters[index])+1);
                }
            }
        }
        int highestCount = 0;
        char mostUsedChar = '\0';
        for (Character character : characterCounter.keySet()) {
            if (characterCounter.get(character) > highestCount) {
                highestCount = characterCounter.get(character);
                mostUsedChar = character;
            }
        }
        return mostUsedChar;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
        int currMax = 0;
        String decryptedMessage = "";
        String langUsed = "";
        
        for(String currLang : languages.keySet()){
            String message = breakForLanguage(encrypted, languages.get(currLang));
            int currWordCount = countWords(message,languages.get(currLang));
            
            if(currWordCount > currMax){
                decryptedMessage = message;
                currMax = currWordCount;
                langUsed = currLang;
            }
        }
        
        System.out.println("//      //      //      //      //");
        System.out.println(decryptedMessage);
        System.out.println("Language used: " + langUsed);
        System.out.println("Word count: " + currMax);
        
    }
}
