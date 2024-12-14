import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {

        int lengthOfLongestSubstring(String s) {
            int res = 0; // Result to store the max length of substring
            int left = 0; // Left pointer of the sliding window
            HashSet<Character> charset = new HashSet<>();

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);

                // If the character is already in the set, shrink the window
                while (charset.contains(currentChar)) {
                    System.out.println("Removing " + s.charAt(left) + " from set to resolve conflict with " + currentChar);
                    charset.remove(s.charAt(left)) ;
                    left++ ;
                }

                // Add the current character to the set
                System.out.println("Adding " + currentChar + " to the set");
                charset.add(currentChar) ;

                // Update the maximum length of substring
                Math.max(res, right -left + 1) ;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters outerInstance = new LongestSubstringWithoutRepeatingCharacters();
        // Create an instance of the inner class
        Solution solution = outerInstance.new Solution();
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring("bacabcbb"));
    }
}
