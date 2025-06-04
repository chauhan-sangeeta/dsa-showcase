Binary Search on the Answer Space
=================================

Sometimes, we don't binary search an array directly — instead, we binary search over the **range of possible answers** to find a minimum or maximum valid value. These are known as:

1. Minimize the Maximum
2. Maximize the Minimum

---------------------------------------------------------
1. Minimize the Maximum (Minimization Problems)
---------------------------------------------------------

Goal:
-----
Find the smallest possible value `x` such that a condition is satisfied.

Example Problems:
-----------------
- Split Array Largest Sum
- Koko Eating Bananas
- Capacity to Ship Packages Within D Days

Binary Search Template:
-----------------------
int left = min_possible_value;
int right = max_possible_value;
int answer = -1;

while (left <= right) {
int mid = left + (right - left) / 2;

    if (condition(mid)) {
        answer = mid;       // Valid — try smaller
        right = mid - 1;
    } else {
        left = mid + 1;     // Invalid — try larger
    }
}
return answer;

Key Idea:
---------
- If mid is valid, search left → try to minimize the value
- Think: "Can I do this in *less*?"

---------------------------------------------------------
2. Maximize the Minimum (Maximization Problems)
---------------------------------------------------------

Goal:
-----
Find the largest possible value `x` such that the condition is still satisfied.

Example Problems:
-----------------
- Aggressive Cows
- Maximum Minimum Distance
- Allocate Minimum Number of Pages

Binary Search Template:
-----------------------
int left = min_possible_value;
int right = max_possible_value;
int answer = -1;

while (left <= right) {
int mid = left + (right - left) / 2;

    if (condition(mid)) {
        answer = mid;       // Valid — try larger
        left = mid + 1;
    } else {
        right = mid - 1;    // Invalid — try smaller
    }
}
return answer;

Key Idea:
---------
- If mid is valid, search right → try to maximize the value
- Think: "Can I do this in *more*?"

---------------------------------------------------------
Comparison Table
---------------------------------------------------------

| Feature               | Minimize the Maximum       | Maximize the Minimum       |
|-----------------------|----------------------------|-----------------------------|
| Goal                  | Smallest valid value       | Largest valid value         |
| If condition true     | Move right = mid - 1       | Move left = mid + 1         |
| Typical result        | First valid value          | Last valid value            |

---------------------------------------------------------
Memory Trick
---------------------------------------------------------
- Minimize → 💸 Try to spend as little as possible
- Maximize → 💰 Try to gain as much as possible
