import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AnagramSolver {

    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        HashMap<String, ArrayList<String>> completeHashMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = reader.readLine()) != null){
                String sortedWord = sortString(word);
                completeHashMap.putIfAbsent(sortedWord, new ArrayList<>());
                completeHashMap.get(sortedWord).add(word);
            }
        }

        catch (IOException e){
            e.printStackTrace();
        }

        return completeHashMap;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        int Max  = 0;
        ArrayList<String> listOfFrequent = new ArrayList<>();

        for (ArrayList<String> anagramList : anagrams.values()) {
            if (anagramList.size() > Max) {
                Max = anagramList.size();
                listOfFrequent = anagramList;
            }
        }
        return listOfFrequent;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for (String key : anagrams.keySet()) {
            System.out.println(key + ": " + anagrams.get(key));
        }
    }

    private static String sortString(String string){
        char[] charArray = string.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }
}
