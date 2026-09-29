import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        // Stores character and its last seen index
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already in the window, move left pointer past its last seen position
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update or add the current character's latest index
            map.put(currentChar, right);

            // Calculate the max length of valid window seen so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}