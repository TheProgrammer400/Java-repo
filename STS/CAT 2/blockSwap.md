### Block Swap Algorithm (Array Rotation) 🔄

1. Split your array into **two blocks**:
    - Block A = first `k` elements
    - Block B = rest of the elements

2. **Swap blocks** or parts of blocks until Block A moves to the end.

3. Result = array rotated **left by `k` positions**.

---

### Example

```text
Array = [1,2,3,4,5,6,7], k = 2
Block A = [1,2], Block B = [3,4,5,6,7]

Step 1: Swap/shift → [3,4,5,6,7,1,2]
Done! ✅
