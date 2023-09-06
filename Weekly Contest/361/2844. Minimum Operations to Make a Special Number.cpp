class Solution {
public:
    int minimumOperations(string str) {
        int ans = INT_MAX;  // Initialize ans to a large value
        
        int N = str.size();
        
        // Base case: If the string has only one character, return 1
        if (N == 1) {
            return 1;
        }
        // Handle special cases for two-character strings
        else if (N == 2) {
            if (str == "25" || str == "50" || str == "75" || str == "00") {
                return 0; // No operations needed
            }
            else if (str[0] == '0' || str[1] == '0') {
                return 1; // One operation needed to remove '0'
            }
            else {
                return 2; // Two operations needed to change to '25' or '50' or '75'
            }
        }
        
        int cnt = count(str.begin(), str.end(), '0'); // Count the number of '0's in the string
        
        // Iterate through the string to find valid pairs of digits
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int num = (str[i] - '0') * 10 + (str[j] - '0'); // Convert two characters to a number
                if (num % 25 == 0) { // Check if the number is divisible by 25
                    int a = j - i - 1; // Operations needed to remove characters between i and j
                    int b = N - (j + 1); // Operations needed to remove characters after j
                    ans = min(ans, a + b); // Update the minimum operations
                }
            }
        }
        
        // If ans is still at its initial value, no valid pair was found, so return N - cnt
        return ans == INT_MAX ? N - cnt : ans;
    }
};
