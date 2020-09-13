package Week_02;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    /**
     * 排序后hash
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char [] strArys = strs[i].toCharArray();
            Arrays.sort(strArys);
            List<String> list =  map.get(String.valueOf(strArys));
            if(list == null){
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(String.valueOf(strArys), list);
            } else {
                list.add(strs[i]);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            list.add(stringListEntry.getValue());
        }
        return list;
    }
}
