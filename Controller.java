package com.example.password_creator;

import com.example.password_creator.DataModel.PasswordCreator;
import com.example.password_creator.DataModel.Source;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Controller {
    @FXML
    public CheckBox upperCase;
    @FXML
    public CheckBox numbers;
    @FXML
    public CheckBox lowerCase;
    @FXML
    public CheckBox symbols;
    @FXML
    public Slider slider;
    @FXML
    public Button generate;
    @FXML
    public TextField textField;
    @FXML
    public Button copyButton;

    private boolean upperCaseIn;
    private boolean lowerCaseIn;
    private boolean numbersIn;
    private boolean symbolsIn;
    private int length;

    public void initialize() {
        upperCase.selectedProperty().addListener((observableValue, aBoolean, t1) ->
                upperCaseIn = upperCase.isSelected());
        lowerCase.selectedProperty().addListener((observableValue, aBoolean, t1) ->
                lowerCaseIn = lowerCase.isSelected());
        numbers.selectedProperty().addListener((observableValue, aBoolean, t1) ->
                numbersIn = numbers.isSelected());
        symbols.selectedProperty().addListener((observableValue, aBoolean, t1) ->
                symbolsIn = symbols.isSelected());
        upperCase.setSelected(true);
        lowerCase.setSelected(true);
        numbers.setSelected(true);
        symbols.setSelected(true);
        slider.valueProperty().addListener((observableValue, number, t1) ->
                length = (int) slider.getValue());
        slider.setMin(10);
        slider.setMax(100);
        slider.setShowTickMarks(false);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(0);
    }

    public void generatePassword() {
        if (!upperCaseIn && !lowerCaseIn && !numbersIn && !symbolsIn) {
            Alert alertInvalid = new Alert(Alert.AlertType.INFORMATION);
            alertInvalid.setTitle("Notification");
            alertInvalid.setHeaderText(null);
            alertInvalid.setContentText("Please, select at least one type of characters.");
            alertInvalid.show();
        } else {
            Source source = new Source(upperCaseIn, lowerCaseIn, numbersIn, symbolsIn);
            PasswordCreator passwordGenerator = new PasswordCreator(source, length);
            if (passwordGenerator.getPassword().length() > 40) {
                textField.setAlignment(Pos.TOP_LEFT);
            } else {
                textField.setAlignment(Pos.CENTER);
            }
            textField.setText(passwordGenerator.getPassword());
        }
    }

    public void copyPassword(){
        String passwordToCopy = textField.getText();
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(passwordToCopy);
        clipboard.setContent(content);
    }
}