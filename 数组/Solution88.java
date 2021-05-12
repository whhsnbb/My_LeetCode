package 数组;
//88. 合并两个有序数组
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
//
//
//
//示例 1：
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//示例 2：
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
class Solution88 {
    //双指针，新创建一个数组然后放置有序数组，然后将新数组拷贝到nums1里就可以了
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArray = new int[m+n];
        int left  = 0;
        int right = 0;
        int index = 0;
        while (left < m || right < n){
            if(left < m && right < n){
                newArray[index++] = nums1[left] < nums2[right] ? nums1[left++]:nums2[right++];
            }else if(left < m){
                newArray[index++] = nums1[left++];
            }else{
                newArray[index++] = nums2[right++];
            }
        }
        System.arraycopy(newArray,0,nums1,0,m+n);
    }
}

