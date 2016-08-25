package CS111B_Project1.src.main.java.com.mycompany.raffle;
import java.util.*;

public class Play
{
    public static void main(String[] args)
    {
        Raffle r = new Raffle();
        r.draw();
        r.simulate();
    }
}