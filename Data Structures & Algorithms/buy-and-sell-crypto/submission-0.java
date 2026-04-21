class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            int sp = prices[i]; //selling price
            for(int j=0; j<i; j++){
                int pp = prices[j]; // seling price
                if( sp > pp){
                    maxProfit = Math.max(maxProfit, sp - pp);
                }
            }
        }

        return maxProfit;
        
    }
}
