
/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit
{
    private int x;
    private int y;
    private boolean open;

    Exit(int initialX, int initialY)
    {
        this.x = initialX;
        this.y = initialY;
        this.open = false;
    }
    
    public boolean check(Player player)
    {
        if (player.getX() == this.x && player.getY() == this.y && player.allDots())
        {
            this.open = true;
            return false;
            
        }
        else
        {
            return true;
        }
    }
    
    public String toString()
    {
        if (this.open == false)
        {
            return "Exit(" + this.x + ","+ this.y + ")";
        }
        else
        {
            return "Exit(-,-)";
        }
    }
}
