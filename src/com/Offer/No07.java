package com.Offer;

import java.util.HashMap;

/*剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


限制：

0 <= 节点个数 <= 5000

 */
public class No07 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
    int[] preorder;//保留的先序遍历

    TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0,0,inorder.length-1);
    }

    /**
     * @param pre_root_idx  先序遍历的索引
     * @param in_left_idx  中序遍历的索引
     * @param in_right_idx 中序遍历的索引
     */
    TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        //相等就是自己
        if (in_left_idx > in_right_idx) {
            return null;
        }
        //root_idx是在先序里面的
        TreeNode root = new TreeNode(preorder[pre_root_idx]);
        // 有了先序的,再根据先序的，在中序中获 当前根的索引
        int idx = map.get(preorder[pre_root_idx]);

        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        root.left = recursive(pre_root_idx + 1, in_left_idx, idx - 1);

        //由根节点在中序遍历的idx 区分成2段,idx 就是根

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        root.right = recursive(pre_root_idx + (idx - 1 - in_left_idx + 1) + 1, idx + 1, in_right_idx);
        return root;
    }
}


/*题思路：
前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。

以题目示例为例：

前序遍历划分 [ 3 | 9 | 20 15 7 ]
中序遍历划分 [ 9 | 3 | 15 20 7 ]
根据以上性质，可得出以下推论：

前序遍历的首元素 为 树的根节点 node 的值。
在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 [ 左子树 | 根节点 | 右子树 ] 。
根据中序遍历中的左 / 右子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ] 。


通过以上三步，可确定 三个节点 ：1.树的根节点、2.左子树根节点、3.右子树根节点。
对于树的左、右子树，仍可使用以上步骤划分子树的左右子树。

以上子树的递推性质是 分治算法 的体现，考虑通过递归对所有子树进行划分。

分治算法解析：
递推参数： 根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right ；

终止条件： 当 left > right ，代表已经越过叶节点，此时返回 nullnull ；

递推工作：

建立根节点 node ： 节点值为 preorder[root] ；
划分左右子树： 查找根节点在中序遍历 inorder 中的索引 i ；
为了提升效率，本文使用哈希表 dic 存储中序遍历的值与索引的映射，查找操作的时间复杂度为 O(1)O(1)

构建左右子树： 开启左右子树递归；
根节点索引	中序遍历左边界	中序遍历右边界
左子树	root + 1	left	i - 1
右子树	i - left + root + 1	i + 1	right
i - left + root + 1含义为 根节点索引 + 左子树长度 + 1

返回值： 回溯返回 node ，作为上一层递归中根节点的左 / 右子节点；

作者：jyd
链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
