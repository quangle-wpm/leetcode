package leetcode.binary_search.p0069_sqrt;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid > (long) x) {
                right = mid - 1;
            } else if (mid * mid == x) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();

        System.out.println(sqrt.mySqrt(4)); // 2
        System.out.println(sqrt.mySqrt(8)); // 2
    }
}
