package Week_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParenthesis {

    static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        recurrence(n, 0, 0, "");
        return result;
    }

    private static void recurrence (int max, int leftNum, int rightNum, String s){
        if(leftNum == max && rightNum == max){
            result.add(s);
            return;
        }
        if (leftNum < max){
            String sLeft = s + "(";
            recurrence(max, leftNum +1, rightNum, sLeft);
        }
        if (leftNum > rightNum){
            String sright = s + ")";
            recurrence(max, leftNum, rightNum + 1, sright);
        }
    }

    /*public static List<String> generateParenthesis(int n) {
        recurrence(0, n*2, 0, 0, "");
        return result;
    }

    private static void recurrence (int level, int max, int leftNum, int rightNum, String s){
        if(leftNum < rightNum){
            return;
        }
        if(level >= max){
            if (leftNum == rightNum)
            result.add(s);
            return;
        }
        String sLeft = s + "(";
        String sright = s + ")";
        recurrence(level +1, max, leftNum +1, rightNum, sLeft);
        recurrence(level +1, max, leftNum, rightNum + 1, sright);
    }*/

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}
