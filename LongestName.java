/*
A program to find the longest name in an array of strings
*/
public class LongestName {
  
    public static void main(String[] args) {
      
        LongestName test = new LongestName();
        System.out.println(test.findLongestName(new String[]{"Chinedu", "Manuel", "Micheal", "Emmanuel", "Halima Abubakar"}));
    }

    public String findLongestName(String[] name) {
        int length = name.length;
        String longestName = name[0];
        for (int i = 1; i < length; i++) {
            if (name[i].length() > longestName.length()) {
                longestName = name[i];
            }
        }
        return longestName;
    }
}
