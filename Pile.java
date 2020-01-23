package labb2ps;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author supermannen1
 */
public class Pile{
    private ArrayList<Card> Pile;
    
    public Pile(){
        this.Pile = new ArrayList<>();
    }
    
    public int getSize(){
        return this.Pile.size();
    }
    
    public void clear(){
        this.Pile.clear();
    }
    
    public void add(Card c){
        this.Pile.add(c);
    }
    
    public void add(List<Card> cards){
        this.Pile.addAll(cards);
    }
    
    public Card get(int position){
        
        if(position >= 0 && position < this.Pile.size()){
            return this.Pile.get(position);
        }else
            return null;
           
    }
    
    public List<Card> getCards(){
        List<Card> tmp = new ArrayList<>();
        tmp = (List<Card>) Pile.clone();
        return tmp;
    }
    
    public Card remove(int position){
        if(position <= 0 && position<Pile.size()){
            return Pile.get(position);
        }else
            return null;
    }
    
    public boolean remove(Card c){
        
        boolean hasRemoved = false;
        
        if(c == null){
            return hasRemoved;
        }else{
            
            for(int i = 0; i<this.Pile.size(); i++){
                if(c.equals(Pile.get(i))){
                    this.Pile.remove(i);
                    hasRemoved = true;
                    break;
                }
            }

            return hasRemoved;
        }
            
    }
    
    /**
     * 
     * @param Cards A list of cards
     * @return true if any cards in the given list could be removed from the Pile, otherwise returns false
     */
    
    public boolean remove(List<Card> Cards){
        boolean hasRemoved = false;
        
        for(int i = 0; i<Cards.size(); i++){
            hasRemoved = this.remove(Cards.get(i));
        }
        
        return hasRemoved;
    }
    
    /**
     * 
     * @param suit An arbitrary suit
     * @return how many cards in the pile has the chosen suit
     */
    public int noOfSuit(Suit suit){
       int a = 0;
       for(int i = 0; i<this.Pile.size(); i++){
           if(suit == this.Pile.get(i).getSuit()){
               a++;
           }
       } 
       return a;  
    }
    
    /**
     * 
     * @param rank An arbitrary rank
     * @return How many cards in the pile has the chosen rank
     */
    public int noOfRank(Rank rank){
       int a = 0;
       for(int i = 0; i<this.Pile.size(); i++){
           if(rank == this.Pile.get(i).getRank()){
               a++;
           }
       } 
       return a;  
    }
    
    @Override
    public String toString(){
        String info = "";
        for(int i=0; i<this.Pile.size(); i++){
            info += this.Pile.get(i).toShortString() + " ";
        }
        return info;
    }
}
