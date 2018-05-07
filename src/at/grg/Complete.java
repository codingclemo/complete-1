package at.grg;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Complete extends Application {

    private MenuBar createMenuBar(Stage stage) {
        // PreferencesDialog dialog = new PreferencesDialog(stage);

        // my cards
        MenuItem myCardsItem = new MenuItem("My Cards");
        MenuItem marketplaceItem = new MenuItem("Marketplace");
        // prefItem.setOnAction(e -> mycards.show());
        MenuItem exitItem = new MenuItem("Exit ");

        Menu completeMenu = new Menu("Complete");
        completeMenu.getItems().add(myCardsItem);
        completeMenu.getItems().add(marketplaceItem);
        completeMenu.getItems().add(exitItem);

        // close the application when exit is clicked 
        exitItem.setOnAction(e -> {
            Platform.exit();
            System.exit(0);
        });

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(completeMenu);

        return menuBar;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Complete");
        Scene scene = new Scene(new VBox(), 400, 350);

        // Create MenuBar and add to Scene
        MenuBar menuBar = createMenuBar(primaryStage);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
