import java.util.Comparator;

public class UserPerformanceComparator implements Comparator<Card> { 
    // cards that the user gets wrong, automatically gets sorted to the top 
    @Override
    public int compare(Card a, Card b) {
        return Double.compare(a.getSuccessRate(), b.getSuccessRate());
    }
}
