import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainFormController {
    public ListView lstLanguages;
    public TextField txtInput;
    public TextField txtOutput;

    public void initialize(){
        lstLanguages.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    txtOutput.setText(newValue.toString());
                });
    }

    ObservableList<String> obList = FXCollections.observableArrayList();

    public void inputOnAction(ActionEvent actionEvent) {
        String lang = txtInput.getText();
        if (isExists(lang)) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Already Exists!");
            alert.show();
            txtInput.clear();
            return;
        }
        obList.add(lang);
        lstLanguages.setItems(obList);
        //---------------
//        txtInput.setText("");
        txtInput.clear();
    }

    private boolean isExists(String value){
        for (String temp: obList
             ) {
            if(temp.equalsIgnoreCase(value)){
                return true;
            }
        }
        return false;
    }
}
