import java.util.HashMap;

import java.util.Scanner;

public class RPS
{
    static int human_choice;
    static int computer_choice;
    static byte human_score;
    static byte computer_score;

    public static void human_and_computer_input()
    {
        int human_move=0;
        while(true)
        { 
            try
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n\n==========================================================================");
                System.out.print("Enter your move[0:ROCK,1:PAPER,2:SCISSORS]: ");
                human_move = sc.nextInt();
                System.out.println("--------------------------------------------------------------------------");
                if(human_move==0||human_move==1||human_move==2)
                {
                    human_choice=human_move;
                    computer_choice = (byte)(3* Math.random());
                    break;
                }
                else
                {
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Your moves should be 0,1 or 2.");
                    System.out.println("--------------------------------------------------------------------------");
                }
            }
            
            catch(Exception e)
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Enter a number!");
                System.out.println("--------------------------------------------------------------------------");
            }
           
                
        }
    }
    public static void play_rps()
    {   
        while(true)
        {
            human_and_computer_input();
            HashMap<Integer, String> hmap = new HashMap<Integer, String>();
            hmap.put(0, "ROCK");
            hmap.put(1, "PAPER");
            hmap.put(2, "SCISSORS");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("YOUR MOVE: "+hmap.get(human_choice));
            System.out.println("COMPUTER MOVE: "+hmap.get(computer_choice));
            System.out.println("--------------------------------------------------------------------------");
            if((human_choice-computer_choice)%3==1)
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("You won this Turn!");
                System.out.println("--------------------------------------------------------------------------");
                human_score+=1;
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Your Score: "+human_score);
                System.out.println("Computer Score: "+computer_score);
                System.out.println("==========================================================================");
                if(human_score==3)
                {
                    System.out.println("==========================================================================");
                    System.out.println("You won this Round!!!");
                    System.out.println("==========================================================================");
                    replay();
                    break;
                }   
            }
            else if(human_choice==computer_choice)
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Tie!");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("\n--------------------------------------------------------------------------");
                System.out.println("Your Score: "+human_score);
                System.out.println("Computer Score: "+computer_score);
                System.out.println("==========================================================================");
            }
            else
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Computer won this Turn!");
                System.out.println("--------------------------------------------------------------------------");
                computer_score+=1;
                System.out.println("\n--------------------------------------------------------------------------");
                System.out.println("Your Score: "+human_score);
                System.out.println("Computer Score: "+computer_score);
                System.out.println("==========================================================================");
                if(computer_score==3)
                {
                    System.out.println("==========================================================================");
                    System.out.println("Computer won this Round!!!");
                    System.out.println("==========================================================================");
                    replay();
                    break;
                }
                
                
            }
        }
    }
    public static void replay() 
    {
        while(true)
        {
            Scanner in  = new Scanner(System.in);
            System.out.println("Do you want to play again?[Y/N] ");
            String user_reply = in.next().toUpperCase();
            if(user_reply.equalsIgnoreCase("Y"))
            {
                System.out.println("Welcome Back!");
                human_score=0;
                computer_score=0;
                play_rps();
                break;
            }
            else if(user_reply.equalsIgnoreCase("N"))
            {
                System.out.println("Thankyou!");
                break;
            }
            else
            {
                System.out.println("Enter a valid Answer[Y/N]!");
            }
        }
    }
    public static void main(String[] args) 
    {
        play_rps();
    }
}