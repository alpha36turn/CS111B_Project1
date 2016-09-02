package CS111B_Project1.src.main.java.com.mycompany.raffle;
import java.util.*;

public class Play
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        char cont = 'y';
        do {
            Raffle r = new Raffle();
            r.draw();
            r.simulate();
            System.out.println("Play again?");
            cont = sc.nextLine().charAt(0);
        } while (cont == 'y');
    }
}