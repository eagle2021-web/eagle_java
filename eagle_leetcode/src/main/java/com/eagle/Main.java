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
//        s.boxDelivering(new int[][]{{1, 1}, {2,1 }, {1,1}}, 2, 3, 3);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = (n1 + n2 + 1) / 2, nn = n + (n1 + n2) % 2 == 0 ? 1 : 0;
        return (getKthElement(nums1, nums2, n) + getKthElement(nums1, nums2, nn)) / 2.0;
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int index1 = 0, index2 = 0, k2 = k;
        while (true){
            if(index1 == m)return nums2[k - index1 - 1];
            if(index2 == n)return nums1[k - index2 - 1];
            if(k2 == 1)return Math.min(nums1[index1], nums2[index2]);

            int half = k2 / 2;
            int newIndex1 = Math.min(m, index1 + half) - 1;
            int newIndex2 = Math.min(n , index2 + half) - 1;

            if(nums1[newIndex1] <= nums2[newIndex2]){

                k2 -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k2 -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }

    public int trap(int[] height) {
        return 1;
    }




    public int getKthElement2(int[] nums1, int[] nums2, int k) {

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


}
