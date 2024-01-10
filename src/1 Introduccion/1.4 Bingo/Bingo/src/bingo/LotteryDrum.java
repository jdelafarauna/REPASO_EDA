import java.util.ArrayList;

import java.util.Collections;

/**
 * Represents a lottery drum that contains numbers for a lottery game.
 */
class LotteryDrum {
    private ArrayList<Integer> bombo = new ArrayList<Integer>();



    /**
     * Constructs a new instance of the LotteryDrum class.
     */
    public LotteryDrum() {

       for(int i = 1; i<=90; i++){
           bombo.add(i);
       }
        Collections.shuffle(bombo);
    }

    /**
     * Returns whether the LotteryDrum object has any numbers or not.
     *
     * @return true if the LotteryDrum has numbers, false otherwise.
     */
    boolean hasNumbers() {
        return bombo == null;
    }

    /**
     * Returns a random number from the LotteryDrum object.
     *
     * @return the randomly generated number.
     */
    int getNumber() {
        return bombo.remove(0);
    }

}
