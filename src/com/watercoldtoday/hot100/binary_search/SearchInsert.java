package com.watercoldtoday.hot100.binary_search;

public class SearchInsert {

    public int searchInsert(int[] nums,int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(searchInsert.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(searchInsert.searchInsert(new int[] {1,3,5,6}, 7));
    }
}
