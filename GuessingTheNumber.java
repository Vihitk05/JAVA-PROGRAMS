import java.util.InputMismatchException;
import java.util.Scanner;


class GuessingTheNumber{
    public static void start()
    {
        int guess = 0;
        int number = 1 + (int)(10*Math.random());
        while (true)
        {    
            try
            {
            System.out.print("Enter your guess: ");     
            Scanner sc = new Scanner(System.in);
            guess = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Its not an integer!");
                continue;
            }
        
            if (guess == number)
            {
                System.out.println("You guessed the right number!");
                break;
                
            }
            else 
            {
                System.out.println("Wrong Guess!\nGuess the number between "+(number-5)+" and "+(number+5)+".");
            }
            
        } 
    }
    public static void main(String[] args) 
    {   
        start();
    }
}