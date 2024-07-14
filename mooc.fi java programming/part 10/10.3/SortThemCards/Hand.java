import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int sumThis = this.calculateSum();
        int sumOther = otherHand.calculateSum();

        return Integer.compare(sumThis, sumOther);
    }

    private int calculateSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getValue();
        }
        return sum;
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}