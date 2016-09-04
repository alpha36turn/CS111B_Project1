package CS111B_Project1.src.main.java.com.mycompany.raffle;
import java.util.*;

public class Raffle
{
    private final int NUM_WINNERS = 3;
    private boolean paramSet = false;

    private int min;
    private int max;
    private int[] winners = new int[NUM_WINNERS];

    public Raffle()
    {
        final int MIN_NUM_TICKETS = 3;
        final int MIN_TICKET_NUMBER = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Lowest ticket number: ");
        min = -1;
        while(true) {
            min = sc.nextInt();
            if (min <= MIN_TICKET_NUMBER)
                System.out.println("Lowest ticket number must be positive! \n Enter the lowest number: ");
            else break;
        }

        System.out.println("Highest ticket number: ");
        while(true) {
            max = sc.nextInt();
            if (max - min + 1 < MIN_NUM_TICKETS)
                System.out.println("Must have at least 3 tickets! \n Enter the highest number: ");
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
        do {
            winners[0] = rand.nextInt(max - min + 1) + min;
            winners[1] = rand.nextInt(max - min + 1) + min;
            winners[2] = rand.nextInt(max - min + 1) + min;
        } while (winners[0] == winners[1] ||
                 winners[0] == winners[2] ||
                 winners[1] == winners[2]);
        System.out.printf("Winner1: %d\nWinner2: %d\nWinner3: %d\n", winners[0], winners[1], winners[2]);
    }

    public void simulate()
    {
        if (!paramSet)
        {
            System.out.println("Run constructor to set Raffle parameters!");
            return;
        }
        System.out.print("Enter your ticket number: ");
        Scanner sc = new Scanner(System.in);
        int entryNum = Integer.parseInt(sc.nextLine());

        while(entryNum < min || entryNum > max) {
            System.out.printf("Entry must be in the ticket range!!! [%d,%d]\nEnter your ticket number: \n", min, max);
            entryNum = Integer.parseInt(sc.nextLine());
        }

        if (entryNum == winners[0] || entryNum == winners[1] || entryNum == winners[2]) {
            System.out.println("You won!");
            return;
        }

        int count = 0;
        Random rand = new Random();
        while ((rand.nextInt(max - min + 1) + min) != entryNum) {
            count++;
        }
        System.out.printf("A simulated drawing says you would have had to play %d times before winning.\n", count);
    }
}
