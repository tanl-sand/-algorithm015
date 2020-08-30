package Week_01;

import java.util.Stack;

/**
 * 只需要判断连续相同数字
 */
public class RemoveDuplicates {

    /**
     * 普通解法
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int j = 1;
        int nowNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nowNum){
                nowNum = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 耗时更长 没啥用
     * 使用栈 逻辑上是一样的,
     */
    public int removeDuplicates2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(stack.empty()){
                stack.push(nums[i]);
                j++;
                continue;
            }
            if(stack.peek() != nums[i]){
                stack.push(nums[i]);
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
