import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class FrequencyAnalysis {
    public static void main(String[] args) {
        String filePath = "textfile.txt"; 
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        List<Entry<String, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        
        for (int i = 0; i < Math.min(10, sortedList.size()); i++) {
            Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
