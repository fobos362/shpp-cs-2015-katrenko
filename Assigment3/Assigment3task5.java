package assigment3task5;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

/**
 *
 * @author Bogdan Katrenko
 */
public class Assigment3task5 extends TextProgram {
    /*
    Play and have fun. This game is based on St. Petersburg paradox 
    wiki https://ru.wikipedia.org/wiki/%D0%A1%D0%B0%D0%BD%D0%BA%D1%82-%D0%9F%D0%B5%D1%82%D0%B5%D1%80%D0%B1%D1%83%D1%80%D0%B3%D1%81%D0%BA%D0%B8%D0%B9_%D0%BF%D0%B0%D1%80%D0%B0%D0%B4%D0%BE%D0%BA%D1%81
    For solving task decomposition into 2 parts:
     1. get coin result (it 1 - eagle, or tails)
     2. make game in recursion while luckyMoney < 20.
    */

    public static final int EAGLE = 1; // mark one edge of coin
    public static final int START_SUM_ON_TABLE = 1; // sum on table when game is start
    public static final int MONEY_COEF = 2; // how many money added to table when coin get tail
    public static final int MONEY_FOR_WIN = 20; // when lucky have this sum, game in ending
    public static final int START_SUM_IN_LUCKY = 0; // lucky have it when game starting
    public static final int COIN_EDGE = 2; // how many edge have coin

    public void run() {
        GameEmulating(0, getCoinResult(), START_SUM_IN_LUCKY, START_SUM_ON_TABLE);
    }

    /*
    get result of coin throwing.
    @return rand value - zerro or one - like a one of edge of coin
    */
    private int getCoinResult() {
        return RandomGenerator.getInstance().nextInt(COIN_EDGE);
    }

    /*
    @param gameCount - how many game is starting while lucky sum < 20$
    @param coinResult - rand value from 0 to 1, like edge of coin
    @param lucky money - how many mone have lucky 
    @param sumOnTable - how many money on table when game starting
    */
    private void GameEmulating(int gameCount, int coinResult, int luckyMoney, int sumOnTable) {
        gameCount++;
        
        if (coinResult == EAGLE) {
            sumOnTable *= MONEY_COEF;
        } else {
            println("This game, you earned $" + sumOnTable);
            println("Your total is $" + (luckyMoney += sumOnTable));
        }

        if (luckyMoney < MONEY_FOR_WIN) 
            GameEmulating(gameCount, getCoinResult(), luckyMoney, sumOnTable); // if lucky have >20$ - starting game, using recursion
         else 
            println("It took " + gameCount + " games to earn $20"); // if we get it, lucky have <20&, game is ending
        return;
    }
}
