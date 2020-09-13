package Week_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    /**
     * 比较简单 hash 解决
     */
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map =  new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            Integer value = map.get(c);
            if(value == null){
                map.put(c, 1);
            }else {
                map.put(c, ++value);
            }
        }
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            Integer value = map.get(c);
            if(value == null){
                return false;
            }
            if (value == 1){
                map.remove(c);
                continue;
            }
            map.put(c, --value);

        }
        if (map.isEmpty()){
            return true;
        }
        return false;
    }


    /**
     * 看了官方代码 改变下思路使用hashmap
     */
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            Integer sValue = map.get(sChar);
            char tChar = t.charAt(i);
            Integer tValue = map.get(tChar);
            if(sValue == null){
                map.put(sChar, 0);
            }else {
                map.put(sChar, ++sValue);
            }
            if(tValue == null){
                map.put(tChar, 0);
            }else {
                map.put(tChar, --tValue);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if(characterIntegerEntry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 官方答案 这个答案写的牛皮
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            chars[sChar - 'a'] = ++chars[sChar - 'a'];
            chars[tChar - 'a'] = --chars[tChar - 'a'];
        }
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("adfaf", "fafdaf");
    }
}
