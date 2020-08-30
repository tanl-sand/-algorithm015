package Week_01;

import java.util.Arrays;

public class Rotate {

    /**
     * 替换思路
     */
    public void rotate(int[] nums, int k) {
        if (nums.length == 0){
            return;
        }
        k = k % nums.length;
        //替换个数
        int rotateCount = 0;
        //遍历下标
        int index = 0;
        //正在替换的下标
        int nowIndex = 0;
        boolean flag = false;
        int nowNum = nums[0];
        while (rotateCount < nums.length){
            if(index == nowIndex && flag){
                index++;
                nowIndex++;
                nowNum = nums[index];
            }
            flag = true;
            int lastIndex = (k + nowIndex)%(nums.length);
            int tmpNum = nums[lastIndex];
            nums[lastIndex] = nowNum;
            nowNum = tmpNum;
            nowIndex = lastIndex;
            rotateCount ++;
        }
    }

    /**
     * 题解里提供的反转
     */
    public void rotate2(int[] nums, int k) {
        if(nums.length == 0){
            return;
        }
        k = k % nums.length;
        reversal(0, nums.length-1, nums);
        reversal(0, k-1, nums);
        reversal(k, nums.length-1, nums);
    }

    private void reversal(int start, int end, int[] nums){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }
}
