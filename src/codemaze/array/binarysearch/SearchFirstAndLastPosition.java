package codemaze.array.binarysearch;

class SearchFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);

        if(first==-1){
            return new int[]{-1,-1};
        }
        int last = findLast(nums,target);
        return new int[]{first,last};
    }
    public int findFirst(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int first=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                first=mid;
                right=mid-1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return first;
    }
    public int findLast(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int last=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                last=mid;
                left=mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return last;
    }
}