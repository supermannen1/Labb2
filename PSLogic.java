package labb2ps;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author supermannen1
 */
public class PSLogic{
    private Deck deck;
    private Card nextCard;
    private ArrayList<Pile> Piles;
    
    public PSLogic(){
        this.initNewGame();
    }
    
    public void initNewGame(){
        this.deck = new Deck();
        this.deck.shuffleCards();
        this.nextCard = this.deck.dealCard();
        this.Piles = new ArrayList<>();
        
        for(int i = 0; i<5; i++){
            this.Piles.add(new Pile());
        }
    }
    
    public int getCardCount(){
        
        int a = 0;
        
        for(int i= 0; i<Piles.size(); i++){
            a += this.Piles.get(i).getSize();
        }
        return a;
    }
    
    public Card pickNextCard(){
        if(this.nextCard == null){
            this.nextCard = this.deck.dealCard();
        }
        return this.nextCard;
    }
    
    public void addCardToPile(int pileNr){
        if(this.pickNextCard()!=null && pileNr >= 0 && pileNr < Piles.size() && Piles.get(pileNr).getSize() < 5){
            Piles.get(pileNr).add(this.nextCard);
            this.nextCard = null;
        }
    }
    
    public List<Pile> getPiles(){
        List<Pile> tmp = new ArrayList<>();
        
        for(int i =0; i<this.Piles.size(); i++){
            tmp.add(this.Piles.get(i));
        }
        
        return tmp;
    }
    
    public boolean isGameOver(){
        return this.getCardCount() == 25;
    }
    
    public int getPoints(){
        int points = 0;
        for(int i =0; i<this.Piles.size(); i++){
            points += Pokerhands.getPokerCombo(this.Piles.get(i)).getNr();    
        }
        return points;
    }
    
    @Override
    public String toString(){
        String info = "\n\nDeck:" + this.deck.toString();
        info += "\n nextCard: " + this.nextCard.toShortString();
        for(int i = 0; i<Piles.size(); i++){
            info += "Pile" + i +":"+ Piles.get(i).toString();
        }
        info += "\n CardCount:" + this.getCardCount();
        return info;
    }
}
