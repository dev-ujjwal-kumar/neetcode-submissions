class Solution {

    public String encode(List<String> strs) {
        String res = "";

        for(String s : strs){
            res += String.valueOf(s.length());
            res += "#";
            res += s;
        }
        System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            String len = "";
            while(str.charAt(i) != '#'){
                len += str.charAt(i);
                i++;
            }
            i++;//skipping '#'
            String temp = "";
            int j = 0;
            while(j < Integer.valueOf(len)){
                temp += str.charAt(i + j);
                j++;
            }
            decodedString.add(temp);
            i += Integer.valueOf(len);
        }
        return decodedString;

    }
}
