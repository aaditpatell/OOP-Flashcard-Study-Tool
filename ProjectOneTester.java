import java.util.*;

/*
this project is a flashcard app that helps users study and track their learning.
users can create regular flashcards (with a question and answer) and also multiple choice cards.
flashcards are grouped into decks, and users can quiz themselves using those decks.

the quiz system asks each card in the deck, takes user input, and tracks performance.
after the quiz, it shows the cards sorted by lowest success rate, helping users see which ones they struggle with.

class descriptions:
- Card: base class for a flashcard. stores question, answer, and stats (correct/incorrect).
- MultipleChoiceCard: extends Card to add multiple answer choices and track correct index.
- Deck: stores a list of cards. allows adding, shuffling, and retrieving cards.
- UserPerformanceComparator: compares two cards based on how often the user got them right.
- ProjectOneTester: main class that sets up a sample deck, runs the quiz, and shows results.
*/
public class ProjectOneTester {
    public static void main(String[] args) {
        Deck deck = new Deck("java basics");

    //  create multiple choice cards and add them to the deck
        List<String> jvmChoices = Arrays.asList("just virtual memory", "java visual mode", "java virtual machine", "java variable manager");
        MultipleChoiceCard c1 = new MultipleChoiceCard("what does JVM stand for?", jvmChoices, 2);

        List<String> inheritChoices = Arrays.asList("inherits", "implements", "extends", "overrides");
        MultipleChoiceCard c2 = new MultipleChoiceCard("what keyword is used to inherit a class?", inheritChoices, 2);

        List<String> q1Choices = Arrays.asList("int", "Integer", "void", "double");
        MultipleChoiceCard c3 = new MultipleChoiceCard("which is a primitive type?", q1Choices, 0);

        deck.addCard(c1);
        deck.addCard(c2);
        deck.addCard(c3);

        deck.shuffleDeck();

        Scanner scanner = new Scanner(System.in);

        int count = 1;
        for (Card card : deck.getCards()) {
            System.out.println("\n---------------------------");
            System.out.println("card " + count++);
            System.out.println(card);

            System.out.print("your answer: ");
            String answer = scanner.nextLine();

            boolean correct = ((MultipleChoiceCard) card).checkAnswer(answer);
            System.out.println(correct ? "correct!" : "incorrect.");
            System.out.println();
        }

        System.out.println("\n--- sorted by lowest performance ---");
        ArrayList<Card> sorted = new ArrayList<>(deck.getCards());
        sorted.sort(new UserPerformanceComparator());

        for (Card card : sorted) {
            System.out.println("\n---------------------------");
            System.out.println(card);
        }

        scanner.close();
    }
}
