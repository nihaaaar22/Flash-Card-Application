import java.util.ArrayList;
import java.util.Scanner;


public class Card {
    String name;
    String content;
    ArrayList<String> ques;


    Card(String name, String content){

        this.name = name;
        this.content = content;
        this.StoreQues();

    }

    void StoreQues(){
        ques = new ArrayList<>(1);

        Scanner sc = new Scanner(System.in);

        System.out.println("This is your content :" + this.content);

        int tocontinue;
        do{
            System.out.println("List the questions related to the content");
            String question = sc.nextLine();
            this.ques.add(question);
            System.out.println("Press 1 to continue adding questions to the card");
            tocontinue = Integer.parseInt(sc.nextLine());
        }
        while(tocontinue ==1);
    }
}
