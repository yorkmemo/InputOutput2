import io.Input;
import io.Output;
import io.Window;
import javafx.application.Application;
import javafx.stage.Stage;

public class Initials extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /* write your code here */

       /* String first = Input.readString("Enter your first name");
        String last = Input.readString("Enter your last name");*/
                                                                 //01234
        String name = Input.readString("Enter your full name");  //Joe Bloggs

        int spaceIndex = name.indexOf(" ");

        String initials = name.substring(0,1) + name.substring(spaceIndex + 1, spaceIndex + 2);
/*
        String initails = first.substring( 0, 1) + ". " + last.substring( 0, 1) + ".";
*/
        Output.show(initials);

    }


    /* Leave this method */
    public static void main(String[] args) {
        launch(args);
    }
}
