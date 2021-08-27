import java.util.Random;
import java.util.Scanner;

public class AdventureGame
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Random rand = new Random();

        String[] enemies = {"Skeleton","Vampire","Assassin","BigFoot"};
        int enemy_max_health = 75;
        int enemy_attack_damage = 10;

        int player_health = 100;
        int attack_damage = 50;
        int number_of_potions = 4;
        int health_potion_heal_amount = 30;
        int potion_health_drop = 50; // percentage


        boolean running = true;
        System.out.println("\t\tWELCOME TO DUNGEON!");

        GAME: 
        while (running) 
        {
            System.out.println("---------------------------------------------------------------");    
            int enemy_health = rand.nextInt(enemy_max_health);
            String enemy = enemies[rand.nextInt(enemies.length)];

            System.out.println("\n\n\t\t# "+enemy+" has appeared! #");
            while(enemy_health>0)
            {
                System.out.println("Your HP: "+player_health);
                System.out.println(enemy+"'s HP: "+enemy_health);
                System.out.println("What do you want to do? ");
                System.out.println("1.Attack");
                System.out.println("2.Drink Health Potion");
                System.out.println("3.Run");
                System.out.println("Enter your move: ");
                String input = sc.nextLine();
                if(input.equals("1"))
                {
                    int damage_dealt = rand.nextInt(attack_damage);
                    int damage_taken = rand.nextInt(enemy_attack_damage);

                    enemy_health-=damage_dealt;
                    player_health-=damage_taken;

                    System.out.println("You have strike the "+enemy+ " for "+damage_dealt+" damage.");
                    System.out.println("You recieve "+damage_taken+" in retaliation.");
                    if(player_health<1)
                    {
                        System.out.println("You have taken too much damage!\nYou are too weak to go on!");
                        break;
                    }
                }
                else if(input.equals("2"))
                {
                    if(number_of_potions>0)
                    {
                        player_health+=health_potion_heal_amount;
                        number_of_potions-=1;
                        System.out.println("You drank a health potion.\nYour HP: "+player_health+".\nYou have "+number_of_potions+" with you!.");
                    }
                    else
                    {
                        System.out.println("You have 0 potions left!\nDefeat the enemy in order to get a chance to gain potion!");
                    }
                }
                else if(input.equals("3"))
                {
                    System.out.println("You ran away from the "+enemy+"!");
                    continue GAME;
                }
                else
                {
                    System.out.println("INVALID INPUT!");
                }
            }
            if(player_health<1)
            {
                System.out.println("You limp of the dungeon!\nYou are weak for the battle!");
                break;
            }
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("\n\t\t# "+enemy+" was defeated! #");
            System.out.println("You have "+player_health+ "HP left.");
            if(rand.nextInt(100)>potion_health_drop)
            {
                number_of_potions+=1;
                System.out.println("The "+enemy+" dropped the health potion!");
                System.out.println("You have "+number_of_potions+" with you!");
            }
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1.Continue Fighting");
            System.out.println("2.Exit");
            System.out.println("Enter your move: ");
            String input = sc.nextLine();
            while(!input.equals("1") && !input.equals("2"))
            {
                System.out.println("Invalid Command!");
                input = sc.nextLine();
            }
            if(input.equals("1"))
            {
                System.out.println("You continue on your adventure.");
            }
            else if(input.equals("2"))
            {
                System.out.println("You exit successfully from the dungeon!");
                break;
            }

        }


    }
}