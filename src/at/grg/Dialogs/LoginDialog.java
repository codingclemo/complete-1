package at.grg.Dialogs;

import at.grg.Data.User;
import at.grg.ICompleteDataProvider.ICompleteDataProvider;
import at.grg.State.AppState;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

// to get me started how things work in JavAFX
public class LoginDialog implements EventHandler<ActionEvent> {

    private Stage loginStage = new Stage();

    private TextField usernameField;
    private TextField passwordField;

    public LoginDialog(Window owner) {

        usernameField = new TextField();
        usernameField.setPromptText("username ");

        passwordField = new TextField();
        passwordField.setPromptText("password ");

        Button btnOk = new Button("Ok");
        btnOk.setId("ok-button");
        btnOk.setDefaultButton(true);
        // styling:
        btnOk.setPrefWidth(70);
        btnOk.setOnAction(this);

        Button btnCancel = new Button("Cancel");
        btnCancel.setId("cancel-button");
        // styling:
        btnCancel.setPrefWidth(70);
        btnCancel.setOnAction(this);

        HBox buttonBar = new HBox(20);
        buttonBar.setId("button-bar");
        // styling:
        buttonBar.setPadding(new Insets(15, 0, 0, 0));
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.getChildren().addAll(btnOk, btnCancel);

        // add the elements to a gridpane
        GridPane loginPane = new GridPane();
        loginPane.setId("pref-pane");
        // styling:
        loginPane.setHgap(10);
        loginPane.setVgap(10);
        loginPane.setPadding(new Insets(20));
        loginPane.add(new Label("Username:"), 0, 0);
        loginPane.add(usernameField, 1, 0);
        loginPane.add(passwordField, 2, 0);
        loginPane.add(buttonBar, 0, 3, 2, 1);

        Scene dialogScene = new Scene(loginPane);
        // dialogScene.getStylesheets().add(getClass().getResource("/preferences-dialog.css").toExternalForm());

        loginStage.setScene(dialogScene);
        loginStage.setTitle("Login Dialog");
        loginStage.initModality(Modality.WINDOW_MODAL);
        loginStage.initStyle(StageStyle.UTILITY);
        loginStage.initOwner(owner);
        loginStage.setResizable(false);
    }
    
    public void show() {
        usernameField.setStyle("-fx-border-width: 0px;");
//        segmentLengthField.setText(String.valueOf(Preferences.getInstance().getSegmentLength()));
        Platform.runLater(() -> usernameField.requestFocus());
        loginStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            if (((Button) event.getSource()).getId().equals("ok-button")) {
                ICompleteDataProvider db = AppState.getInstance().getDatabase();
                if (db.authenticateUser(usernameField.getText(), passwordField.getText())) {
                    User u = db.getUserByUsername(usernameField.getText());
                    System.out.println("'LoginDialog', login succeesful with username = " + usernameField.getText() + "   password = " + passwordField.getText());

                    AppState.getInstance().setUser(u);
                    loginStage.hide();
                } else {
                    System.out.println("'LoginDialog', login failed with username = " + usernameField.getText() + "   password = " + passwordField.getText());

                }
            }
            
        } catch (NumberFormatException ex) {
            System.out.println("'LoginDialog', login failed with username = " + usernameField.getText() + "   password = " + passwordField.getText());
//            segmentLengthField
//                    .setStyle("-fx-border-color: red; " + "-fx-border-width: 2px; " + "-fx-border-radius: 3px;");
        }

    }

}
