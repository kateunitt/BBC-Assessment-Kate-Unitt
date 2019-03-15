package GameOfLife;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // this is needed to 'listen out' for the buttons being pressed. 
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author Kate Unitt
 */
public class DeadOrAlive extends JButton implements ActionListener
{
    ImageIcon Dead, Alive;
    /*byte morbidityState = 0;  // we use byte because Boolean restricts us to only two values; even though it's the smallest number type available, byte allows us up to 256 values --- we only need 3 of them
    /*
    0:nothing
    1:Alive
    2:Dead
    */
    boolean morbidityState = false; // false is boolean default, so false = dead

    public DeadOrAlive() 
    {
        Alive = new ImageIcon(this.getClass().getResource("Alive.png"));
        Dead = new ImageIcon(this.getClass().getResource("Dead.png"));
        this.addActionListener(this);
    
    } // end> public DeadOrAlive()
    
    
    public void actionPerformed(ActionEvent e) 
    {
        morbidityState = true;
        switch(morbidityState) 
        {
            /* case 0:
                setIcon(null); // the setIcon command is pulled in to this class through the JButton import.
                break; // this is important for breaking the switch, because if we don't say break then it will keep moving on
               */ 
            case true:
                setIcon(Alive);
                
                break;
                
            case false:
                setIcon(Dead);
                break;
        
        }
    
    } // end> public void actionPerformed()
} // end> public class DeadOrAlive
