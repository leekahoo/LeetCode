package com.Offer;

import java.util.HashSet;

/*
剑指 Offer 03. 数组中重复的数字
        找出数组中重复的数字。


        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

        示例 1：

        输入：
        [2, 3, 1, 0, 2, 5, 3]
        输出：2 或 3


        限制：

        2 <= n <= 100000

注意是否有空间复杂度或者时间复杂度的要求，同时原数据是否允许被修改*/

public class No03 {
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            HashSet hashSet =new HashSet();
            for (int i:nums) {
                if(hashSet.contains(i)){
                    return i;
                }
                else
                    hashSet.add(i);
            }
            return 0;
        }
/*
        // //方法1：排序，时间O(nlogn)，空间O(logn)，修改了原数据
        // public int findRepeatNumber(int[] nums) {
        //     Arrays.sort(nums);
        //     for(int i = 0 ; i < nums.length-1 ;i++){
        //         if(nums[i]==nums[i+1]) return nums[i];
        //     }
        //     return -1;
        // }

        //方法2：hash表，时间O(n)，空间O(n)，不修改原数据
        // public int findRepeatNumber(int[] nums) {
        //     HashSet<Integer> set = new HashSet<>();
        //     for(int num:nums){
        //         if(set.contains(num)) return num;
        //         set.add(num);
        //     }
        //     return -1;
        // }

        // //方法3：利用辅助数组，与方法2类似，时间O(n)，空间O(n)，不修改原数据
        // public int findRepeatNumber(int[] nums) {
        //     boolean[] isExist = new boolean[nums.length];
        //     for(int num : nums){
        //         if(isExist[num]) return num;
        //         isExist[num] = true;
        //     }
        //     return -1;
        // }

        // //方法4：利用索引与数字的关系，时间O(n)，空间O(1)，修改了原数据
        public int findRepeatNumber(int[] nums) {
            if(nums==null || nums.length==0) return -1;
            for(int i = 0 ; i < nums.length;i++){
                //如果该数字没有不和他的索引相等
                while(nums[i]!=i){
                    //重复返回
                    if(nums[i]==nums[nums[i]]){
                        return nums[i];
                    }
                    //不重复交换
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
            return -1;
        }

        // //方法5：对0到n-1进行二分查找，时间O(nlogn)，空间O(1)，不修改原数据，用时间换空间
        //该方法需要数字一定有重复的才行，因此如果题目修改在长度为n，数字在1到n-1的情况下，此时数组中至少有一个数字是重复的，该方法可以通过。
        // public int findRepeatNumber(int[] nums) {
        //     //统计nums中元素位于0到m的数量，如果数量大于这个值，那么重复的元素肯定是位于0到m的
        //     int min = 0 ;
        //     int max = nums.length-1;
        //     while(min<max){
        //         int mid = (max+min)>>1;
        //         int count = countRange(nums,min,mid);
        //         if(count > mid-min+1) {
        //             max = mid;
        //         }else{
        //             min = mid+1;
        //         }
        //     }
        //     最后min=max
        //     return min;
        // }

        // //统计范围内元素数量,时间O(n)
        // private int countRange(int[] nums,int min,int max){
        //     int count = 0 ;
        //     for(int num:nums){
        //         if(num>=min && num<=max){
        //             count++;
        //         }
        //     }
        //     return count;
        // }*/
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,3,5};
        Solution a=new Solution();
        System.out.println(a.findRepeatNumber(nums));
    }
}
