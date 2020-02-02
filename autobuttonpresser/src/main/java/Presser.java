import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Presser
{
    private Robot bot;
    private int keyToPress;
    private long timeBetweenPresses;
    private long timeLeft;

    //timeBetweenPresses is in seconds
    public Presser(Robot bot, int keyToPress, double timeBetweenPresses)
    {
        this.bot = bot;

        this.keyToPress = keyToPress;
        this.timeBetweenPresses = (long)(timeBetweenPresses*1000000000l);
        timeLeft = this.timeBetweenPresses;
    }

    public void increment(long time)
    {
         timeLeft-=time;

         if(timeLeft <= 0)
         {
             System.out.println(timeLeft);
             timeLeft = timeBetweenPresses;

             bot.keyPress(keyToPress);
            bot.keyRelease(keyToPress);
         }
    }
}
