package dsa.array.binarysearch.answerspace;

/*1011. Capacity To Ship Packages Within D Days
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
        1st day: 1, 2, 3, 4, 5
        2nd day: 6, 7
        3rd day: 8
        4th day: 9
        5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
        Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
        1st day: 3, 2
        2nd day: 2, 4
        3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
        1st day: 1
        2nd day: 2
        3rd day: 3
        4th day: 1, 1


Constraints:

        1 <= days <= weights.length <= 5 * 104
        1 <= weights[i] <= 500*/
class ShippingPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        ShippingPackagesWithinDDays solution = new ShippingPackagesWithinDDays();
        int result = solution.shipWithinDays(weights, days);
        System.out.println("The least weight capacity of the ship is: " + result);
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = findMax(weights);// The minimum capacity must be at least the maximum weight of a single package
        int right = findTotal(weights);// The maximum capacity can be the total weight of all packages


        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getDays(weights, mid);
            if (count <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getDays(int[] weights, int capacity) {
        int day = 1;// Start with one day
        int totalWeight = 0;
        for (int weight : weights) {
            // If adding the current weight exceeds the capacity, we need to ship on a new day
            if (totalWeight + weight <= capacity) {
                totalWeight += weight;
            } else {
                day++;
                totalWeight = weight;
            }
        }
        return day;
    }

    private int findMax(int[] weights) {
        int max = weights[0];
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        return max;
    }

    private int findTotal(int[] weights) {
        int sum = weights[0];
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}