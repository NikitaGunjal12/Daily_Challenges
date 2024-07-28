package Daily_Challenges;

public class DailyLeetCodePrograms {

/*Question_Number:3)-Minimum difference Between Largest And Smallest value in Three Moves.
Input: nums = [5,3,2,4]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 2 to 3. nums becomes [5,3,3,4].
In the second move, change 4 to 3. nums becomes [5,3,3,3].
In the third move, change 5 to 3. nums becomes [3,3,3,3].
After performing 3 moves, the difference between the minimum and maximum is 3 - 3 = 0.
Solution:

class Solution {
    public int minDifference(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length, min =Integer.MAX_VALUE;
        if(n <= 3)
        return 0;
        for(int i=1; i<=4; i++){
            min = Math.min(min, Math.abs(nums[n-i] - nums[4-i]));
        }
        return min;
    }
}
 *************************************************************************
Question_Number-4)Merge Nodes In Between zeros
 Example 1:
Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.

Solutions:
Definition for singly-linked list.
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head.next;
        ListNode temp = node;
        while(temp!=null){
            //find sum within block
            int sum=0;
            while(temp.val!=0){
                sum +=temp.val;
                temp = temp.next;

            }
            //update value
            node.val = sum;
            //move temp to the next block
            temp = temp.next;
            //connect the next block
            node.next = temp;
            //move node to the next block
            node = temp;
        }
        head = head.next;
        return head;
     }
}

**************************************************************************
Question_Number:5)Find the Minimum and Maximum number of Node bet Critical Path
Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].

Solution:

 Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCPI= -1;
        int prevCPI= -1;
        int currentIndex = 1;
        ListNode cur = head.next;
        ListNode prev = head;
        int res[] = new int[2];
        res[0] = Integer.MAX_VALUE;
        while(cur.next!=null){
            ListNode nextNode = cur.next;
            if((cur.val< nextNode.val && cur.val <prev.val) ||
            (cur.val> nextNode.val && cur.val > prev.val)){
                if(prevCPI ==-1){
                    firstCPI = currentIndex;
                    prevCPI = currentIndex;
                }else{
                    res[0]= Math.min(res[0],currentIndex-prevCPI);
                    prevCPI = currentIndex;
                }
            }
            prev = prev.next;
            cur = cur.next;
            currentIndex++;
        }
        if(firstCPI!=-1 && res[0]!=Integer.MAX_VALUE){
            res[1] = prevCPI - firstCPI;
        }else{
            res[0] = -1;
            res[1] = -1;

        }
        return res;
    }
}
*/
  
}
