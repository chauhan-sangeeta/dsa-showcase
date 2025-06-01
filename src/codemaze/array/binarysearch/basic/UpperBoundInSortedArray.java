package codemaze.array.binarysearch.basic;

class UpperBoundInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        int target = 3;
        UpperBoundInSortedArray upperBoundInSortedArray = new UpperBoundInSortedArray();
        int result = upperBoundInSortedArray.upperBound(arr, target);
        System.out.println("Upper bound index: " + result);
    }

    // it can be classified as upper bound binary search and next greater element binary search
    // it returns the index of the smallest element that is greater than the target
    int upperBound(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
