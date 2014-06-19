
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy
{
    private int x;
    private int y;
    private String direction;

    Enemy(int initialX,int initialY)
    {
        x = initialX;
        y = initialY;
        direction = "neutral";
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }    

    public void movement()
    {
        if (direction == "right")
        {
            this.x++;

        }
        else if (direction == "left")
        {
            this.x--;

        }
        else if (direction == "down")
        {
            this.y++;

        }
        else if (direction == "up")
        {
            this.y--;

        }

    }    
    
    public int distance(int player, int enemy)
    {
        return player - enemy;
    }
    
    public void decision(Player player)
    {            
        int playerX = player.getX();
        int playerY = player.getY();        
        int xDistance = distance(playerX,this.x);
        int yDistance = distance(playerY,this.y);
        boolean rightDistance = this.absDecision(xDistance - 1,xDistance);
        boolean leftDistance = this.absDecision(xDistance + 1,xDistance);
        boolean downDistance = this.absDecision(yDistance - 1,yDistance);
        boolean upDistance = this.absDecision(yDistance + 1,yDistance);
        if (direction == "right" && rightDistance || direction == "left" && leftDistance || direction == "down" && downDistance || direction == "up" && upDistance || direction == "neutral")
        {
            this.decisionMaking(xDistance,yDistance);
        }
        
        this.movement();
        if (this.check(playerX,playerY))
        {
            player.died();
        }
    }
    
    public boolean check(int playerX,int playerY)
    {
        return distance(playerX,this.x) == 0 && distance(playerY,this.y) == 0;
    }
    
    public boolean absDecision(int a,int b)
    {
        return Math.abs(a) > Math.abs(b);
    }
    
    public void decisionMaking(int xDistance,int yDistance)
    {
        if (this.absDecision(xDistance,yDistance))
        {           
            if (xDistance > 0)
            {                
                direction = "right";
            }
            else
            {
                direction = "left";

            }
        }
        else if (this.absDecision(yDistance,xDistance))
        {
            if (yDistance > 0)
            {
                direction = "down";
            }
            else
            {
                direction = "up";

            }
        }
        else
        {
            direction = "neutral";
        }
    }
    
    public String toString()
    {
        return "Enemy(" + this.x + "," + this.y + ")";
    }
}
