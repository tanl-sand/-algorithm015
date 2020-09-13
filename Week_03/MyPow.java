package Week_03;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double result = recurrence(x, n);
        return n < 0? 1/result:result;
    }
    public double recurrence(double x, int n) {
        if(n == 0){
            return 1;
        }
        double childResult = recurrence(x, n/2);
        double result = childResult * childResult;
        return n%2 == 0? result: result*x;
    }
}
