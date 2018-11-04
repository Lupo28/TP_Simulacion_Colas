package sample;
import Logica.Reloj;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import util.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class Controller {

    private ObservableList<Fila> data;

    public Controller() {
        data = FXCollections.observableArrayList();
    }

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
    private TableColumn<Fila, String> colaBalanz;
    @FXML
    private TableColumn<Fila, String> camionDarsen1;
    @FXML
    private TableColumn<Fila, String> estadoDarsen1;
    @FXML
    private TableColumn<Fila, String> rndmDarsen1;
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
        String relojContent = Reloj.getInstancia().tiempoString();
        String eventContent = "0";
        String camionContent="";
        String rnd1Content="";
        String tiempoEntreLlegadasContent="";
        String proxContent="";
        String colaRecepcionContent="";
        String camionRecepcionContent="";
        String estadoRecepcionContet="";
        String rndRecepcionContent="";
        String tiempoLlegadaRecepcionContent="";
        String proxFinAtencionRecepcionContent="";
        String colaRecepContent="";
        String camionBalanzContent="";
        String estadBalanzContent="";
        String rndBalanzaContent="";
        String tiempoAtencionBalanzContent="";
        String proxFinAtBalContent="";
        String colaBalanzContent="";
        String camionDarse1Content="";
        String estadoDarse1Content="";
        String rndmDarse1Content="";
        String tiempoAtencionDarse1Content="";
        String finAtencionProxDarse1Content="";
        String camionDarse2Content="";
        String estadoDarse2Content="";
        String rndDarse2Content="";
        String tiempoArDarse2Content="";
        String proxFinAtDarse2Content="";



//
//        data.addAll(new Fila(relojContent,eventContent,camionContent,rnd1Content,tiempoEntreLlegadasContent,proxContent,colaRecepcionContent,
//                camionRecepcionContent,estadoRecepcionContet,rndRecepcionContent,tiempoLlegadaRecepcionContent,proxFinAtencionRecepcionContent,
//        colaRecepContent,camionBalanzContent,estadBalanzContent,rndBalanzaContent,tiempoAtencionBalanzContent,proxFinAtBalContent,
//                colaBalanzContent,camionDarse1Content,estadoDarse1Content,rndmDarse1Content,tiempoAtencionDarse1Content,finAtencionProxDarse1Content,
//                camionDarse2Content,estadoDarse2Content,rndDarse2Content,tiempoArDarse2Content,proxFinAtDarse2Content));
//
//                reloj.setCellFactory(new PropertyValueFactory<>("reloj"));
//                event.setCellFactory(new PropertyValueFactory<>("event"));
    }





}
