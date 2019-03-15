package gameoflife;

/**
 * @author Kate Unitt
 */

public class GameOfLife 
{
    public static void main(String[] args)
    {
        int Row = 20, Column = 15; 
        
        /** --------------------------------------------------------------------
         * CREATE ENVIRONMENT: Create a multi-dimensional array to act
         * as a grid.
         * This is pre-populated with 0's and 1's to designate an
         * initial seed.
         ---------------------------------------------------------------------*/
	
        int[][] grid =
        {
            { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, }, 
            { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, }, 
            { 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, }, 
            { 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, }, 
            { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, }, 
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, }, 
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, } 
	}; // end> grid
        
        /** --------------------------------------------------------------------
         * DISPLAY ENVIRONMENT:
         *  Display the 'grid' created above in the console output.
         ---------------------------------------------------------------------*/
        
        /** This creates the title that appears above the first
         * Environment output */
        System.out.println("Game of Life --- displaying Blinkers, Toads and "
                + "Beacons:" + "\n"); 
        
        /** This creates the title that appears above the first
         * Environment output */
        System.out.println("Initial Generation"); 
                
	/** Start with rowGen as 0 and increment it by +1 until it 
         * reaches the total number of Rows */
        for (int rowGen1 = 0; rowGen1 < Row; rowGen1++)
        {
        
            /** Start with incCol as 0 and increment it by +1 until it
             * reaches the total number of Columns */
            for (int incColGen1 = 0; incColGen1 < Column; incColGen1++)
            {
                /** If grid cell is 0, mark as dead [   ] */
                if (grid[rowGen1][incColGen1] == 0) 
					System.out.print("[" + "   " + "]");
                
                /** If grid cell is 1, mark as alive [ = ] */
                else
					System.out.print("[" + " = " + "]"); 
            } // end> for (int ...) 
            
            System.out.println(); 
        
        } // end> for (int ...) 
        
        System.out.println(); 
        
        secondGeneration(grid, Row, Column); 
    
    } // end> public static void main (...)
    
    /** ------------------------------------------------------------------------
     * GIVE LIFE TO NEXT GENERATION :
     * Using the Environment created in the OriginalGeneration, for each
     * cell: check all Neighbouring cells to count how many Neighbours are
     * alive, then remove the originating cell from the count.
     * 
     * RULE 1: If a cell has less than 2 Neighbours = UNDERPOPULATION: Dead
     * RULE 2: If a cell has 2 or 3 Neighbours = SURVIVAL: Alive
     * RULE 3: If a cell has more than 3 Neighbours = OVERCROWDED: Dead
     * RULE 4: If an empty cell/previously dead cell has 3 Neighbours = NEW
     *         LIFE CREATED.
     -------------------------------------------------------------------------*/
    
    static void secondGeneration(int grid[][], int rowGen2a, int colGen2a)
    {
        int[][] future = new int[rowGen2a][colGen2a]; 
        
        /** Check by looping through all cells to get their current
         * state. 0 = Dead; 1 = Alive.
         */
        
        for (int rowGen2b = 1; rowGen2b < rowGen2a - 1; rowGen2b++) 
        {
            for (int colGen2b = 1; colGen2b < colGen2a - 1; colGen2b++) 
            {
                /** Check Neighbouring cells and count the
                 * number of Neighbours in an Alive state.
                 */
                
                int aliveNeighbours = 0; 
                
                for (int rowGen1 = -1; rowGen1 <= 1; rowGen1++) 
                    for (int incColGen1 = -1; incColGen1 <= 1; incColGen1++) 
                            aliveNeighbours += grid[rowGen2b + rowGen1]
                            [colGen2b + incColGen1]; 
                
                /** Subtract the originating cell from the
                 * number of aliveNeighbours as this has been
                 * counted too.
                 */
                
                aliveNeighbours -= grid[rowGen2b][colGen2b]; 
                
                /**-------------------------------------------------------------
                 * IMPLEMENTATION OF THE GAME OF LIFE RULES
                 -------------------------------------------------------------*/
                
                /** IMPLEMENT RULES 1 AND 3:
                 * <<<FOR DEBUGGING:
                 * Set the below line to check (aliveNeighbours < 2))
                 * to check only Rule 1 (UNDERPOPULATION).>>>
                 */
                if ((grid[rowGen2b][colGen2b] == 1) && (aliveNeighbours < 2) 
                        /* || (aliveNeighbours > 3)*/ )
                            future[rowGen2b][colGen2b] = 0; 
                
                /** <<<FOR DEBUGGING - RULE 3:
                 * Uncomment else if containing (aliveNeighbours > 3))
                 * to check only Rule 3 (OVERPOPULATION).>>>
                 */
                else if ((grid[rowGen2b][colGen2b] == 1) && 
                        (aliveNeighbours > 3)) 
                            future[rowGen2b][colGen2b] = 0;
                
                /** IMPLEMENT RULE 4:
                 * Create new life in dead/empty cell where alive Neighbouring 
                 * cells are equal to 3.
                 */
                else if ((grid[rowGen2b][colGen2b] == 0) && 
                        (aliveNeighbours == 3)) 
                            future[rowGen2b][colGen2b] = 1; 
                
                /** IMPLEMENT RULE 2:
                 * If cell does not meet above, implying that an alive cell has 
                 * 2 or 3 Neighbours, the cell remains alive.
                 */
                else 
                            future[rowGen2b][colGen2b] = 
                                    grid[rowGen2b][colGen2b];
            
            } // end> for (int ...)
        
        } // end> for (int ...) 
        
        System.out.println("Next Generation"); 
        for (int rowGen1 = 0; rowGen1 < rowGen2a; rowGen1++) 
        {
            for (int incColGen1 = 0; incColGen1 < colGen2a; incColGen1++) 
            {
                if (future[rowGen1][incColGen1] == 0) 
                    System.out.print("[" + "   " + "]"); 
                
                else
                    System.out.print("[" + " = " + "]"); 
            
            } // end> for (int ...) 
            
            System.out.println(); 
        
        } // end> for (int ...)
        
        System.out.println(); 
        thirdGeneration(grid, rowGen2a, colGen2a);
    
    } // end> static void secondGeneration(...)
    
    static void thirdGeneration(int grid[][], int rowGen3a, int colGen3a) 
    {
        int[][] future3 = new int[rowGen3a][colGen3a]; 
        
        /** Check by looping through all cells to get their current
         * state. 0 = Dead; 1 = Alive.
         */
        
        for (int rowGen3b = 1; rowGen3b < rowGen3a - 1; rowGen3b++) 
        {
            for (int colGen3b = 1; colGen3b < colGen3a - 1; colGen3b++) 
            {
                /** Check Neighbouring cells and count the number of Neighbours
                 * in an Alive state.
                 */
                
                int aliveNeighbours = 0; 
                
                for (int rowGen2b = -1; rowGen2b <= 1; rowGen2b++) 
                    for (int colGen2b = -1; colGen2b <= 1; colGen2b++) 
                        aliveNeighbours += grid[rowGen3b + rowGen2b]
                                [colGen3b + colGen2b]; 
                
                /** Subtract the originating cell from the number of 
                 * aliveNeighbours as this has been counted too.
                 */
                
                aliveNeighbours -= grid[rowGen3b][colGen3b]; 
                
                /**-------------------------------------------------------------
                 * IMPLEMENTATION OF THE GAME OF LIFE RULES
                 * ---------------------------------------------*/
                
                /** IMPLEMENT RULES 1 AND 3:
                 * <<<FOR DEBUGGING:
                 * Set the below line to check (aliveNeighbours < 2))
                 * to check only Rule 1 (UNDERPOPULATION).>>>
                 */
                if ((grid[rowGen3b][colGen3b] == 1) && (aliveNeighbours < 2) /* 
                        || (aliveNeighbours > 3)*/ )
                            future3[rowGen3b][colGen3b] = 0; 
                
                /** <<<FOR DEBUGGING - RULE 3:
                 * Uncomment else if containing (aliveNeighbours > 3))
                 * to check only Rule 3 (OVERPOPULATION).>>>
                 */
                else if ((grid[rowGen3b][colGen3b] == 1) && 
                        (aliveNeighbours > 3)) 
                            future3[rowGen3b][colGen3b] = 0;
                
                /** IMPLEMENT RULE 4:
                 * Create new life in dead/empty cell where alive Neighbouring 
                 * cells are equal to 3.
                 */
                else if ((grid[rowGen3b][colGen3b] == 0) && 
                        (aliveNeighbours == 3)) 
                            future3[rowGen3b][colGen3b] = 1; 
                
                /** IMPLEMENT RULE 2:
                 * If cell does not meet above, implying that an alive cell has
                 * 2 or 3 Neighbours, the cell remains alive.
                 */
                else
                            future3[rowGen3b][colGen3b] = 
                                    grid[rowGen3b][colGen3b];
            
            } // end> for (int ...)
        
        } // end> for (int ...) 
        
        System.out.println("Third Generation"); 
        
        for (int rowGen2b = 0; rowGen2b < rowGen3a; rowGen2b++) 
        { 
            for (int colGen2b = 0; colGen2b < colGen3a; colGen2b++) 
            { 
                if (future3[rowGen2b][colGen2b] == 0) 
                    System.out.print("[" + "   " + "]"); 
                
                else
                    System.out.print("[" + " = " + "]"); 
            
            } // end> for (int ...) 
            
            System.out.println(); 
        
        } // end> for (int ...)
    
    } // end> static void thirdGeneration(...)

} // end> public class GameOfLife
