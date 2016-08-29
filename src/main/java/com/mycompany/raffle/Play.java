package CS111B_Project1.src.main.java.com.mycompany.raffle;
import java.util.*;

public class Play
{
    public static void main(String[] args)
    {
    	char keepGoing = 'y';
        Scanner scan = new Scanner(System.in);
    	
    	while (keepGoing != 'n') {
        
		System.out.println("Lowest ticket number: ");
		int min = Integer.parseInt(scan.nextLine());
	
		    
		System.out.println("Highest ticket number: ");
	        int max = Integer.parseInt(scan.nextLine());
	        
	        Raffle r = new Raffle(min, max);
		       r.draw();
		       r.simulate();	
		        
		System.out.println("\nDo you want to keep playing? (y/n)"); 
	        keepGoing = scan.nextLine().charAt(0);
				
	        if(keepGoing == 'n') {
				System.out.println("Goodbye!");
			}	        
    	}
    }
}
