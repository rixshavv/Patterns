package DSA.Arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        nextPermutation(nums);

        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first index 'i' such that nums[i-1] < nums[i]
        int i = n - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        // Step 2: If such index found, find the element to swap with
        if (i > 0) {
            int j = n - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }

        // Step 3: Reverse the suffix starting at index 'i'
        reverse(nums, i, n - 1);
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
