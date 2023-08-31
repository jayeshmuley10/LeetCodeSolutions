class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int length = hours.length;
        int count = 0;
        
        for (int i = 0; i < length; i++) {
            if (hours[i] >= target) {
                count++;
            }
        }
        
        return count;
    }
}
