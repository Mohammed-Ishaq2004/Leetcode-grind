class Solution {//nikhil lohia vid
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] smaller;
        int[] larger;

        if(nums1.length>nums2.length){
            smaller = nums2;
            larger = nums1;
        } else{
            smaller = nums1;
            larger = nums2;
        }

        int totalLength=nums1.length + nums2.length;

        int low=0;
        int high=smaller.length;

        while(low<=high){
            int partitionX=(low+high)/2;
            int partitionY=(totalLength+1)/2-partitionX;//leftover spots to fill left side of median 
            //4 boundariesl1,l2,r1,r4
            int l1=(partitionX==0)?Integer.MIN_VALUE : smaller[partitionX-1];
            int l2=(partitionY==0)?Integer.MIN_VALUE : larger[partitionY-1];
            int r1=(partitionX==smaller.length)?Integer.MAX_VALUE : smaller[partitionX];
            int r2=(partitionY==larger.length)?Integer.MAX_VALUE : larger[partitionY];
            //check boundary conditions to ensure partition is valid
            if(l1<=r2&&l2<=r1){ 
                if(totalLength%2==0)/*even array*/ {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                } else{
                    return Math.max(l1,l2);
                }
            } else if(l1>r2){//partition is too far right move left
            /* median is not valid, boundaries are not satisfying sorted order conditions*/ 
            high = partitionX-1;
            } else/*partition is too left move right*/{
                low=partitionX+1;
            }

        }
        return 0.0;
    }
}