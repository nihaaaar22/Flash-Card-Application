import java.util.ArrayList;
import java.util.Scanner;

public class FlashcardApp {

    static ArrayList<Card> Cards;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cards = new ArrayList<>(5);

        int continueapp;
        do {

            System.out.println("Main Menu");

            System.out.println("1. Create Card 2. Slideshow 3.AskQues");

            int option = Integer.parseInt(sc.nextLine());

            if (option == 1) {
                createCard();
            } else if (option == 2) {
                slideshow();
            }
            else if (option == 3) {
                askQues();
            }

            System.out.println("press 1 to continue with the app");

            continueapp = Integer.parseInt(sc.nextLine());
        }
        while(continueapp ==1);

    }


    static void createCard(){
        Scanner sc = new Scanner(System.in);
        int continuecards = 0;

        do {
            System.out.println("Creating Card");
            System.out.println("Enter Topic Name");

            String name = sc.nextLine();

            System.out.println("Enter the Content");

            String content = sc.nextLine();
            Cards.add(new Card(name,content));

            System.out.println("If you wish to continue making cards press 1");

            continuecards = Integer.parseInt(sc.nextLine());

        }
        while (continuecards ==1);
    }

    static void slideshow(){
        if(Cards.size()==0){
            System.out.println("there are no cards");
            return;
        }
        Scanner sc = new Scanner(System.in);
        int tocontinue;
        do {
            for (int i = 0; i < Cards.size(); i++) {
                System.out.println(Cards.get(i).name);
                System.out.println(Cards.get(i).content);
                try {
                    Thread.sleep(5000); // 10000ms = 10s
                } catch (InterruptedException ex) {

                    System.exit(0);
                }

            }
            System.out.println("END");
            System.out.println("Press 1 to play slideshow again");

            tocontinue = Integer.parseInt(sc.nextLine());

        }
        while(tocontinue == 1);

    }

    static void askQues(){
        Scanner sc = new Scanner(System.in);
        if(Cards.size()==0){
            System.out.println("there are no cards");
            return;
        }
        int cardno = 0;
        int tocontcard;
        do{
            int questno = 0;
            int tocontques;
            do{
                System.out.println(Cards.get(cardno).ques.get(questno));
                questno ++;

                System.out.println("Do you want to continue with questions press 1");

                tocontques = Integer.parseInt(sc.nextLine());


            }
            while(questno < Cards.get(cardno).ques.size() && tocontques == 1);
            System.out.println("lets move on the questions of the next card");

            cardno ++;
            System.out.println("Do you want to continue with the next card press 1");

            tocontcard = Integer.parseInt(sc.nextLine());

        }
        while(tocontcard ==1 && Cards.size()> cardno);
        System.out.println("there are no more cards left");
    }

}
