package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.model.quiz.Question;
import de.fh_zwickau.oose.zuul05.model.quiz.QuestionList;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

import java.util.Scanner;

/**
 * The type Mastery box.
 */
public class MasteryBox extends Item {
    private final Key schluessel;
    private final QuestionList questions = new QuestionList();

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public MasteryBox(String name, String description) {
        super(name, description);
        schluessel = new Key("schluessel", "Den Schlüssel der Tür zum Essensraum");

    }




    @Override
    public void use(Player player) {
        if (player.getItem("schluessel").isPresent())
            PrintUtil.showMessage("Sie haben schon die schlüssel");
        else {
            Question question = questions.getQuestions().get(player.getCurrentDay()-1);
            PrintUtil.showMessage("Sie müssen ein Rätsel lösen, um einen Schlüssel zu erhalten");
            PrintUtil.showMessage("Frage "+player.getCurrentDay()+": "+question.getQuestion());
            PrintUtil.showMessage("Option A: "+question.getOptA());
            PrintUtil.showMessage("Option B: "+question.getOptB());
            PrintUtil.showMessage("Option C: "+question.getOptC());
            PrintUtil.showMessage("Option D: "+question.getOptD());
            //question.setAnswer();

            Scanner in = new Scanner(System.in);
            System.out.println("was ist die Antwort");
            String b = in.nextLine();
            if (b.equals(question.getAnswer())) {
                System.out.println("Richtig");
                player.addItem(schluessel);
                setAvailable(false);
            } else {
                System.out.println("Falsch");
                setAvailable(false);
            }
        }
    }


}





