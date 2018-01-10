import io.Input;
import io.Output;
import io.Window;
import javafx.application.Application;
import javafx.stage.Stage;

public class BMI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /* write your code here */
        String name = Input.readString("What is your name?");

        int height = Input.readInt("What is your height in cm?");
        int weight = Input.readInt("What is your weight in kg?");



    }


    /* Leave this method */
    public static void main(String[] args) {
        launch(args);
    }
}
