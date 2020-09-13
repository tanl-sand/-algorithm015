package Week_03;

import java.util.*;

/**
 *  n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *  
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class SolveNQueens {
    int[] result;
    Set<Integer> cols = new HashSet();
    Set<Integer> pies = new HashSet();
    Set<Integer> nas = new HashSet();

    public List<List<String>> solveNQueens(int n) {
        result = new int[n];
        recurrence(0, n);
        return new ArrayList<>();
    }

    public void recurrence(int col, int n){
        if(col == n){
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < n; j++) {
                    if(result[i] == j){
                        System.out.print(1);
                    }else {
                        System.out.print(0);
                    }
                }
                System.out.println();
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(cols.contains(col) || pies.contains(col + i) || nas.contains(col - i)){
                continue;
            }
            cols.add(col);
            pies.add(col + i);
            nas.add(col - i);
            result[col] = i;
            recurrence(col + 1, n);
            result[col] = -1;
            cols.remove(col);
            pies.remove(col + i);
            nas.remove(col - i);
        }
    }
}
