package com.Tencent.LC1;

import java.util.HashMap;
import java.util.Map;


/*
* 两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/tencent/xxqfy5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


public class Main {

    static class Solution {
        public int[] twoSum(int[] nums, int target)
        {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++)
            {
                int complement = target - nums[i];
                if (map.containsKey(complement))
                {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    public static void main(String[] args) {
	// write your code here
        int a[]={1,5,6,9,10};
        int target=11;
        Solution ab=new Solution();
        int[] result=ab.twoSum(a,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}
