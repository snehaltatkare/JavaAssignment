import java.util.Scanner;

public class menu{
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        
        
        String choice = "y";
        while(choice.equals("y")){
            System.out.print("Enter the Number: ");
            int num = s1.nextInt();
        if (num % 2==0){
            System.out.println("Even Number");
        }
        else {
            System.out.println("Odd Number");
        }
            System.out.print("Do you want to Continue: ");
            choice = s1.next();

        // if (choice.equals("n")){
        //     break;
        // }           
    }
        s1.close();

    }
}