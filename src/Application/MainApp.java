package Application;

import java.io.IOException;
import operations.OperationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * projet de fin de session POO
 * Hiver 2017
 * @authors : Assil, Nyemo, Rama
 * sujet : Aspectisation des log 
 */

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
   
    public MainApp() {
      	
        
    }
 
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("App");

        initRootLayout();
        showOperation();
       
   
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOperation() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../operations/operation.fxml"));
            AnchorPane operationOverview = (AnchorPane) loader.load();

            
            rootLayout.setCenter(operationOverview);

            // Give the controller access to the main app.
           OperationController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
      

    public static void main(String[] args) {
        launch(args);
    }
}