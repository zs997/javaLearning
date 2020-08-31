package cn.zs.practice.leetcode;
import cn.zs.commonStructure.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class LeetCode102BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (res == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tail = root;
        ArrayList<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            //拿出队头
            TreeNode temp = queue.poll();
            level.add(temp.val);
            //插入左右节点
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            //插入左右节点
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            //判断是不是该层的最后节点
            if (temp == tail) {
                //更新tail为下一层的最后
                tail = ((LinkedList<TreeNode>) queue).peekLast();
                res.add(0, new ArrayList<>(level));
                level.clear();
            }
        }
        return res;
    }
}
