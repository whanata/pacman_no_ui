import java.util.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main (String [] args)
    {
        initial();
    }

    public static void initial()
    {
        int x = loop("Initial x: ");
        int y = loop("Initial y: ");
        Game game = new Game(x,y);
        game.start();
    }
   
    public static int loop(String initial)
    {
        int i;
        int position;
        for (i = 1; i <= 3; i++)
        {
            position = prompt(initial); 
            if (position >= 0)
            {
                return position; 
            }
            else
            {
                notNegative();
                
            }
        }
        error();
        System.exit(0);
        return 0;
    }

    public static int prompt(String initial)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(initial);
        int answer = keyboard.nextInt(); keyboard.nextLine();
        return answer;

    }    

    public static void notNegative()
    {
        System.out.println("Must not be negative.");
    }

    public static void error()
    {
        System.out.println("Too many errors. Exiting.");
    }
}

