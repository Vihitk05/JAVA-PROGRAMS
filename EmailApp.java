import java.security.SecureRandom;
import java.util.Scanner;


public class EmailApp {

    static String default_password;
    static String company = "Microsoft";
    static String first_name;
    static String last_name;
    static String department;

    public static String generate_password()
    {
        int length=6;
        String set_password = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*abcdefghi";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i =0;i<=length;i++)
        {
            int random_index = random.nextInt(set_password.length());
            sb.append(set_password.charAt(random_index));
        }
        default_password = sb.toString();
        System.out.println("==========================================================================");
        System.out.println("\n");
        System.out.println("Your Password: "+default_password);
        System.out.println("\n");
        System.out.println("==========================================================================");
        return default_password;
    }
    public static void create_email()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================================================");
        System.out.println("\n");
        System.out.println("Enter your First name: ");
        first_name = sc.next().toLowerCase();
        
        System.out.println("Enter your Last name:");
        last_name = sc.next().toLowerCase();
        
        System.out.println("Enter your Department: ");
        department = sc.next().toLowerCase();
        System.out.println("\n");
        System.out.println("==========================================================================");    
    }

    public static void change_password()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Do you want to change the default password?[Y?N] ");
        String answer_raw = in.nextLine().toUpperCase();
        char answer = answer_raw.charAt(0);
        if (answer=='Y')
        {
            while(true)
            {
            System.out.println(default_password);
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Enter your default password: ");
            String previous_password = in.next();

            if(previous_password.equalsIgnoreCase(default_password))
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("\nIf you fail to enter the correct password second time then you have to start the process again by entering the default password.");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Enter your new password: ");
                Scanner input = new Scanner(System.in);
                String new_password = input.nextLine();
                if(new_password.length()<=10 && new_password.length()>=1)
                {
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Confirm your new password: ");
                    String confirm_password = input.nextLine();
                    if(confirm_password.equalsIgnoreCase(new_password))
                    {
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("You have successfully changed your password.");
                        default_password = confirm_password;
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("Your new Password is: "+default_password);
                        System.out.println("--------------------------------------------------------------------------");
                        break;
                    }
                    else
                    {
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("The passwords do not match.");
                        System.out.println("--------------------------------------------------------------------------");
                    }
                }
                else
                {
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("The passwords length should not be more than 10 and less than 1.");
                    System.out.println("--------------------------------------------------------------------------");
                }
            }
            else
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("The Password is incorrect.");
                System.out.println("--------------------------------------------------------------------------");
            }
        }
        }
        else if(answer=='N')
        {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Okay! You can change it anytime you want!");
            System.out.println("--------------------------------------------------------------------------");
        }
        else
        {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Enter a valid answer[Y/N].");
            System.out.println("--------------------------------------------------------------------------");
        }
    }
    
      

    public static void main(String[] args) 
    {
        create_email();
        System.out.println("\n\n");
        generate_password();
        System.out.println("\n\n");
        change_password();
        System.out.println("\n\n");
        int mail_box_capacity = 500;
        System.out.println("==========================================================================");
        System.out.println("\n");
        System.out.println("Company Name: "+company.toUpperCase());
        System.out.println("Employee Name: "+first_name.toUpperCase()+" "+last_name.toUpperCase());
        System.out.println("Employee Department: "+department.toUpperCase());
        System.out.println("Employee Email: "+first_name+"."+last_name+"@"+department+"."+company.toLowerCase()+".com");
        System.out.println("Employee Mail Box Capacity: "+mail_box_capacity);
        System.out.println("\n");
        System.out.println("==========================================================================");
    }   
    
}
