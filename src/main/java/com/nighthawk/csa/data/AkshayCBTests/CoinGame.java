package com.nighthawk.csa.data.AkshayCBTests;

public class CoinGame

{

    private int startingCoins; // starting number of coins

    private int maxRounds; // maximum number of rounds played



    public CoinGame(int s, int r)

    {

        startingCoins = s;

        maxRounds = r;

    }



    /** Returns the number of coins (1, 2, or 3) that player 1 will spend.

     */

    public int getPlayer1Move()

    {

        /* implementation not shown. */
        return 0;
    }



    /** Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a).

     */

    public int getPlayer2Move(int round)

    {
        int result;

        if ((round % 3) > 0) {
            result = 3;
        } else if ((round % 2) > 0) {
            result = 2;
        } else {
            result = 1;
        }
        /* to be implemented in part (a) */
        return result;
    }



    /** Plays a simulated game between two players, as described in part (b).

     */

    public void playGame()

    {
        int rounds = 0;
        int playerOneCoins = startingCoins;
        int playerTwoCoins = startingCoins;
        while (!(playerOneCoins < 3) || !(playerTwoCoins < 3) || !(maxRounds < rounds)) {

            int playerOneSpend = getPlayer1Move();
            int playerTwoSpend = getPlayer2Move(rounds);
            
            if (playerOneSpend == playerTwoSpend) {
                playerTwoCoins = playerTwoCoins + 1;
            } else if (Math.abs(playerOneSpend - playerTwoSpend) == 1) {
                playerTwoCoins = playerTwoCoins + 1;
            } else if (Math.abs(playerOneSpend - playerTwoSpend) == 2) {
                playerOneCoins = playerOneCoins + 2;
            }

            rounds++;
        }
        if (playerOneCoins == playerTwoCoins) {
            System.out.println("tie game");
        } else if (playerOneCoins > playerTwoCoins) {
            System.out.println("player 1 wins");
        } else if (playerTwoCoins > playerOneCoins) {
            System.out.println("player 2 wins");
        }
        /* to be implemented in part (b) */

    }

}
