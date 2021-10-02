class Solution {
    public int removeElement(int[] nums, int val) {
        int i,j=0,l=0;
        int k[]= new int[100];
        for(i=0;i<nums.length;i++)
        {
            if(val==nums[i])
            {
                l=l+1;}
            else
            {  k[j]=nums[i];
                j=j+1;
                
        }}
            for(i=0;i<j;i++)
                nums[i]=k[i];
        return j;
    }
}