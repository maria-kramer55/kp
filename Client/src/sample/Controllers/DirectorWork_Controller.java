package sample.Controllers;/*
package sample.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import client.MaterialsPrcessing;
import client.ServicesProcessing;
import client.WorkersProcessing;
import model.Material;
import model.Service;
import model.Worker;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Enum.ConnectInstance;
import sample.AlertBox;


public class DirectorWork_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //----------------------------Таблица персонал-----------------------------//

    @FXML
    private TableView<Worker> workersTable;

    @FXML
    private TableColumn<Worker, Integer> workerNumber;

    @FXML
    private TableColumn<Worker, String> workerName;

    @FXML
    private TableColumn<Worker, String> workerLastName;

    @FXML
    private TableColumn<Worker, String> workerService;

    @FXML
    private TableColumn<Worker, Integer> workerSallary;

    @FXML
    private Button workerAddBttn;

    @FXML
    private Button workerDeleteBttn;

    //---------------------------Таблица услуг----------------------------------//

    @FXML
    private TableView<Service> serviceTable;

    @FXML
    private TableColumn<Service, Integer> serbiceNumber;

    @FXML
    private TableColumn<Service, String> serviceName;

    @FXML
    private TableColumn<Service, Integer> servicePrice;

    @FXML
    private Button deleteServiceBttn;

    @FXML
    private Button serviceAddBttn;

    //---------------------------Таблица материал--------------------------------//

    @FXML
    private TableView<Material> materialTable;

    @FXML
    private TableColumn<Material, Integer> materialNumber;

    @FXML
    private TableColumn<Material, String> materialName;

    @FXML
    private TableColumn<Material, Integer> materialPrice;

    @FXML
    private Button deleteMaterialBttn;

    @FXML
    private Button materialAddBttn;


    @FXML
    void AddService(ActionEvent event) {


    }

    @FXML
    void AddWorker(ActionEvent event) {

    }

    @FXML
    void addMaterial(ActionEvent event) {

    }

    @FXML
    void deleteMaterial(ActionEvent event) {
        if(materialTable.getSelectionModel() != null){
            ConnectInstance.INSTANCE.getInstance().post("DeleteMaterial "+materialTable.getSelectionModel().getSelectedItem().getMaterialId());
            AlertBox.display("SUCCESS", "Поле успешно удалено!");
        }else AlertBox.display("WARNING", "Выберите поле!");
    }

    @FXML
    void deleteService(ActionEvent event) {
        if(serviceTable.getSelectionModel() != null){
            ConnectInstance.INSTANCE.getInstance().post("DeleteService "+serviceTable.getSelectionModel().getSelectedItem().getServiceId());
            AlertBox.display("SUCCESS", "Поле успешно удалено!");
        }else AlertBox.display("WARNING", "Выберите поле!");
    }

    @FXML
    void deleteWorker(ActionEvent event) {
        if (workersTable.getSelectionModel()!=null){
            ConnectInstance.INSTANCE.getInstance().post("DeleteWorker "+workersTable.getSelectionModel().getSelectedItem().getWorkerNumber());
            AlertBox.display("SUCCESS", "Поле успешно удалено!");
        }else AlertBox.display("WARNING", "Выберите поле!");

    }

    @FXML
    void initialize() {
        //Worker
        workerNumber.setCellValueFactory(new PropertyValueFactory<>("workerNumber"));
        workerName.setCellValueFactory(new PropertyValueFactory<>("workerName"));
        workerLastName.setCellValueFactory(new PropertyValueFactory<>("workerLastName"));
        workerService.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        workerSallary.setCellValueFactory(new PropertyValueFactory<>("workerSallary"));

        //Service
        serbiceNumber.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
        serviceName.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        servicePrice.setCellValueFactory(new PropertyValueFactory<>("servicePrice"));

        //Material
        materialNumber.setCellValueFactory(new PropertyValueFactory<>("materialId"));
        materialName.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        materialPrice.setCellValueFactory(new PropertyValueFactory<>("materialPrice"));

        fillTable();
    }

    void fillTable(){
        ConnectInstance.INSTANCE.getInstance().post("WorkerTableCreate .");
        ObservableList<Worker> workers = WorkersProcessing.returnAllWorkers();
        workersTable.setItems(workers);

        ConnectInstance.INSTANCE.getInstance().post("returnServices .");
        ObservableList<Service> services = ServicesProcessing.createTable();
        serviceTable.setItems(services);

        ConnectInstance.INSTANCE.getInstance().post("MaterialTableCreate .");
        ObservableList<Material> materials = MaterialsPrcessing.returnAllMaterials();
        materialTable.setItems(materials);
    }
}

*/
