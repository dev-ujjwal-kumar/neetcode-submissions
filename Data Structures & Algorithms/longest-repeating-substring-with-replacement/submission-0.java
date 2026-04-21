class Solution {
    private int findMaxFrequency(int[] arr){
        int maxi = 0;
        int maxIndex = -1;

        for(int i=0; i<26; i++){
            if(arr[i] > maxi){
                maxi = arr[i];
                maxIndex = i;
            }
        }

        return maxi;
    }
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int maxLength = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()){
            // updateing frequency table
            freq[s.charAt(right) - 'A']++;
            right++;

            int maxFreq = findMaxFrequency(freq); 

            int windowSize = right - left;

            if(windowSize - maxFreq <=k){                
                maxLength = Math.max(maxLength, right - left);
            }else{
                freq[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return maxLength;

    }
}
