package program;

import static data.TftData.ChampData;
import static data.TftData.LvlUpData;

public class RollLevelWaitMain {

    public static void main(String[] args){
        if(args.length != 3) {
            System.out.println("Please provide exp lvl and unitTier as integer values.");
            System.exit(0);
        }

        int exp = Integer.parseInt(args[0]);
        int lvl = Integer.parseInt(args[1]);
        int unitTier = Integer.parseInt(args[2]);
        String result = new RollLevelWaitMain().compute(exp, lvl, unitTier);
        System.out.println(result);
    }

    public RollLevelWaitMain(){
    }

    public String compute(int exp, int lvl, int unitTier){
        if(exp < 0 || exp > 64 || exp%2 == 1 || lvl < 1 || lvl > 9 || unitTier < 1 || unitTier > 5)
            throw new IllegalArgumentException("No valid values for this program. Valid values are: \nexp: [0,64]\nlvl: [0,9]\nUnit tier: [1,5]");

        LvlUpData lvlUpdata = LvlUpData.getLevelUpDataByLevel(lvl);

        int rollsYouHaveIfYouDontLevelUp = ((lvlUpdata.getMaxExp() - exp) % 4 == 0)? (lvlUpdata.getMaxExp() - exp)/2 : (lvlUpdata.getMaxExp() - exp +2) /2;
        ChampData tftTierData = ChampData.getChampDataByTier(unitTier);

        double changeInTierProbability = (tftTierData.getRollProbabilities()[lvl] - tftTierData.getRollProbabilities()[lvl-1]);

        if(changeInTierProbability > 0){
            return String.format("Gold needed: %d", 2 * (int)Math.ceil(tftTierData.getRollProbabilities()[lvl-1] * rollsYouHaveIfYouDontLevelUp / changeInTierProbability));
        } else {
            return String.format("It will only get worse...");
        }
    }
}
