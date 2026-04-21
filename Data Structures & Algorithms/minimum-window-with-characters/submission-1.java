class Solution {
    private boolean checkMap(Map<Character, Integer> curr, Map<Character, Integer> target){
        for(Map.Entry<Character, Integer> entry : target.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            Integer currValue = curr.get(key);
            if(currValue == null || currValue < value){
                return false;
            }              
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> currMap = new HashMap<>();
        int currLen = 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;

        if(s.length() < t.length()){
            return "";
        }

        //creating target map
        for(int i=0; i<t.length(); i++){
            Character c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        //creating first window
        for(right=0; right<t.length(); right++){
            Character ch = s.charAt(right);
            currMap.put(ch, currMap.getOrDefault(ch, 0) + 1);
        }


        while(right < n){
            // if both map are same
            if(checkMap(currMap, targetMap)){
                System.out.println(currMap);
                currLen = right - left;
                if(minLen > currLen){
                    minLen = currLen;
                    minLeft = left;
                    minRight = right;
                }
                minLen = Math.min(currLen, minLen);
                int excludingLeftValue = currMap.get(s.charAt(left)) - 1;
                currMap.put(s.charAt(left), excludingLeftValue);
                left++;
            }else{
                Character ch = s.charAt(right);
                currMap.put(ch, currMap.getOrDefault(ch, 0) + 1);
                right++;
            }
        }

        // for last window when right has reached the end but we have scope to reduce left
        while(checkMap(currMap, targetMap)){
            System.out.println(currMap);
            currLen = right - left;
            if(minLen > currLen){
                minLen = currLen;
                minLeft = left;
                minRight = right;
            }
            int excludingLeftValue = currMap.get(s.charAt(left)) - 1;
            currMap.put(s.charAt(left), excludingLeftValue);
            left++;
        }
        System.out.println(minLen);
        return s.substring(minLeft, minRight);        
    }
}
