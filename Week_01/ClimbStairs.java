package Week_01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第一个想法 通过二叉树实现 每个父节点都有两个子节点一个减1一个减2 计算叶子节点个数
 * 例如       5
 *      4          3
 *   2    3      2   1
 * 1  0｜1  2｜ 1  0
 *        1  0
 * 想到的实现办法是递归
 *
 */
public class ClimbStairs {
    static Map<Integer, Integer> map = new HashMap<>();
    public static int climbStairs(int n) {
        AtomicInteger i=new AtomicInteger(0);
        climbStairs(n, i);
        return i.get();
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static void climbStairs(int n, AtomicInteger i) {
        if(map.containsKey(n)){
            i.set(map.get(n) + i.get());
            System.out.println(n + " " + i.get());
            return;
        }
        if(n < 2){
            i.set(i.get()+1);
            return;
        }
        climbStairs(n-1, i);
        climbStairs(n-2, i);
        System.out.println("put" + n + " " + i.get());
        map.put(n, i.get());

    }
}
