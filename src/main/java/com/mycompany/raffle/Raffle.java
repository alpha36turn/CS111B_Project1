/* To do's
 * Fix error checking for min, max, and "enter your number"
 * Try test cases
*/

package CS111B_Project1.src.main.java.com.mycompany.raffle;
import java.util.*;

public class Raffle
{
    private final int NUM_WINNERS = 3;
    private int min;
    private int max;
    private boolean paramSet;
    private int[] winners = new int[NUM_WINNERS];
   // winnersSet is never used.

    public Raffle(int theMin, int theMax)
    {
    	Scanner sc = new Scanner(System.in);
    	final int MIN_NUM_TICKETS = 4;
        final int MIN_TICKET_NUMBER = 0;

    	min = theMin;
		while (min <= MIN_TICKET_NUMBER) {
			System.out.println("The number must be greater than 0.");
			min = Integer.parseInt(sc.nextLine());
		}
    	
    	max = theMax;
	    while (max-min < MIN_NUM_TICKETS) {
			max = Integer.parseInt(sc.nextLine());
			System.out.println("The highest number must be at least 4 greater than the lowest.");
		}
    	
    	paramSet = true;    
    } 

    public void draw()
    {
        if (!paramSet)
        {
            System.out.println("Run constructor to set Raffle parameters!");
            return;
        }
        Random rand = new Random();
        winners[0] = rand.nextInt(max - min + 1) + min; 
        winners[1] = rand.nextInt(max - min + 1) + min;
        winners[2] = rand.nextInt(max - min + 1) + min;

        while(winners[0] == winners[1] ||
                winners[0] == winners[2] ||
                winners[1] == winners[2])
        {
            winners[0] = rand.nextInt(max - min + 1) + min;
            winners[1] = rand.nextInt(max - min + 1) + min;
            winners[2] = rand.nextInt(max - min + 1) + min;
        }
        System.out.printf("Winner1: %d\nWinner2: %d\nWinner3: %d\n", winners[0], winners[1], winners[2]);
    }

    public void simulate()
    {
        System.out.print("Enter your ticket number: ");
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int entryNum = Integer.parseInt(sc.nextLine());

        if (entryNum == winners[0] || entryNum == winners[1] || entryNum == winners[2]) { 
            System.out.println("You won!"); 
            return;
        }

		int winner = rand.nextInt(max - min + 1) + min;
		int count = 1;
		
		while(entryNum != winner ) {
			winner = rand.nextInt(max - min + 1) + min;
			count++;
		}
        
        System.out.printf("You are not a winner.  Drawing one number at a time," + 
        " it took %d draws before winning.", count);
    }
}
