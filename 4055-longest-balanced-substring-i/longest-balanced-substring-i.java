class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        // Fix starting index
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            // Expand substring
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                // Update frequency
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // Check if balanced
                if (isBalanced(map)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    // Function to check if all frequencies are equal
    private boolean isBalanced(HashMap<Character, Integer> map) {
        int freq = -1;

        for (int value : map.values()) {
            if (freq == -1) {
                freq = value;  // first frequency
            } else if (value != freq) {
                return false;  // mismatch found
            }
        }

        return true;
    }
}
