import java.util.Scanner;

public class BankingApplication
{
    static int balance;
    static int previous_transaction;
    
    public static void check_balance()
    {
        System.out.println("===================================================================");
        System.out.println("You have Rs."+balance+" in your account.");
        System.out.println("===================================================================");
    }
    public static void deposit()
    {
        
        int amount=0;
        while(true)
        {
        
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("===================================================================");
            System.out.print("Enter the amount to be deposited: ");
            amount = sc.nextInt();
            System.out.println("===================================================================");
        }
        catch(Exception e)
        {
            System.out.println("Enter a positive number.");
        }
        if (amount>0 && amount<=1_000_000)
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("You have Deposited Rs."+amount+" in your account.");
            System.out.println("---------------------------------------------------------------");
            balance +=amount;
            previous_transaction = amount;
            break;
        }
        else
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Your amount deposition value is from Rs.1 to Rs.1,000,000.");
            System.out.println("---------------------------------------------------------------");
        }
        }  
    }
    public static void withdraw()
    {
        
        while (true)
        {
            int amount = 0;
            try
            {
                System.out.println("===================================================================");
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the amount you want to withdraw: ");
                amount = sc.nextInt();
                System.out.println("===================================================================");
            }
            catch(Exception e)
            {
                System.out.println("Enter a number.");
            }
            if(amount>0 && amount<=1_000_000)
            {
                if (balance == 0 || balance<amount)
                {
                    System.out.println("You don't have money in your account!");
                    System.out.println("Your account balance is Rs."+balance+".");
                }
                else
                {
                    System.out.println("===================================================================");
                    System.out.println("You have withdrawn Rs."+amount+" from your account.");
                    balance-=amount;
                    System.out.println("Your account balance is Rs."+balance+".");
                    System.out.println("===================================================================");
                    previous_transaction = -amount;
                    break;
                }    
            }
            else
            {
                System.out.println("---------------------------------------------------------------");
                System.out.println("Your amount withdraw value is from Rs.1 to Rs.1,000,000.");
                System.out.println("---------------------------------------------------------------");
            }
        }
    }
    public static void previous_transaction_amount()
    {
        if(previous_transaction>0)
        {
            System.out.println("You had deposited Rs."+previous_transaction+" in your previous transaction.");
        }
        else if(previous_transaction<0)
        {
            System.out.println("You had withdrawn Rs."+Math.abs(previous_transaction)+" in your previous transaction.");
        }
        else
        {
            System.out.println("You didn't do any transactions before.");
        }
    }
    
    public static void show_menu() 
    {
        
        String cust_name;
        long cust_id;
       
        Scanner sc = new Scanner(System.in);
            
                
        System.out.println("===================================================================");
        
        System.out.print("Enter your name: ");
        cust_name = sc.nextLine();
        
      
        System.out.print("Enter your Account Number: ");
        cust_id = sc.nextLong();    
        System.out.println("===================================================================");
        
        System.out.println("===================================================================");
        System.out.println("Welcome "+cust_name+"!");
        System.out.println("Your Account Number: "+cust_id);
        System.out.println("===================================================================");

        
        System.out.println("What do you want to do?");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Previous Transaction");
        System.out.println("5. Exit");
        byte operation=0;
        while(true)
        {
           
            try{
                System.out.println("\n\n\n\n\n\n");
                Scanner op = new Scanner(System.in);
                System.out.print("Enter the operation number you want to do: ");
                operation = op.nextByte();
            }
            catch(Exception e)
            {
                System.out.println("Enter a number between 1 and 5.");
            }
            if(operation==1)
            {
                
                check_balance();
            }
            else if(operation==2)
            {
                
                deposit();
            }
            else if(operation==3)
            {
               
                withdraw();
            }
            else if(operation==4)
            {
                
                previous_transaction_amount();
            }
            else if(operation==5)
            {
                System.out.println("\n\n\n\n\n\n");
                System.out.println("===================================================================");
                System.out.println("Thankyou " +cust_name+"!Do visit again.");
                System.out.println("===================================================================");
                break;
            }
            else
            {
                System.out.println("Enter a valid operation number between 1 and 5.");
            }
        
        

        }

    }
    public static void main(String[] args)
    {
        show_menu(); 
    }
}