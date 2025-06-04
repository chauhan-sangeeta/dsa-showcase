==========================
Binary Search: Bounds Guide
==========================

📌 Definitions:
---------------

🔹 Lower Bound:
- First index where the element is ≥ target.
- Think: "Where can I place this number without violating order?"
- Returns index of the first number >= target.

🔹 Upper Bound:
- First index where the element is > target.
- Think: "Where does this number stop appearing?"
- Returns index of the first number > target.

🔹 Floor:
- Largest number ≤ target.
- If target is 7, and array has 1, 3, 5, 6 → floor is 6.

🔹 Ceil:
- Smallest number ≥ target.
- If target is 7, and array has 8, 10 → ceil is 8.

