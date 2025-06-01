package codemaze.array.binarysearch.basic;

class LowerBoundInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        int target = 3;
        LowerBoundInSortedArray lowerBoundInSortedArray = new LowerBoundInSortedArray();
        int result = lowerBoundInSortedArray.lowerBound(arr, target);
        System.out.println("Lower bound index: " + result);
    }

    //it can be classified as lower bound binary search and ceiling binary search
    // it returns the index of the smallest element that is greater than or equal to the target
    int lowerBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
