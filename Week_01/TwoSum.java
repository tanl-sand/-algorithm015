package Week_01;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     这个题之前做过 记得一个比较有意思的解决方法是用hash
     */
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int nowNum = nums[i];
            Integer lastIndex = map.get(target - nowNum);
            if (lastIndex != null) {
                return new int[]{lastIndex, i};
            }
            map.put(nowNum, i);
        }
        return new int[]{};
    }
}
