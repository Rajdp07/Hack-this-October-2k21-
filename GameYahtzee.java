public class GameYahtzee {
    private static int rollDice() {
        int sides = 6;
        //generates pseudoRandom numbers between 0 and less than 1
        double randomNumber = Math.random();
        //Shift values of randomNumber
        randomNumber = 1 + randomNumber * sides;
        return (int) randomNumber;
    }

    //gets the number of times we rolled the dice using rollDice() function
    private static int keepRolling() {
        int dice1 = rollDice();
        int dice2 = rollDice();
        int dice3 = rollDice();
        int dice4 = rollDice();
        int dice5 = rollDice();
        int count = 1;
        while (!(dice1 == dice2 && dice2 == dice3 &&
                dice3 == dice4 && dice4 == dice5)) {
            //we need to re-roll
            dice1 = rollDice();
            dice2 = rollDice();
            dice3 = rollDice();
            dice4 = rollDice();
            dice5 = rollDice();
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print("-->You win the game of yahtzee when the face of the five dice are equal\n" +
                "The number of times rolled to get this is: ");
        System.out.println(keepRolling());
    }
}
