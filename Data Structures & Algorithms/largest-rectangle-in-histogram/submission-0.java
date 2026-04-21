class Solution {
    private int[] nextSmallerElement(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] indexArray = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            indexArray[i] = stack.empty() ? n : stack.peek();
            stack.push(i);            
        }

        return indexArray;
    }

    private int[] prevSmallerElement(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] indexArray = new int[n];


        for(int i=0; i<n; i++){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            indexArray[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);            
        }

        return indexArray;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        //calculating index of next and prev smaller element
        int[] nextSmaller = nextSmallerElement(heights);
        int[] prevSmaller = prevSmallerElement(heights);

        for(int i=0; i<n; i++){
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = width * heights[i];

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;        
    }
}
