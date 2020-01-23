package labb2ps;

/**
 *
 * @author supermannen1
 */
public enum PokerCombo {
    NONE(0), PAIR(1), TWOPAIRS(3), FLUSH(5), THREE_OF_A_KIND(6), HOUSE(10), STRAIGHT(12), FOUR_OF_A_KIND(16), STRAIGHTFLUSH(30);
    
    private final int nr;

    PokerCombo(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }
}
