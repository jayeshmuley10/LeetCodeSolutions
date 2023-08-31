import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        
        StringBuilder wordBuilder = new StringBuilder();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (c != separator) {
                    wordBuilder.append(c);
                } else {
                    if (wordBuilder.length() > 0) {
                        result.add(wordBuilder.toString());
                        wordBuilder.setLength(0);
                    }
                }
            }
            
            // Check if there is any remaining word in the wordBuilder
            if (wordBuilder.length() > 0) {
                result.add(wordBuilder.toString());
                wordBuilder.setLength(0);
            }
        }
        
        return result;
    }
}
