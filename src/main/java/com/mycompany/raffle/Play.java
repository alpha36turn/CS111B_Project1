package CS111B_Project1.src.main.java.com.mycompany.raffle;
import java.util.*;

public class Play
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        char keepGoing = 'y';
        Raffle r = new Raffle();
       
            r.draw();
            r.simulate();
            
        while (keepGoing != 'n') {
            System.out.println("\nDo you want to keep playing? (y/n)"); 
            keepGoing = scan.nextLine().charAt(0);
			
            if(keepGoing == 'n') {
				System.out.println("Goodbye!");
				}	
            else  {
               r.draw();
               r.simulate();
            }
            	
       	}
    }
}
