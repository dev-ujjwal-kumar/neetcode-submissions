class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        // int tl = (int) Math.ceil((n1 + n2)/2); // Total Length of array
        int tl = n1 + n2;
        int mc = 0; // Mid Counter   
        int[] sortedArray = new int[tl];
        int i1 = 0;
        int i2 = 0;
        int sai = 0; // sorted Array Index

        while(i1 < n1 && i2 < n2 && sai < (tl)){
            if(nums1[i1] < nums2[i2]){
                sortedArray[sai++] = nums1[i1];
                i1++;
            }else{
                sortedArray[sai++] = nums2[i2];
                i2++;
            }
        }

        while(i1 < n1 && sai < (tl)){
            sortedArray[sai++] = nums1[i1++];
        }

        while(i2 < n2 && sai < (tl)){
            sortedArray[sai++] = nums2[i2++];
        }
        
        if(tl == 1)
            return sortedArray[tl-1];
        
        res = (tl%2 == 0)
            ? (sortedArray[(tl/2)] + sortedArray[(tl/2) - 1]) / 2.0
            : sortedArray[tl/2];

        return res;
        
    }
}
