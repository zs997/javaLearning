package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode116PopulatingNextRightPointers {
    /*
          树的每一层节点，指向右兄弟
  * */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeLinkNode tail = root;
        while (!queue.isEmpty()) {
            //拿出队头
            TreeLinkNode temp = queue.poll();
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
                tail = ((LinkedList<TreeLinkNode>) queue).peekLast();
            } else {
                temp.next = queue.peek();
            }
        }
    }
}
