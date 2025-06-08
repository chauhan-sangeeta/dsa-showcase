package dsa.array.slidingwindow.longest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*904. Fruit Into Baskets
        Solved
Medium
        Topics
conpanies icon
Companies
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
        Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].


Constraints:

        1 <= fruits.length <= 105
        0 <= fruits[i] < fruits.length*/
class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        FruitIntoBaskets solution = new FruitIntoBaskets();
        int result = solution.totalFruit(fruits);
        System.out.println("The maximum number of fruits that can be picked is: " + result);
    }
    // This class finds the maximum number of fruits that can be picked from a row of fruit trees
    // while adhering to the rules of having only two baskets, each holding a single type of fruit.
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int start =0;
        int max =0;
        for(int i=0;i<fruits.length;i++){
            map.put(fruits[i],i);
            if(map.size()>2){
                int lowestIndex = Collections.min(map.values());
                map.remove(fruits[lowestIndex]);
                start = lowestIndex+1;
            }
            max = Math.max(max, i-start+1);
        }
        return max;  
    }
}