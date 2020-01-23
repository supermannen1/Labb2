package labb2ps;

import java.util.Arrays;

/**
 *
 * @author supermannen1
 */
public class Pokerhands {

    private Pokerhands(){
        
    }

    private static PokerCombo checkStraight(Pile hand){
        int lowestValue = 0;
        int[] CardsValue = new int[hand.getSize()];
        boolean hasStraight = false;

        for(int i = 0; i<hand.getSize();i++){
            CardsValue[i] = hand.get(i).getRankValue();
        }
        
        Arrays.sort(CardsValue);
        
        lowestValue = CardsValue[0];
        for(int i = 0; i<hand.getSize();i++){
            if(CardsValue[i] == lowestValue+i){
                hasStraight = true;
            }else{
                hasStraight = false;
                break;
            }
        }
        if(hasStraight){           
            return PokerCombo.STRAIGHT;
        }else{
            return PokerCombo.NONE;
        }
    }
    
    /**
     * Checks if you have pair, two pairs, three of a kind, four of a kind, full house or none
     */
    private static PokerCombo checkEverythingElse(Pile hand){
        Rank[] RankList = Rank.values();
        int a;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        
        int[] table = new int[RankList.length];
        Arrays.fill(table, 0);
        
        for(int i = 0; i<hand.getSize(); i++){
            a = hand.get(i).getRankValue()-1;
            table[a] += 1;
        }
        
        for(int i = 0; i<table.length; i++){
            switch (table[i]) {
                case 2:
                    counter2 += 1;
                    break;
                case 3:
                    counter3 += 1;
                    break;
                case 4:
                    counter4 += 1;
                    break;
                default:
                    break;
            }
        }
        if(counter4 == 4){
            return PokerCombo.FOUR_OF_A_KIND;
        }else if(counter3 == 1 && counter2 == 1){
            return PokerCombo.HOUSE;
        }else if(counter3 == 1){
            return PokerCombo.THREE_OF_A_KIND;
        }else if(counter2 == 2){
            return PokerCombo.TWOPAIRS;
        }else if(counter2 == 1){
            return PokerCombo.PAIR;
        }else{
            return PokerCombo.NONE;    
        }
        
    }
    
    private static PokerCombo checkFlush(Pile hand){
        Suit[] SuitList = Suit.values();
        
        PokerCombo atm = PokerCombo.NONE;
        
        for(int i = 0; i<SuitList.length;i++){
            if(hand.noOfSuit(SuitList[i]) == hand.getSize()){
                atm = PokerCombo.FLUSH;
                break;
            }
        }
        return atm;
    }
    
    /**
     * Returns the highest PokerCombo in the Pile
     * @param (Pile) hand
     * @return A PokerCombo
     */
    public static PokerCombo getPokerCombo(Pile hand){
        
        PokerCombo atm;
        PokerCombo tmp;
        
        atm = Pokerhands.checkStraight(hand);
        tmp = Pokerhands.checkFlush(hand);
        
        if(atm == PokerCombo.STRAIGHT && tmp == PokerCombo.FLUSH){
            atm = PokerCombo.STRAIGHTFLUSH;
        }else if(tmp == PokerCombo.FLUSH){
            atm = tmp;
        }else if(atm == PokerCombo.NONE){
            atm = Pokerhands.checkEverythingElse(hand);
        }else{}
        
        return atm;
    }
}
