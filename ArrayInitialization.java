public class ArrayInitialization {
  
    public static void main(String[] args) {
        
        //Array declaration
        String[] arrayOfStrings;
        //Array creation
        arrayOfStrings = new String[5];
        //Array Initialization
        arrayOfStrings [0] = "Canada";
        arrayOfStrings [1] = "London";
        arrayOfStrings [2] = "Ohio";
        arrayOfStrings [3] = "Nigeria";
        arrayOfStrings [4] = "Madrid";
        arrayOfStrings [5] = "Nigeria";
        arrayOfStrings [6] = "New Delhi";
        arrayOfStrings [7] = "Los Angeles";
        arrayOfStrings [8] = "Manchester";
      
        //Print the element of the array
        for (int i = 0; i < 9; i++) {
            System.out.println(arrayOfStrings[i]);
        }
    }
}
