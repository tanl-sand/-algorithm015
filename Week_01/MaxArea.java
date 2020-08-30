package Week_01;

public class Aquamanile {

    //思路 下标距离和两个值中较小的值

    /**
     * 解法2：两次遍历
     * 之前获取最小值用的是三目运算 耗时比 Math函数要长
     */
    public static int maxArea(int[] height) {
        int maxNum = 0;
        for (int i = 0; i < height.length; i++) {
            if(i == height.length -1){
                return maxNum;
            }
            for (int j = i+1; j < height.length; j++) {
                int nowNum = (Math.min(height[i], height[j]))*(j-i);
                System.out.print(nowNum+ " ");
                maxNum = Math.max(nowNum, maxNum);
            }
            System.out.println(" " + maxNum);
        }
        return maxNum;
    }

    /**
     * 解法2：根据题解得到双子针思路
     * 前期有考虑头尾指针遍历，但是没有想到对比数值小的指针继续遍历数值大的保持不变这个点。
     */
    public static int maxArea2(int[] height) {
        int maxNum = 0;
        int startIndex = 0;
        int endIndex = height.length-1;
        while (startIndex < endIndex){
            int nowNum;
            if(height[startIndex] > height[endIndex]){
                nowNum = height[endIndex] * (endIndex - startIndex);
                endIndex --;
            } else {
                nowNum = height[startIndex] * (endIndex - startIndex);
                startIndex ++;
            }
            maxNum = Math.max(nowNum, maxNum);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int []{1,6,2,5,4,8,3,7}));
    }
}
