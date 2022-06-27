package viewii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login extends Application {
    private static Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
    }
// fazer o git
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("../css/style.css").toExternalForm());

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setWidth(524);
        stage.setHeight(363);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {

        return stage;
    }

    public static void setStage(Stage stage) {
        Login.stage = stage;
    }
}
