// Time Complexity : O(n)
// Space Complexity : O(1) No Additional space used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        
        // eg - AAABBB
        // MAx_freq = 3 as A ocurs 3 times
        // OccOfMaxFreq is 2 as B also occurs 3 times
        int maxFreq = 0;
        int occurOfMaxFreq = 0;
        
        //Update frequenct Array
        for(char task: tasks){
            frequency[task -'A']++;
            if(frequency[task -'A'] > maxFreq){
                maxFreq = frequency[task -'A'];
                occurOfMaxFreq = 1;
            }else if(frequency[task -'A'] == maxFreq){
                occurOfMaxFreq++;
            }
        }
        
        // PArtitions are the no of divisions we can make with the given no of tasks
        // Cooling Period = 2 Below is the partition based on the cooling interval
        // A being the max frequncy task this can not be more closed. So there must be 
        // 2 partitions which has to be filled with other tasks if not with idle periods
        // Eg -  A _ _ /A _ _ /A_
        int partitions = maxFreq -1; 
        // In the given array I have assigned high frequent tasks, remaining are the rest of high frequent tasks.
        int pendingTasks = tasks.length - (maxFreq * occurOfMaxFreq);
        
        // Calculate the no.of empty slots
        // if empty slots is Total No of tasks - no of max freq tasks(Which are filled in first place)
        int noOfEmptySlots = partitions * (n - (occurOfMaxFreq-1));
        
        // Idle slots are those emptyslots which are not occupied by pending tasks. If there are more pending task than empty then there is no idle which is 0
        int idle = Math.max(0, noOfEmptySlots - pendingTasks);
        
        return tasks.length + idle;
        
    }
}
