package com.watercoldtoday.hot100.binary_search;

public class FindMin {

    public int findMin1(int[] nums) {
        int l = 0, r = nums.length;
        int end = nums[r-1];
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (nums[mid] > end) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin.findMin(new int[]{11,13,15,17}));
    }
}
