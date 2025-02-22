package Daily_Challenges;

import java.util.ArrayList;

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
**********************************************************************************************
Question_Number:6) Pass The Pillow
 Input: n = 4, time = 5
Output: 2
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.
After five seconds, the 2nd person is holding the pillow.

Solutions:
class Solution {
    public int passThePillow(int n, int time) {
        int pillowPosition=1;
        int currentTime=0;
        boolean revDirection = false;
        while(currentTime < time){
            if(!revDirection){
                pillowPosition++;
            }else{
                pillowPosition--;
            }
            if(pillowPosition==1 || pillowPosition==n){
                revDirection=!revDirection;
            }
            currentTime++;
        }
        return pillowPosition;
        
    }
}
 *************************************************************************************

Question_Number:7) Water Bottles
Input: Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.

Solution:
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;
        while(numBottles >= numExchange){
            int exchanged = numBottles/numExchange;
            int extraEmpty = numBottles%numExchange;
            drank+=exchanged;
            numBottles = exchanged + extraEmpty;
        }
        return drank;
        
    }
}
 ************************************************************************
Que_Number 8) Find the Winner of Circular Game
Input: n = 5, k = 2
Output: 3
Explanation: Here are the steps of the game:
1) Start at friend 1.
2) Count 2 friends clockwise, which are friends 1 and 2.
3) Friend 2 leaves the circle. Next start is friend 3.
4) Count 2 friends clockwise, which are friends 3 and 4.
5) Friend 4 leaves the circle. Next start is friend 5.
6) Count 2 friends clockwise, which are friends 5 and 1.
7) Friend 1 leaves the circle. Next start is friend 3.
8) Count 2 friends clockwise, which are friends 3 and 5.
9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.

Solution:

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> qu = new LinkedList<>();
        for(int i=1; i<=n; i++){
            qu.offer(i);

        }while(qu.size() !=1){
            for(int j=1; j<=k-1;j++){
                qu.offer(qu.poll());
            }
            qu.poll();
        }
        return qu.poll();
**********************************
//Another Approach

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int index=0;
        while(list.size()>1){
            index = (index + (k-1))%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
*************************************************************************************
Que_Number 9)Average Waiting Time
Input: customer =[[1,2],[2,5][4,3]]
Output: 5.00000

Explanation:




*/
  
}
