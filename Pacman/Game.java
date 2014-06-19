import java.util.*;
/**
 * Class Game
 * 
 * @author Whanata
 * @version 20:40 25/03/2014
 */
public class Game
{
    //Game's fields
    private Player player;
    private Dot dot1;
    private Dot dot2;
    private Dot dot3;
    private Exit exit;
    private Enemy enemy;
    private boolean advanced;

    //Constructor for objects of class Game
    Game(int xPosition,int yPosition)
    {
        // initialise instance variables
        player = new Player(xPosition,yPosition);
        dot1 = new Dot(1,1);
        dot2 = new Dot(2,2);
        dot3 = new Dot(3,3);
        exit = new Exit(4,4);
        enemy = new Enemy(5,5);
        if (xPosition == 5)
        {
            this.advanced = true;
        }
        else
        {
            this.advanced = false;
        }
    }

    public void advanceMode()
    {
        enemy.decision(player);
    }

    public void start()
    {
        do
        {
            System.out.println(this);
            
            this.input();
            if (this.advanced)
            {
                this.advanceMode();
            }
        }
        while (exit.check(player) && player.alive());

        System.out.println(this);

        System.out.println(player.end());
    }

    public void input()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Move (l/r/u/d): ");
        String movement = keyboard.nextLine(); 

        switch (movement.charAt(0))
        {
            case 'l': move(-1,0);
                break;

            case 'r': move(1,0);
                break;

            case 'u': move(0,-1);
                break;

            case 'd': move(0,1);
                break;

            default: System.out.println("Invalid move");
                break;
        }
    }

    //Player moves around by adding dx and dy to original position, Checks if player is on dot
    public void move(int dx,int dy)
    {   
        player.changePosition(dx,dy);
        dot1.check(player);
        dot2.check(player);
        dot3.check(player);
        exit.check(player);
    }
    
    //Return to string
    public String toString()
    {
        String normal = player + " " + dot1 + " " + dot2 + " " + dot3 + " " + exit;
        if (this.advanced)
        {
            return normal + " " + enemy;
        }
        else
        {
            return normal;
        }
    }
}
