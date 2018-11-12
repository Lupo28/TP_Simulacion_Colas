package sample;

import Logica.*;
import com.sun.javafx.scene.control.skin.NestedTableColumnHeader;
import com.sun.javafx.scene.control.skin.TableColumnHeader;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import com.sun.javafx.scene.control.skin.TableViewSkin;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.event.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;

public class Controller implements Initializable {

    private ObservableList<Fila> data;
    private Gestor gestor;
    private Reloj reloj1;

    public Controller() {
        this.gestor = new Gestor();
        this.reloj1 = Reloj.getInstancia();
        this.tvSim = new TableView<Fila>();
    }


    @FXML
    private Label txCamionesTotales;
    @FXML
    private Button btnsimular;
    @FXML
    private TextField txtDiaDesde;
    @FXML
    private TextField txtDiaHasta;
    @FXML
    private Label txAvgDurationService;
    @FXML
    private Label txCamionesNoAtendidos;
    @FXML
    private Label txCamionesXDia;
    @FXML
    private Pane paneMain;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<Fila> tvSim;
    @FXML
    private TableColumn<Fila, String> dia;
    @FXML
    private TableColumn<Fila, String> reloj;
    @FXML
    private TableColumn<Fila, String> event;
    @FXML
    private TableColumn<Fila, String> camion;
    @FXML
    private TableColumn<Fila, String> rnd1;
    @FXML
    private TableColumn<Fila, String> tiempoEntreLlegadas;
    @FXML
    private TableColumn<Fila, String> prox;
    @FXML
    private TableColumn<Fila, String> colaEnPuerta;
    @FXML
    private TableColumn<Fila, String> camionRecepcion;
    @FXML
    private TableColumn<Fila, String> estadoRecepcion;
    @FXML
    private TableColumn<Fila, String> rndRecepcion;
    @FXML
    private TableColumn<Fila, String> tiempoLlegadaRecepcion;
    @FXML
    private TableColumn<Fila, String> proxFinAtencionRecepcion;
    @FXML
    private TableColumn<Fila, String> colaRecepcion;
    @FXML
    private TableColumn<Fila, String> camionBalanz;
    @FXML
    private TableColumn<Fila, String> estadBalanza;
    @FXML
    private TableColumn<Fila, String> rndBalanz;
    @FXML
    private TableColumn<Fila, String> tiempoAtencionBalanz;
    @FXML
    private TableColumn<Fila, String> proxFinAtBalan;
    @FXML
    private TableColumn<Fila, String> colaBalanza;
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
    @FXML
    private TableColumn<Fila, String> colaDarsena;


    public void cargarTabla() {
        this.gestor.inicio();

        this.setearColummnas();

        ObservableList<Fila> list = gestor.getData();

        tvSim.setItems(list);
    }

    public void setearColummnas() {
        dia.setCellValueFactory(new PropertyValueFactory<>("dia"));
        reloj.setCellValueFactory(new PropertyValueFactory<>("reloj"));
        event.setCellValueFactory(new PropertyValueFactory<>("event"));
        colaEnPuerta.setCellValueFactory(new PropertyValueFactory<>("colaEnPuerta"));
        rnd1.setCellValueFactory(new PropertyValueFactory<>("rnd1"));
        camion.setCellValueFactory(new PropertyValueFactory<>("camion"));
        tiempoEntreLlegadas.setCellValueFactory(new PropertyValueFactory<>("tiempoEntreLlegadas"));
        //colaRecepcion.setCellValueFactory(new PropertyValueFactory<>("colaRecepcion"));
        prox.setCellValueFactory(new PropertyValueFactory<>("prox"));
        camionRecepcion.setCellValueFactory(new PropertyValueFactory<>("camionRecepcion"));
        estadoRecepcion.setCellValueFactory(new PropertyValueFactory<>("estadoRecepcion"));
        rndRecepcion.setCellValueFactory(new PropertyValueFactory<>("rndRecepcion"));
        tiempoLlegadaRecepcion.setCellValueFactory(new PropertyValueFactory<>("tiempoLlegadaRecepcion"));
        proxFinAtencionRecepcion.setCellValueFactory(new PropertyValueFactory<>("proxFinAtencionRecepcion"));
        colaRecepcion.setCellValueFactory(new PropertyValueFactory<>("colaRecepcion"));
        camionBalanz.setCellValueFactory(new PropertyValueFactory<>("camionBalanz"));
        estadBalanza.setCellValueFactory(new PropertyValueFactory<>("estadBalanza"));
        tiempoAtencionBalanz.setCellValueFactory(new PropertyValueFactory<>("tiempoAtencionBalanz"));
        proxFinAtBalan.setCellValueFactory(new PropertyValueFactory<>("proxFinAtBalan"));
        colaBalanza.setCellValueFactory(new PropertyValueFactory<>("colaBalanza"));
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
        colaDarsena.setCellValueFactory(new PropertyValueFactory<>("colaDarsena"));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    private void clearItemsInTableView() {
        tvSim.getItems().clear();
    }

    public void closeApp(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void openEstadisticas(ActionEvent event) throws Exception {
        setSimulationDialog();


    }

    private void setSimulationDialog() throws Exception {

        paneMain.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getResource("estadisticas.fxml")));


    }


    private void setStats() {
        txCamionesXDia.setText(gestor.promedioDeCamionesAtendidosPorDia());
        txCamionesTotales.setText(gestor.cantidadDeCamionesTotales());
        txCamionesNoAtendidos.setText(gestor.cantidadDeCamionesNoAtendidos());
        txAvgDurationService.setText(gestor.promedioDeTiempoDePermanencia());

    }

    @FXML
    void simulacionOnAction(ActionEvent event) {

        if (txtDiaDesde.getText() == null || txtDiaDesde.getText().trim().isEmpty()) {
            gestor.setDiaDesde(0);

        } else {
            gestor.setDiaDesde(Integer.valueOf(txtDiaDesde.getText()));
        }
        if (txtDiaHasta.getText() == null || txtDiaHasta.getText().trim().isEmpty()) {
            gestor.setDiaHasta(30);
        } else {
            gestor.setDiaHasta(Integer.valueOf(txtDiaHasta.getText()));
        }

        this.initializeNewSimulation();
        this.setStats();
    }


    public boolean verificadorDeDias(String txtFromDay, String txtToDay) {
        if (txtFromDay.equals("")) txtFromDay = "1";
        if (txtToDay.equals("")) txtToDay = "30";

        return isInDayRange(Integer.parseInt(txtFromDay), Integer.parseInt(txtToDay));
    }

    private boolean isInDayRange(Integer fromDay, Integer toDay) {
        return gestor.getDia() >= fromDay && gestor.getDia() <= toDay;
    }


    private void runOneStepAndAddToTable() {

        if (this.verificadorDeDias(txtDiaDesde.getText(), txtDiaHasta.getText())) {

        }
    }

    private void initializeNewSimulation() {

        this.resetSimulation();
    }

    private void resetSimulation() {
        txAvgDurationService.setText("0");
        txCamionesNoAtendidos.setText("0");
        txCamionesTotales.setText("0");
        txCamionesXDia.setText("0");
        this.gestor = new Gestor();
        Reloj.resetearReloj();
        clearItemsInTableView();
        cargarTabla();
    }

}
