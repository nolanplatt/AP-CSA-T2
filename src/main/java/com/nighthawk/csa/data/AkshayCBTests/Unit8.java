package com.nighthawk.csa.data.AkshayCBTests;

import java.util.Arrays;

public class Unit8 {
    public static class Plot

    {

        private String cropType;

        private int cropYield;



        public Plot(String crop, int yield)

        {

            cropType = crop;
            cropYield = yield;

        }



        public String getCropType()

        {

            return cropType;

        }



        public int getCropYield()

        {

            return cropYield;

        }

    }

    public static class ExperimentalFarm

    {

        private Plot[][] farmPlots;



        public ExperimentalFarm(Plot[][] p)

        {

            farmPlots = p;

        }



        /** Returns the plot with the highest yield for a given crop type, as described in part (a). */

        public Plot getHighestYield(String c)

        {
            Plot highestYieldPlot = null;
            int highest = -1;

            for (int i = 0; i < 4; i++) {
                for (int n = 0; n < 3; n++) {
                    if (farmPlots[i][n].getCropType().equals(c) && (farmPlots[i][n].getCropYield() > highest) ) {
                        highest = farmPlots[i][n].getCropYield();
                        highestYieldPlot = farmPlots[i][n];
                    }
                }
            }

            return highestYieldPlot;
        }



        /** Returns true if all plots in a given column in the two-dimensional array farmPlots

         * contain the same type of crop, or false otherwise, as described in part (b).

         */

        public boolean sameCrop(int col)

        {

            boolean same = true;

            String currentType = farmPlots[0][col].getCropType();
            for( int j = 0; j < 4; j++ ) {
                if (!currentType.equals(farmPlots[j][col].getCropType())) {
                    same = false;
                    break;
                }
            }

            return same;
        }

    }

    public static void main(String[] args) {
        Plot p1 = new Plot("corn",20);

        Plot p2 = new Plot("corn",30);

        Plot p3 = new Plot("peas",10);

        Plot p4 = new Plot("peas",30);

        Plot p5 = new Plot("corn",40);

        Plot p6 = new Plot("corn",62);

        Plot p7 = new Plot("wheat",10);

        Plot p8 = new Plot("corn",50);

        Plot p9 = new Plot("rice",30);

        Plot p10 = new Plot("corn",55);

        Plot p11 = new Plot("corn",30);

        Plot p12 = new Plot("peas",30);

        Plot[][] plots = {{p1,p2,p3},

                {p4,p5,p6},

                {p7,p8,p9},

                {p10,p11,p12}};

        ExperimentalFarm ex = new ExperimentalFarm(plots);

        Plot answer = ex.getHighestYield("corn");
        System.out.println(answer.getCropYield());

        System.out.println(ex.sameCrop(0));
        System.out.println(ex.sameCrop(1));
    }


}
