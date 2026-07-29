import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];

            if (id1 == id2) {
                result.add(new int[]{id1, val1 + val2});
                i++;
                j++;
            } else if (id1 < id2) {
                result.add(new int[]{id1, val1});
                i++;
            } else {
                result.add(new int[]{id2, val2});
                j++;
            }
        }

        // Add remaining elements from nums1
        while (i < nums1.length) {
            result.add(nums1[i]);
            i++;
        }

        // Add remaining elements from nums2
        while (j < nums2.length) {
            result.add(nums2[j]);
            j++;
        }

        return result.toArray(new int[result.size()][]);
    }
}