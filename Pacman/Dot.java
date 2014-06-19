
/**
 * Class Dot
 * 
 * @author Whanata
 * @version 20:40 25/03/2014
 */
public class Dot
{
    // Dot's field
    private int x;
    private int y;
    private boolean exists;

    //Constructor for objects of Class Dot
    Dot(int initialX,int initialY)
    {
        this.exists = true;
        this.x = initialX;
        this.y = initialY;
    }

    //The dot will disappear
    public void disappear()
    {
        this.exists = false;
    }
    
    public void check(Player player)
    {
        if (player.getX() == this.x && player.getY() == this.y && this.getExists())
        {
            player.collectDot();
            this.disappear();
        }
    }
    
    //Dot's state
    public boolean getExists()
    {
        return this.exists;
    }
    
    //Return to string
    public String toString()
    {   
        if (exists)
        {
            return "Dot(" + this.x + "," + this.y +")";
        }
        else
        {
            return "Dot(-,-)";            
        }
    }
}
