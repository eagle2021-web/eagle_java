package com.eagle;

import com.eagle.common.TreeNode;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
@SuppressWarnings("all")
class Solution {
    int res = Integer.MIN_VALUE;
    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node==null)return 0;
        int l = dfs(node.left), r = dfs(node.right);
        l = Math.max(l, 0);
        r = Math.max(r, 0);
        int max = node.val + l + r;
        res = Math.max(max, res);
        return node.val + Math.max(l, r);
    }
}
