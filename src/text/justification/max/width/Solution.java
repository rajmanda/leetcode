package text.justification.max.width;

import java.util.*;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> lines = new ArrayList<>() ;
        ArrayList<String> actualWordsArray = new ArrayList<>() ;

        for (String word : words) {
            word = word.trim();

            // If there are spaces in the world, correct them to be just one space wide  -  "understand      well" -> should be changed to "understand well"
            if (word.contains(" ")) {
                String[] wordsInWord = word.split("\\s+");
                for (int i = 0; i < wordsInWord.length; i++) {
                    actualWordsArray.add(wordsInWord[i].trim());
                }
            } else {
                actualWordsArray.add(word);
            }
        }
        String[] actualWords = actualWordsArray.toArray(new String[0]);


        StringBuffer currentLine = new StringBuffer();
        for(String word: actualWords) {

            if (currentLine.length() + 1 + word.length() > maxWidth) {
                System.out.println(currentLine.toString().trim());
                lines.add(adjustSpaces(currentLine.toString().trim(), maxWidth, false));
                currentLine.setLength(0);
            }
            if (currentLine.length() > 0) {
                currentLine.append(" ");
            }
            currentLine.append(word);
        }

        // For the last Line
        if(currentLine.length() > 0 ) {
            System.out.println(currentLine.toString().trim());
            lines.add(adjustSpaces(currentLine.toString().trim(), maxWidth, true)) ;
        }

        return lines;
    }
    private static String adjustSpaces(String line, int maxWidth, boolean lastLine) {
        //Add space starting from the first space untill the maxWidth .
        StringBuffer nline = new StringBuffer(line) ;
        int currentLength = nline.length();

        // Check if the line contains only one word (no spaces)
        if (!line.contains(" ")) {
            // Pad spaces to the end to reach maxWidth
            String spaceFiller = new String(" ").repeat(maxWidth-currentLength) ;
            return nline.append(spaceFiller).toString();
        }
        if(lastLine) {
            String spaceFiller = new String(" ").repeat(maxWidth-currentLength) ;
            return nline.append(spaceFiller).toString();
        }
        while (currentLength <  maxWidth){
            for (int i = 0 ; i < nline.length() - 1 && currentLength < maxWidth; i ++) {
                if (nline.charAt(i) == ' ' && nline.charAt(i + 1) != ' ') {
                    nline.insert(i, ' ') ;
                    i++ ;  //skipe the next character to avoid adding multiple spaces at the same place
                    currentLength++ ;
                }
            }
        }
        //System.out.println(nline.toString());
        return nline.toString() ;
    }

    public static void main(String[] args) {
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        //int maxWidth = 16;
        String[] words = {"Science  is  what we","understand      well","enough   to  explain","to  a  computer. Art","is  everything  else","we do               "};
        int maxWidth = 20;
        Solution sol =  new Solution() ;

        List<String> justifiedText = sol.fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println( line );
        }
    }
}
