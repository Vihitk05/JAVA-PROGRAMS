import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args)
    {
        int principal=0;
        while(true)
        {
            try{
            // Principal Amount
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Principal ($1000 - $1,000,000): ");
            principal = sc.nextInt();
            
            }
            catch(Exception e)
            {
                System.out.println("Enter a valid input!");
            }
        
            if (principal>=1000 && principal<=1000000)
            {
                break;
            }
            System.out.println("Enter the amount between 1000 and 1.000,000.");
            
        }
        // Annual Rate of Interest
        double raw_rate=0;

        while (true)
        {
            try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Annual Interest Rate: ");
            raw_rate = sc.nextDouble();
            
            }
            catch(Exception e)
            {
                System.out.println("Enter a valid input!");
            }
            if(raw_rate>=1 && raw_rate<=10)
            {
                break;
            }
            System.out.println("Enter the interest rate between 1 to 10.");
        }
        // Period in Years
        int raw_period=0;
        while(true)
        {
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Period(Years): ");
                raw_period = sc.nextInt();
                
                }
            catch(Exception e)
            {
                System.out.println("Enter a valid input!");
            }
            
            if (raw_period>=1 && raw_period<=30)
            {
                break;
            }
            System.out.println("Enter the period between 1 to 30.");
        }
        // Mobthly Rate of Interest
        double real_rate = (raw_rate/100)/12;

        // Years converted into Months
        int real_period = raw_period*12;
            

        //Calculation Part 1        
        double calc1 = (real_rate * Math.pow(1+real_rate, real_period));

        //Calcuation Part 2
        double calc2 = (Math.pow(1+real_rate, real_period)-1);

        // Merging Calculations 1 & 2
        double calc3_total = (calc1/calc2);

        //Getting the Mortgage amount
        double mortgage = principal * calc3_total;

        //Converting the mortgage value in Currency
        String mortString = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);

        //Output
        System.out.println("Mortgage: "+mortString);

        
        

    }   



    }   
    
