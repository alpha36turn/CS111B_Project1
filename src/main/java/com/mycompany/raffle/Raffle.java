package CS111B_Project1.src.main.java.com.mycompany.raffle;
import java.util.*;

public class Raffle
{
    private final int NUM_WINNERS = 3;
    private int min;
    private int max;
    private boolean paramSet;
    private int[] winners = new int[NUM_WINNERS];
    private boolean winnersSet;

    public Raffle()
    {
        final int MIN_NUM_TICKETS = 3;
        final int MIN_TICKET_NUMBER = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Lowest ticket number: ");
        min = -1;
        while(true) {
            min = sc.nextInt();
            if (min <= MIN_TICKET_NUMBER) System.out.println("Lowest ticket number must be positive!");
            else break;
        }

        System.out.println("Highest ticket number: ");
        while(true) {
            max = sc.nextInt();
            if (max-min < MIN_NUM_TICKETS) System.out.println("Must have at least 3 tickets!");
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
        winners[1] = rand.nextInt(max-min) + min;;
        winners[2] = rand.nextInt(max-min) + min;;

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
        int entryNum = Integer.parseInt(sc.nextLine());

        if (entryNum == winners[0] || entryNum == winners[1] || entryNum == winners[2]) {
            System.out.println("You won!");
            return;
        }

        int count = 0;
        while (entryNum != winners[0] && entryNum != winners[1] && entryNum != winners[2]) {
            count++;
            draw();
        }
        System.out.printf("A simulated drawing says you would have had to play %d times before winning.", count);
    }
}