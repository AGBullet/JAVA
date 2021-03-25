package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField textfield;
    @FXML
    private TextArea textarea;
    @FXML
    public void clickSend(ActionEvent actionEvent) {
        textarea.appendText(textfield.getText()+"\n");
        textfield.clear();
        textfield.requestFocus();

    }


}
