import java.util.*;
public class GuessingGame {
    public static void main(String[] args){
        int min =1 , max=1000;
        int chance =3;
        Scanner sc = new Scanner(System.in);
        int  ourNumber =  min + (int)(Math.random()*(max-min)+1); //ourNumber would be anything between 1 and 100;
        System.out.println("You Have 3 chances to guess the number  your number range is between 1 and 1000 . Number must be an integer");
        while (chance>0){
            chance--;
            int guessNo = sc.nextInt();
            sc.nextLine();
            boolean result = guessCheck(guessNo,ourNumber);
            if(result){
                System.out.println("Congrats you win the game by guessing correctly.");
                return ;
            }
            else{
                if(chance>1) {
                    System.out.println("You have " + chance + " more chances left out of 3");
                }
                if(chance ==1){
                    System.out.println("Final chance to guess the number");
                }
            }
        }
        System.out.println("The number was "+ ourNumber+ " Better Luck next time");
    }
    public static boolean guessCheck(Integer guessNo ,Integer ourNumber){
        return guessNo.equals(ourNumber);
    }
}
