import java.io.*;
import java.util.*;

public class AnagramFinder {
    public static void main(String[] args) {
        String filePath = "wordsfile.txt"; 
        Map<String, List<String>> anagramMap = new HashMap<>();

        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                String sortedWord = sortWord(word);
                anagramMap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        for (List<String> anagramGroup : anagramMap.values()) {
            if (anagramGroup.size() > 1) {
                System.out.println(anagramGroup);
            }
        }
    }

    private static String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
