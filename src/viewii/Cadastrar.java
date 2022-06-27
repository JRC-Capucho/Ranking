package viewii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Cadastrar extends Application {
private static Stage stage;
private double xOffset;
private double yOffset;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/Cadastrar.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);

        root.setOnMousePressed(event ->{
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event ->{
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("../css/style.css").toExternalForm());
        stage.setWidth(524);
        stage.setHeight(363);
        stage.show();
        setStage(stage);
    }
    
    public static Stage getStage()
    {
        return stage;
    }

    public static void setStage(Stage stage)
    {
        Cadastrar.stage = stage;
    }

        
    
}
