package Week_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k > n) return result;
        recurrence(result, n, k, new ArrayList<>(), 1);
        return result;
    }

    public void recurrence(List<List<Integer>> result, int n, int k, List<Integer> tmp, int index){
        if(tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i <= n; i++) {
            tmp.add(i);
            recurrence(result, n, k, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }

    }


}
