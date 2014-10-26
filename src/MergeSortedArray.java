/**
 * Given two sorted integer arrays A and B, 
 * merge B into A as one sorted array.
 */

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int indexM = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;
        
        while (indexA >= 0 && indexB >= 0) {
            if (B[indexB] >= A[indexA]) {
                A[indexM] = B[indexB];
                indexB--;
            } else {
                A[indexM] = A[indexA];
                indexA--;
            }
            indexM--;
        }
        
        while (indexB >= 0) {
            A[indexM] = B[indexB];
            indexM--;
            indexB--;
        }
    }
}
// Time complexity: O(m + n)