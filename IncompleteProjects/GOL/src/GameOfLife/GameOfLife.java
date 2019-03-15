package GameOfLife;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 *
 * @author Kate Unitt
 */
public class GameOfLife extends JFrame
{
    JPanel world = new JPanel();
    DeadOrAlive buttons[] = new DeadOrAlive[150];
    
    public static void main (String args[]) 
    {
        new GameOfLife();
    
    } // end> public static void main (String args[])
    
    
    public GameOfLife() 
    {
        super("Game Of Life");
        
        /*
        Looks at the screensize and identifies these as pixel values
        */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        /* Get the height value of the screen size as an int
        To get this value as a double, use instead: screenSize.getHeight(); */
        int screenHeight = screenSize.height;
        
        /* Get the width value of the screen in pixel values as an int
        To get this value as a double, use instead: screenSize.getWidth(); */
        int screenWidth = screenSize.width;
        
        
        setSize(screenWidth, screenHeight - 40);
        setResizable(true);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
        /*
        IMPORTANT TO MAKE SURE THAT THE PROGRAM ACTUALLY CLOSES WHEN YOU CLOSE THE WINDOW
        */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        /*
        If you don't remember to set a layout in Swing, then it sets the default which is 'Flow Layout'
        GridLayout can be used without Swing because it's part of the awt class not the Swing class
        */
        world.setLayout(new GridLayout(10,15));
        
        
        for(int i = 0; i < 150; i++)
        {
            buttons[i] = new DeadOrAlive();
            world.add(buttons[i]);
                    
        } // end> for(int i = 0; i < 9; i++)
        
        add(world);
        
        setVisible(true);
    
    } // end> public GameOfLife()
    
    
} // end> public class GameOfLife
