package Week_01;

import java.util.Stack;
import java.util.Queue;

/**
 * 和实战讲解中的 柱状图最大矩形类似 可以使用stack解决
 * 遍历数组 if(stack.top < height[i]) push height[i]
 * if(stack.top > height[i]) area+=height[i]-stack.top
 *
 * 上述为个人思考不能解决问题
 * 因为没有考虑到 右边比左边高到情况统计错误 看了下https://leetcode-cn.com/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
 * 理解了很久才明白思路 独立实现
 *
 */
public class Trap {
    /**
     * 1、动态规划
     * 遍历节点该找到左边最大节点和右边最大节点 取两节点中较小的与当前节点相减 如大于0则为当前节点积水量
     * max_left[i] = max(max_left[i-1], height[i-1])
     * max_right[i] = max(max_right[i-1], height[i-1])
     * i节点的左边最大节点 为i-1节点与i-1节点的左边最大节点中取较大的值
     * 双指针的逻辑没你那个明白
     */
    public int trap (int[] height) {
        if(height.length < 3){
            return 0;
        }
        int max_left = 0;
        int area = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }
        for (int i = 1; i < height.length; i++) {
            max_left = Math.max(max_left, height[i-1]);
            int min = Math.min(max_left, max_right[i]);
            if(min > height[i]){
                area += (min - height[i]);
            }
        }
        return area;
    }

    public int ERRORTrap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            if(stack.empty() || height[i] < stack.peek()){
                stack.push(height[i]);
            }else {
                System.out.println();
                area += height[i] - stack.peek();
            }
        }
        return area;
    }
}
