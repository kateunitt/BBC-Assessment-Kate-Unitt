/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameOfLife;

/**
 *
 * @author Kate Unitt
 */
public class Cell 
{
    public int x,y;
    public boolean qalive;
    public Cell(int x, int y, boolean qalive) {
        this.x = x;
        this.y = y;
        this.qalive = qalive;
    }
    public void die() {
        qalive = false;
    }
    public void reborn() {
        qalive = true;
    }
    public void invert() {
        qalive = !qalive;
    }
}
