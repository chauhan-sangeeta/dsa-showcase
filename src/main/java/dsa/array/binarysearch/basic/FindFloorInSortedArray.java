package dsa.array.binarysearch.basic;

class FindFloorInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        int target = 3;
        FindFloorInSortedArray findFloorInSortedArray = new FindFloorInSortedArray();
        int result = findFloorInSortedArray.findFloor(arr, target);
        System.out.println("Floor index: " + result);
    }
    //it can be classified as floor binary search
    // it returns the index of the largest element that is less than or equal to the target
    int findFloor(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {

                right = mid - 1;
            }
        }
        return ans;
    }
}
