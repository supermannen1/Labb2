package labb2ps;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


/**
 *
 * @author supermannen1
 */
public class Deck {
    private final ArrayList<Card> Deck;
    private static final Random RAND = new Random();
    
    public Deck(){
        this.Deck = new ArrayList<>();
        this.fill();
    }
    
    
    public int getSize(){
        return Deck.size();
    }
        
    public Card dealCard(){
        
        Card tmpCard = null;
        
        if(!this.Deck.isEmpty()){
            tmpCard = this.Deck.get(0);
            this.Deck.remove(0);
        }
        
        return tmpCard;
    }
    
    
    
    public void fill(){
        this.Deck.clear();
        
        Rank[] RankList = Rank.values();
        Suit[] SuitList = Suit.values();
        
        for (Suit SuitList1 : SuitList) {
            for (Rank RankList1 : RankList) {
                Deck.add(new Card(RankList1, SuitList1));
            }
        }
        
    }
    
    public void shuffleCards(){
        Collections.shuffle(Deck);
    }
    
    @Override
    public String toString(){
        String info = " ";
        for(int i = 0; i<Deck.size(); i++){
            info += " " + Deck.get(i).toShortString();
        }
        return info;
    }
}
