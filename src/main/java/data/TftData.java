package data;

public class TftData {
    public enum ChampData{
        GRAY(1, new double[]{5d, 5d, 3.25d, 2.5d, 1.85d, 1.225d, 1d, 0.75d, 0.5d}),
        GREEN(2, new double[]{0d, 0d, 1.5d, 1.75d, 1.75d, 1.75d, 1.5d, 1.25d, 1.25d}),
        BLUE(3, new double[]{0d, 0d, 0.25d, 0.75d, 1.25d, 1.5d, 1.65d, 1.75d, 1.75d}),
        PURPLE(4, new double[]{0d, 0d, 0d, 0d, 0.15d, 0.5d, 0.75d, 1d, 1.5d}),
        GOLD(5, new double[]{0d, 0d, 0d, 0d, 0d, 0.025d, 0.1d, 0.25d, 0.5d});

        private int tier;
        private double[] rollProbabilities;
        ChampData(int tier, double[] rollProbabilities){
            this.tier = tier;
            this.rollProbabilities = rollProbabilities;
        }

        public int getTier(){
            switch (this){
                case BLUE:
                    return BLUE.tier;
                case GOLD:
                    return  GOLD.tier;
                case GRAY:
                    return GRAY.tier;
                case GREEN:
                    return GREEN.tier;
                case PURPLE:
                default:
                    return PURPLE.tier;
            }
        }

        public double[] getRollProbabilities(){
            switch (this){
                case BLUE:
                    return BLUE.rollProbabilities;
                case GOLD:
                    return  GOLD.rollProbabilities;
                case GRAY:
                    return GRAY.rollProbabilities;
                case GREEN:
                    return GREEN.rollProbabilities;
                case PURPLE:
                default:
                    return PURPLE.rollProbabilities;
            }
        }

        public static ChampData getChampDataByTier(int tier){
            switch (tier){
                case 5:
                    return GOLD;
                case 2:
                    return GREEN;
                case 3:
                    return BLUE;
                case 4:
                    return PURPLE;
                case 1:
                default:
                    return GRAY;
            }
        }
    }

    public enum LvlUpData{
        LEVEL_1(2),
        LEVEL_2(2),
        LEVEL_3(6),
        LEVEL_4(10),
        LEVEL_5(18),
        LEVEL_6(30),
        LEVEL_7(46),
        LEVEL_8(64);

        private int maxExp;
        LvlUpData(int maxExp){
            this.maxExp = maxExp;
        }

        public int getMaxExp() {
            return this.maxExp;
        }

        public static LvlUpData getLevelUpDataByLevel(int level){
            if(level > 8 || level < 1)
                throw new IllegalArgumentException("Only levels between 1 and 8 are valid");

            switch (level){
                case 1:
                    return LEVEL_1;
                case 2:
                    return LEVEL_2;
                case 3:
                    return LEVEL_3;
                case 4:
                    return LEVEL_4;
                case 5:
                    return LEVEL_5;
                case 6:
                    return LEVEL_6;
                case 7:
                    return LEVEL_7;
                case 8:
                default:
                    return LEVEL_8;
            }
        }
    }
}
