class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> wfm = new HashMap<>(); // wfm : window frequency map

        // checking for invalid case
        if(s2.length() < s1.length()){
            return false;
        }

        // creating s1 frequncy map
        for(char ch : s1.toCharArray()){
            if(s1Map.containsKey(ch)){
                s1Map.put(ch, s1Map.get(ch) + 1);
            }else{
                s1Map.put(ch, 1);
            }
        }

        // creating frequency map for 1st window
        for(int i=0; i<s1.length(); i++){
            wfm.compute(s2.charAt(i), (key, value) -> value == null ? 1 : value + 1);
        }

        // checking for 1st window for permutation
        if(s1Map.equals(wfm)){
            return true;
        }

        // sliding the window and checking the frequency
        int left = 0;
        int right = s1.length();
        while(right < s2.length()){
            // removing element from left
            wfm.put(s2.charAt(left), wfm.get(s2.charAt(left)) - 1);
            if(wfm.get(s2.charAt(left)) == 0){
                wfm.remove(s2.charAt(left));
            }
            left++;

            //adding right to element
            wfm.compute(s2.charAt(right), (key, value) -> value == null ? 1 : value + 1);
            right++;

            System.out.println("\nWFM");
            // for(Map.Entry<Character, Integer> entry : wfm.entrySet()){
            //     System.out.println(entry.getKey() + ":" + entry.getValue());
            // }

            // checking for the combination if exists
            if(s1Map.equals(wfm)){
                return true;
            }
        }
        return false;
    } 
}
