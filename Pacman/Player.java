
/**
 * Player Class
 * 
 * @author Whanata
 * @version 20:41 25/03/2014
 */
public class Player
{
    //Player's fields
    private int x;
    private int y;
    private int collectedDots;
    private boolean life;

    //Constructor for objects of class Player
    Player(int initialX,int initialY)
    {
        collectedDots = 0;
        this.x = initialX;
        this.y = initialY;
        this.life = true;       
    }   

    public boolean alive()
    {
        return this.life;
    }

    public void died()
    {
        this.life = false;
    }
            
    //Player changing position 
    public void changePosition(int changeX,int changeY)
    {
        this.x += changeX;
        this.y += changeY;
    }

    //Player's x position    
    public int getX()
    {
        return this.x;
    }

    //Player's y position
    public int getY()
    {
        return this.y;
    }
    
    public String end()
    {
        if (this.life)
        {
            return "You win!";
        }
        else
        {
            return "You lose!";
        }                   
    }
    
    //Increase collectedDots by 1
    public void collectDot()
    {
        collectedDots++;
    }

    public boolean allDots()
    {
        return (collectedDots == 3);
    }
    
    public String dots()
    {
        int i;
        String star = "";
        for (i = 0; i < collectedDots; i++)
        {
            star += "*";           
        }
        return star;
    }

    //Return to string  
    public String toString()
    {
        String dots = "Player[" + this.dots() + "](";
        if (this.life)
        {
            return dots + this.x + "," + this.y + ")";
        }
        else
        {
            return dots + "-,-)";
        }
    }
}
