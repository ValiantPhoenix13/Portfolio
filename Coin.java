/*******************************************************************************
 * Lawson_Andrew
 * The following code defines the class coin and the method flip
 * so as the result will be an integer later defined as heads or tails
 *//////////////////////////////////////////////////////////////////////////////
package Coinflip;

import java.util.Random;

public class Coin {
    
    ////////////////////////////////////////////////////////////////////////////
    //Defining the two sides of the coin that can be flipped
    ////////////////////////////////////////////////////////////////////////////
    public int Flip(){
        Random ran = new Random();
        int s = ran.nextInt(2);
        return s;
    }
}
