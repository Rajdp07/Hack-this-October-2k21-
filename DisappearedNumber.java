//Problem = for finding the disappeared numbers in an array. whose elements are {1,n}
import java.util.ArrayList;
import java.util.Arrays;

public class disapperedNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                nums.add(i+1);
            }
        }
        System.out.println(nums);

        ArrayList<Integer> ans = new ArrayList<>();
        if(ans.size() == 0){
            System.out.println("I am fool.");
        }
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            //arr[arr[i] - 1] = arr[correct index]
            if(arr[i] != arr[arr[i] - 1] && arr[i] <= arr.length){
                swapArray(arr,i,arr[i] - 1);
            }else {
                i++;
            }
        }
    }
    static void swapArray(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
