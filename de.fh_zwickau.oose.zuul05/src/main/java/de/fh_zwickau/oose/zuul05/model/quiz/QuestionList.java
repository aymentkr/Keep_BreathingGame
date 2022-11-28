package de.fh_zwickau.oose.zuul05.model.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {

    public List<Question> questions;

    public QuestionList() {
        questions = new ArrayList<>();

        questions.add(new Question("Galileo war ein italienischer Astronom, der entwickelt hat?", "Teleskop", "Flugzeug", "Elektrizität", "Zug", "A"));

        questions.add(new Question("Wer ist der Vater der Geometrie?", "Aristoteles", "Euklid", "Pythagoras", "Kepler", "B"));

        questions.add(new Question("Wer war als Iron Man of India bekannt?","Govind Ballabh Pant","Jawaharlal Nehru","Subhash Chandra Bose","Sardar Vallabhbhai Patel","D"));

        questions.add(new Question("Die erste Frau im Weltraum war ?", "Valentina Tereshkova", "Sally Ride", "Naidia Comenci", "amara Press", "A"));

        questions.add(new Question("Wer ist der fliegende Sikh von Indien?", "Mohinder Singh", "Joginder Singh", "Ajit Pal Singh", "Milkha Singh", "D"));

        questions.add(new Question("Der Indianer, der die Computer in mathematischer Zauberei schlägt, ist", "Ramanujam", "Rina Panigrahi", "Raja Ramanna", "Shakunthala Devi", "D"));

        questions.add(new Question("Wer ist Larry Pressler?", "Politiker", "Maler", "Schauspieler", "Tennisspieler", "A"));

        questions.add(new Question("Michael Jackson ist eine angesehene Person auf dem Gebiet von ?", "Popmusik", "Journalismus", "Sport", "Schauspiel", "A"));

        questions.add(new Question("Der erste Indianer, der den Ärmelkanal durchschwamm, war ?", "V. Merchant", "P. K. Banerji", "Mihir Sen", "Arati Saha", "C"));

        questions.add(new Question("Wer war der erste Inder, der einen Film drehte?", "Dhundiraj Govind Phalke", "Asha Bhosle", "Ardeshir Irani", "V. Shantaram", "A"));
        /*

        questions.add(new Question("Wer ist bekannt als der 'Heilige der Gossen'?", "B.R.Ambedkar", "Mutter Teresa", "Mahatma Gandhi", "Baba Amte", "Mutter Teresa"));

        questions.add(new Question("Wer erfand die berühmte Formel E=mc^2", "Albert Einstein", "Galilio", "Sarvesh", "Bill Gates", "Albert Einstein"));

        questions.add(new Question("Wer wird 2016 zum Präsidenten von uns gewählt", "Donald Trump", "Hillary Clinton", "John paul", "Barack Obama", "Donald Trump"));

        questions.add(new Question("Wer war der Gründer der Firma Microsoft", "Bill Gates", "Bill Clinton", "Jhon rio", "Steve Jobs", "Bill Gates"));

        questions.add(new Question("Wer war der Gründer der Firma Apple?", "Steve Jobs", "Steve Washington", "Bill Gates", "Jobs Willis", "Steve Jobs"));

        questions.add(new Question("Wer war der Gründer der Firma Google?", "Steve Jobs", "Bill Gates", "Larry Page", "Sundar Pichai", "Larry Page"));

        questions.add(new Question("Wer ist als Gott des Grillens bekannt?", "Sachin Tendulkar", "Kapil Dev", "Virat Koli", "Dhoni", "Sachin Tendulkar"));

        questions.add(new Question("Wer hat den Ballon d'or 2015 gewonnen?", "Lionel Messi", "Cristiano Ronaldo", "Neymar", "Kaka", "Lionel Messi"));

        questions.add(new Question("Wer hat den Ballon d'or 2014 gewonnen?", "Neymar", "Lionel Messi", "Cristiano Ronaldo", "Kaka", "Cristiano Ronaldo"));

        questions.add(new Question("der Gründer der berühmtesten Spielplattform Steam ist ?", "Bill Cliton", "Bill Williams", "Gabe Newell", "Bill Gates", "Gabe Newell"));
        this.addAllQuestions(arraylist);
*/

    }

   /* public Question getQuestion(int i) {
        return questions.get(i);
    }
*/



    public List<Question> getQuestions() {
        return questions;
    }

}
