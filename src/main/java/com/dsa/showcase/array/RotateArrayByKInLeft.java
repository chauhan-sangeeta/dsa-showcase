package com.dsa.showcase.array;

class RotateArrayByKInLeft {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2; // Number of steps to rotate
        RotateArrayByKInLeft rotateArray = new RotateArrayByKInLeft();
        rotateArray.rotate(arr, k);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public void rotate(int[] arr, int k) {
        int n=arr.length;
            k=k%n;
        rotate(arr,k,n-1);
        rotate(arr,0,k-1);
        rotate(arr,0,n-1);
    }
    public void rotate(int [] arr, int i, int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}