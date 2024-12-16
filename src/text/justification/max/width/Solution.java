package text.justification.max.width;

import java.util.ArrayList;
import java.util.List ;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>() ;
        for (int i=0; i<words.length; i++){
            int width = 0 ;
            int spaces = 0 ;
            StringBuffer line = new StringBuffer(words[i] + " ");
            while (line.length() <= maxWidth) {
                res.add(line.toString());
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."} ;
        int maxWidth = 16 ;
        Solution sol = new Solution();
        sol.fullJustify(words, maxWidth) ;

    }
}
