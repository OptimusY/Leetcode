/**
 * Given an array with n objects colored red, white or blue,.
 * Sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent 
 * the color red, white, and blue respectively.
 * --------Note--------
 * You are not supposed to use the library's sort function.
 */


// Method 1: One pass of the array
public class Solution {
    public void sortColors(int[] A) {
        if (A.length <= 1) return ;
        
        int prev = 0, post = A.length - 1;
        int i = 0;
        
        while (i <= post) {
            if (A[i] == 1) {
                i++;
            } else if (A[i] == 0) {
                swap(prev, i, A);
                i++;
                prev++;
            } else {
                swap(i, post, A);
                post--;     // Note: i is not updated here!
            }
        }
    }
    
    public void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
}


// Method 2: Two pass of the array
public class Solution {
    public void sortColors(int[] A) {
        if (A.length <= 1) return ;
        int red = 0;
        int white = 0;
        int blue = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) red++;
            if (A[i] == 1) white++;
            if (A[i] == 2) blue++;
        }
        
        for (int i = 0; i < A.length; i++) {
            if (red > 0) {
                A[i] = 0;
                red--;
            } else if (white > 0) {
                A[i] = 1;
                white--;
            } else {
                A[i] = 2;
                blue--;
            }
        }
    }
}
