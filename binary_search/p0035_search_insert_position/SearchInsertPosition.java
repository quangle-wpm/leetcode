package leetcode.binary_search.p0035_search_insert_position;

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 7)); // 4
    }
}