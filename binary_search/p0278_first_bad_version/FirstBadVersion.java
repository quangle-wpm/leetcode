package leetcode.binary_search.p0278_first_bad_version;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isBadVersion = isBadVersion(mid);

            if (isBadVersion) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int x) {
        return x == 1;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();

        System.out.println(firstBadVersion.firstBadVersion(1)); // 1
    }
}
