class Solution {
    private boolean isValidSpeed(int[] piles, int mid, int h){
        int currHour = 0;
        
        for(int i=0; i<piles.length; i++){
            double timeForCurrPile = Math.ceil((double) piles[i] / mid);
            currHour += (int) Math.ceil(timeForCurrPile);
            System.out.print(timeForCurrPile + " ");
        }

        System.out.println(currHour);
        boolean isValid = currHour > h ? false : true;
        return isValid;
    }
    

    public int minEatingSpeed(int[] piles, int h) {
        OptionalInt maxi = Arrays.stream(piles).max();
        int end = maxi.getAsInt();
        int start = 1;
        int res = 0;

        while(start <= end){
            int mid = start + (end - start)/2;
            System.out.println(mid);
            if(isValidSpeed(piles, mid, h)){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return res;

    }
}
