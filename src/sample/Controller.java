package sample;
import Logica.*;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import util.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private ObservableList<Fila> data;
    private Gestor gestor;
    private Reloj reloj1;
    public Controller() {
        this.gestor=new Gestor();
        this.reloj1= Reloj.getInstancia();
        this.tvSim=new TableView<>();
    }

    @FXML
    private TableView<Fila> tvSim;
    @FXML
    private TableColumn<Fila, String>reloj;
    @FXML
    private TableColumn<Fila, String>event;
    @FXML
    private TableColumn<Fila, String>camion;
    @FXML
    private TableColumn<Fila, String>rnd1;
    @FXML
    private TableColumn<Fila, String>tiempoEntreLlegadas;
    @FXML
    private TableColumn<Fila, String>prox;
    @FXML
    private TableColumn<Fila, String> colaRecepcion;
    @FXML
    private TableColumn<Fila, String>camionRecepcion;
    @FXML
    private TableColumn<Fila, String>estadoRecepcion;
    @FXML
    private TableColumn<Fila, String>rndRecepcion;
    @FXML
    private TableColumn<Fila, String>tiempoLlegadaRecepcion;
    @FXML
    private TableColumn<Fila, String>proxFinAtencionRecepcion;
    @FXML
    private TableColumn<Fila, String>colaRecep;
    @FXML
    private TableColumn<Fila, String>camionBalanz;
    @FXML
    private TableColumn<Fila, String>estadBalanza;
    @FXML
    private TableColumn<Fila, String>rndBalanz;
    @FXML
    private TableColumn<Fila, String> tiempoAtencionBalanz;
    @FXML
    private TableColumn<Fila, String> proxFinAtBalan;
    @FXML
    private TableColumn<Fila, String> colaBalan;
    @FXML
    private TableColumn<Fila, String> camionDarsen1;
    @FXML
    private TableColumn<Fila, String> estadoDarsen1;
    @FXML
    private TableColumn<Fila, String> rndDarsen1;
    @FXML
    private TableColumn<Fila, String> tiempoAtencionDarse1;
    @FXML
    private TableColumn<Fila, String> finAtencionProxDarse1;
    @FXML
    private TableColumn<Fila, String> camionDarse2;
    @FXML
    private TableColumn<Fila, String> estadoDarse2;
    @FXML
    private TableColumn<Fila, String> rndDarse2;
    @FXML
    private TableColumn<Fila, String> tiempoAtDarse2;
    @FXML
    private TableColumn<Fila, String> proxFinAtDarse2;


    public void cargarTabla()
    {
        this.gestor.inicio();
        data=gestor.getData();

        tvSim.setItems(data);
    }

    public void setearColummnas()
    {
        reloj.setCellValueFactory(new PropertyValueFactory<>("reloj"));
        event.setCellValueFactory(new PropertyValueFactory<>("event"));
        camion.setCellValueFactory(new PropertyValueFactory<>("camion"));
        tiempoEntreLlegadas.setCellValueFactory(new PropertyValueFactory<>("tiempoEntreLlegadas"));
        colaRecepcion.setCellValueFactory(new PropertyValueFactory<>("colaRecepcion"));
        prox.setCellValueFactory(new PropertyValueFactory<>("prox"));
        camionRecepcion.setCellValueFactory(new PropertyValueFactory<>("camionRecepcion"));
        estadoRecepcion.setCellValueFactory(new PropertyValueFactory<>("estadoRecepcion"));
        rndRecepcion.setCellValueFactory(new PropertyValueFactory<>("rndRecepcion"));
        tiempoLlegadaRecepcion.setCellValueFactory(new PropertyValueFactory<>("tiempoLlegadaRecepcion"));
        proxFinAtencionRecepcion.setCellValueFactory(new PropertyValueFactory<>("proxFinAtencionRecepcion"));
        colaRecep.setCellValueFactory(new PropertyValueFactory<>("colaRecep"));
        camionBalanz.setCellValueFactory(new PropertyValueFactory<>("camionBalanz"));
        estadBalanza.setCellValueFactory(new PropertyValueFactory<>("estadBalanza"));
        tiempoAtencionBalanz.setCellValueFactory(new PropertyValueFactory<>("tiempoAtencionBalanz"));
        proxFinAtBalan.setCellValueFactory(new PropertyValueFactory<>("proxFinAtBalan"));
        colaBalan.setCellValueFactory(new PropertyValueFactory<>("colaBalan"));
        rndBalanz.setCellValueFactory(new PropertyValueFactory<>("rndBalanz"));
        camionDarsen1.setCellValueFactory(new PropertyValueFactory<>("camionDarsen1"));
        estadoDarsen1.setCellValueFactory(new PropertyValueFactory<>("estadoDarsen1"));
        rndBalanz.setCellValueFactory(new PropertyValueFactory<>("rndBalanz"));
        rndDarsen1.setCellValueFactory(new PropertyValueFactory<>("rndDarsen1"));
        tiempoAtencionDarse1.setCellValueFactory(new PropertyValueFactory<>("tiempoAtencionDarse1"));
        finAtencionProxDarse1.setCellValueFactory(new PropertyValueFactory<>("finAtencionProxDarse1"));
        camionDarse2.setCellValueFactory(new PropertyValueFactory<>("camionDarse2"));
        estadoDarse2.setCellValueFactory(new PropertyValueFactory<>("estadoDarse2"));
        rndDarse2.setCellValueFactory(new PropertyValueFactory<>("rndDarse2"));
        tiempoAtDarse2.setCellValueFactory(new PropertyValueFactory<>("tiempoAtDarse2"));
        proxFinAtDarse2.setCellValueFactory(new PropertyValueFactory<>("proxFinAtDarse2"));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setearColummnas();
        this.cargarTabla();
    }
}
