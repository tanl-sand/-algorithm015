package Week_01;

/**
 * 方法1 数组->数字->数组 需要两边遍历
 * 方法2 从后往前遍历 遇9加1
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int num = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] + num == 10){
                digits[i] = 0;
                num = 1;
            } else {
                digits[i] += num;
                return digits;
            }
        }
        int[] newAry = new int[digits.length +1];
        newAry[0] = num;
        return newAry;
    }
}
