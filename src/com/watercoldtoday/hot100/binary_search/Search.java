package com.watercoldtoday.hot100.binary_search;

public class Search {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[r-1]) {
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2},0));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2},3));
        System.out.println(search.search(new int[] {1},0));
    }
}
