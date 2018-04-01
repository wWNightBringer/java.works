package controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import database.ReadingClients;
import model.ClientsRecord;
import model.ClientsRecordRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage mainStage;
    private EditController editController;
    private ReadingClients recordRepository;
    private ClientsRecordRepository record;
    @FXML
    private TableView<ClientsRecord> tableView;
    @FXML
    private TableColumn<ClientsRecord, Integer> id;
    @FXML
    private TableColumn<ClientsRecord, String> name;
    @FXML
    private TableColumn<ClientsRecord, String> address;
    @FXML
    private TableColumn<ClientsRecord, Integer> phone;
    @FXML
    private TableColumn<ClientsRecord, String> nick;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Label number;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<ClientsRecord,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        nick.setCellValueFactory(new PropertyValueFactory<>("nick"));

    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void setEditController(EditController editController) {
        this.editController = editController;
    }

    public void setRecordRepository(ReadingClients recordRepository) {
        this.recordRepository = recordRepository;
        ObservableList<ClientsRecord> observableList = recordRepository.getObservableList();
        number.setText(String.valueOf(observableList.size()));
        observableList.addListener((ListChangeListener<ClientsRecord>) c -> number.setText(String.valueOf(c.getList().size())));
        tableView.setItems(observableList);
    }

    @FXML
    public void insertData() {

    }

}
