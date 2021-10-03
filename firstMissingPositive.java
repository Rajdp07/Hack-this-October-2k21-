class Solution {
    public int firstMissingPositive(int[] nums) {
        int k=0,j=0,i,n=nums.length;
        boolean l=false;
       for(i=0;i<n;i++)
       {
        if(k<nums[i]) 
            k=nums[i];
           if(j>nums[i])
               j=nums[i];
       }
        for(i=1;i<=k;i++)
        {
            l=search(nums,i);
            if(l==false && i>0)
                break;}
            return i;
    }
    public boolean search(int[] nums,int n)
    {int i,j;
     boolean t=false;
        for(i=0;i<nums.length;i++)
        {
           if(nums[i]==n)
               t=true;
        }
     return t;
}
}
