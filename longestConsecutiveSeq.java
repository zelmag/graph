//find longest consecutive sequence in O(N) time. O(N) space.
//Store all numbers in a set. 
class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<Integer>();
        for(int n : nums){
            set.add(n);
        }
        int maxSequence = 0;
        for(Integer element : set){
            int currSequenceLength = 0; 
            if(!set.contains(element-1)){
                currSequenceLength = 1;
                //im the starting point
                Integer next = element+1;
                while(set.contains(next)){
                    currSequenceLength++;
                    next++;
                }
            }
            maxSequence = Math.max(currSequenceLength, maxSequence);
        }
        return maxSequence;
    }
}
