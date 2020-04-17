// Time Complexity : O(n)
// Space Complexity : O(n) We use additional array to store candies
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        int count = 0;
        
        // Fill the candies with 1 as all the student must have atleast 1 candy with them.
        Arrays.fill(candies, 1);
        
        //Pass 1
        // Check if the right student is having greater ratings
        // Add one more candy for the current student from prev student
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1; 
            }
        }
        
        // pass 2
        // From reverse, check if the left student is having greater rating
        // If so, then add one more candy to the right person and that will be the current student candy count.
        // Finally we need to get the MAX of left pass and right pass, which I am performing while calculating the right candy
        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1); 
            }
        }
        
        for(int i=0; i<candies.length; i++){
            count += candies[i];
        }
        
        return count;
    }
}
