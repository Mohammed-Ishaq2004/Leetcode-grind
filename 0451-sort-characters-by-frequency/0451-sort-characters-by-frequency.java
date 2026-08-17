class Solution {
    public String frequencySort(String s) {

        // Store each character and how many times it appears
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            // Increase frequency; if ch is new, start from 0
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Get all unique characters from the map
        List<Character> chars = new ArrayList<>(map.keySet());

        // Sort characters by frequency: highest frequency comes first
        chars.sort((a, b) -> map.get(b) - map.get(a));//it means "When sorting these characters, compare their frequencies, and put the higher-frequency character first."

        // Build the final answer
        StringBuilder sb = new StringBuilder();

        for (char ch : chars) {

            // Get how many times this character should be printed
            int count = map.get(ch);

            // Append the character 'count' times
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}