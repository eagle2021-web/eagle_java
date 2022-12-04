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

    public static void main(String[] args) {
        Solution s = new Solution();
        s.closestCost(new int[]{2,3}, new int[]{4, 5, 100}, 18);
    }



    int[] f;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++){
                int f1 = find(i), f2 = find(j);
                if(f1 == f2)continue;
                if(match(strs[i], strs[j])){
                    f[f1] = f2;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if(f[i] == i)res++;
        }
        return res;
    }

    public int find(int x){
        return x == f[x] ? x : (f[x] = find(f[x]));
    }

    public boolean match(String s1, String s2){
        int n1 = s1.length(), n2 = s2.length();
        if(n1 != n2)return false;
        int cnt = 0;
        for (int i = 0; i < n1; i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
                if(cnt > 2)return false;
            }
        }
        return true;
    }
}
