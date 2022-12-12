package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.model.quiz.Question;
import de.fh_zwickau.oose.zuul05.model.quiz.QuestionList;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

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
            Question question = questions.getQuestions().get(player.getCurrentDay()-1);
            PrintUtil.Choice_Dialog(question,schluessel,player);
            setAvailable(false);
        }
}





