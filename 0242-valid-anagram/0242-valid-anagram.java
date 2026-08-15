class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
//anagram is like same frequencies of elements in  both strings so if one is incrementing then the same in next will decrement it soi if any value is left which is not 0 it implies it is not a anagram and in one of the strings diff value is there 