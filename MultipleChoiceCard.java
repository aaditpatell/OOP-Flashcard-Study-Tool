import java.util.List;

public class MultipleChoiceCard extends Card {
    private List<String> choices;
    private int correctIndex;

    // constructor sets question, choices, and correct index
    public MultipleChoiceCard(String front, List<String> choices, int correctIndex) {
        super(front, choices.get(correctIndex));
        this.choices = choices;
        this.correctIndex = correctIndex;
    }

    public List<String> getChoices() { return choices; }

    // checks if users answer matches the correct choice
    public boolean checkAnswer(String answer) {
        String correct = choices.get(correctIndex);
        if (answer.trim().equalsIgnoreCase(correct)) {
            markCorrect();
            return true;
        } else {
            markIncorrect();
            return false;
        }
    }

    // show the question, choices, and users results stats
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Q: " + getFront() + "\n");
        for (int i = 0; i < choices.size(); i++) {
            sb.append((char)('A' + i)).append(") ").append(choices.get(i)).append("\n");
        }
        sb.append("Correct: ").append(getTimesCorrect())
          .append(", Incorrect: ").append(getTimesIncorrect());
        return sb.toString();
    }
}
