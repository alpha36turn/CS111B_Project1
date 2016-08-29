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
        final int MIN_NUM_TICKETS = 3;
        final int MIN_TICKET_NUMBER = 0;

    	min = theMin;
	    while(true) {
	        if (min <= MIN_TICKET_NUMBER) {
	             System.out.println("Lowest ticket number greater than 0!");     
	        }
	        else break;
	    }
    	
    	max = theMax;
	    while(true) {
	        if (max-min < MIN_NUM_TICKETS) {
	            System.out.println("Must have at least 3 tickets!");
	        }
	        else break;
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
        winners[0] = rand.nextInt(max-min) + min; 
        winners[1] = rand.nextInt(max-min) + min;
        winners[2] = rand.nextInt(max-min) + min;

        while(winners[0] == winners[1] ||
                winners[0] == winners[2] ||
                winners[1] == winners[2])
        {
            winners[0] = rand.nextInt(max - min) + min;
            winners[1] = rand.nextInt(max - min) + min;
            winners[2] = rand.nextInt(max - min) + min;
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

		int winner = rand.nextInt(max-min) + min;
		int count = 1;
		
		while(entryNum != winner ) {
			winner = rand.nextInt(max-min) + min;
			count++;
		}
        
        System.out.printf("You are not a winner.  Drawing one number at a time," + 
        " it took %d draws before winning.", count);
    }
}
