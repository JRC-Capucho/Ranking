package viewii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VoteRanque extends Application{

    private static Stage stage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("../view/VotarRanque.fxml"));
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.setTitle("Ranque");
     stage.show();
     setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        VoteRanque.stage = stage;
    }

    
}
