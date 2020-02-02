import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main
{


    public static void main(String args[])
    {
        //make list of buttons to add
        ArrayList<Presser> presserList = new ArrayList<Presser>();
        //make the robot that presses buttons
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        //add your buttons
        presserList.add(new Presser(bot, KeyEvent.VK_2,12));


        //wait five seconds
        try { Thread.sleep(5000); }catch(Exception e){}

        //activate!
        long lastTime = System.nanoTime();
        while (true)
        {

            long thisTime = System.nanoTime();
            long deltaTime = thisTime-lastTime;
            lastTime = thisTime;

            for(Presser presObj: presserList)
            {
                presObj.increment(deltaTime);
            }
        }


    }
}
