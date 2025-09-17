public class Card {
    private String front;
    private String back;
    private int timesCorrect;
    private int timesIncorrect;

    // default constructor
    public Card() {
        this.front = "";
        this.back = "";
    }

    // overloaded constructor
    public Card(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public String getFront() { return front; }
    public String getBack() { return back; }
    public int getTimesCorrect() { return timesCorrect; }
    public int getTimesIncorrect() { return timesIncorrect; }

    public void setFront(String front) { this.front = front; }
    public void setBack(String back) { this.back = back; }

    // increase correct count
    public void markCorrect() { timesCorrect++; }

    // increase incorrect count
    public void markIncorrect() { timesIncorrect++; }

    // return correct percentage
    public double getSuccessRate() {
        int total = timesCorrect + timesIncorrect;
        return total == 0 ? 0.0 : (double) timesCorrect / total;
    }

    // show card info and stats
    @Override
    public String toString() {
        return "Q: " + front + " | A: " + back +
               " | Correct: " + timesCorrect + ", Incorrect: " + timesIncorrect;
    }

    // check if two cards have same question and answer
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return this.front.equals(other.front) && this.back.equals(other.back);
    }
}
