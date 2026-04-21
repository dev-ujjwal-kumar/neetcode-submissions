class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(int i=0; i<strs.length; i++){
            char[] tempArray = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);

            if(mp.containsKey(sortedString)){
                List<String> stringList = mp.get(sortedString);
                stringList.add(strs[i]);
                mp.put(sortedString, stringList);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                mp.put(sortedString, newList);
            }
        }

        // List<List<String>> ls2d = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> mapElement : mp.entrySet()){
            res.add(mapElement.getValue());
        }

        return res;
    }
}
