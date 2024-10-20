package leetcode.binary_search.p0268_missing_number;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;                                                                                                   
            if (nums[mid] == mid && (mid == right || nums[mid + 1] != mid + 1)) {
                return mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        System.out.println(missingNumber.missingNumber(new int[]{3, 0, 1})); // 2
        System.out.println(missingNumber.missingNumber(new int[]{0, 1})); // 2
        System.out.println(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8
    }
}
