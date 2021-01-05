package com.Tencent.LC5;

/*最长公共前缀
        编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。

        示例 1:

        输入: ["flower","flow","flight"]
        输出: "fl"
        示例 2:

        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。
        说明:

        所有输入只包含小写字母 a-z 。

        作者：力扣 (LeetCode)
        链接：https://leetcode-cn.com/leetbook/read/tencent/xxzqki/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for(int i=0; i<strs.length; i++) {
            while(strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length()-1);
                if(result.length() == 0) {
                    return "";
                }
            }
        }
        return result;
    }
}
