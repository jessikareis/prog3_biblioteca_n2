package br.edu.femass.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;

public class InicioController implements Initializable {

    @FXML
    private TabPane containerTab;

    @FXML
    private Tab inicioTab;
    
    @FXML
    private AnchorPane inicioContainer;

    @FXML
    private Tab cadastrarLeitoresTab;

    @FXML
    private AnchorPane cadastrarLeitoresContainer;

    @FXML
    private Tab cadastrarAutoresTab;

    @FXML
    private AnchorPane cadastrarAutoresContainer;

    @FXML
    private Tab cadastrarLivrosTab;

    @FXML
    private AnchorPane cadastrarLivrosContainer;

    @FXML
    private Tab emprestimoTab;

    @FXML
    private AnchorPane emprestimoContainer;

    //tamanho menu
    private double tabWidth = 90.0;
    public static  int lastSelectedTabIndex = 0;
    
    private void configureView() {
        containerTab.setTabMinWidth(tabWidth);
        containerTab.setTabMaxWidth(tabWidth);
        containerTab.setTabMinHeight(tabWidth);
        containerTab.setTabMaxHeight(tabWidth);
        containerTab.setRotateGraphic(true);

        EventHandler<Event> replaceBackgroundColorHandler = event ->{
            lastSelectedTabIndex = containerTab.getSelectionModel().getSelectedIndex();

            Tab currentTab = (Tab) event.getTarget();
            if(currentTab.isSelected()){
                currentTab.setStyle("-fx-background-color: -fx-focus-color;");
            }else{
                currentTab.setStyle("-fx-background-color: -fx-accent;");
            }
        };

        configureTab(inicioTab,"Início", "/images/inicio.png", inicioContainer,"/fxml/Inicio.fxml",replaceBackgroundColorHandler);
        configureTab(cadastrarAutoresTab, "Cadastrar Autores", "/images/autor.png", cadastrarAutoresContainer, "/fxml/Autor.fxml", replaceBackgroundColorHandler);
        configureTab(cadastrarLeitoresTab, "Cadastrar Leitores", "/images/leitor.png", cadastrarLeitoresContainer, "/fxml/Leitor.fxml", replaceBackgroundColorHandler);
        configureTab(cadastrarLivrosTab, "Cadastrar Livros", "/images/livro.png", cadastrarLivrosContainer, "/fxml/Livro.fxml", replaceBackgroundColorHandler);
        configureTab(emprestimoTab, "Emprestimo", "/images/emprestimo.png", emprestimoContainer, "/fxml/Emprestimo.fxml", replaceBackgroundColorHandler);

        inicioTab.setStyle("-fx-background-color: -fx-focus-color;");
    }

    private void configureTab(Tab tab, String title, String iconPath, AnchorPane containerPane, String resourceURL, EventHandler<Event> onSelectionChangedEvent) {
        double imageWidth = 40.0;

        ImageView imageView = new ImageView(new Image(iconPath));
        imageView.setFitHeight(imageWidth);
        imageView.setFitWidth(imageWidth);

        Label label = new Label(title);
        label.setMaxWidth(tabWidth - 20);
        label.setPadding(new Insets(5, 0, 0, 0));
        label.setStyle("-fx-text-fill: black; -fx-font-size: 8pt; -fx-font-weight: normal;");
        label.setTextAlignment(TextAlignment.CENTER);

        BorderPane tabPane = new BorderPane();
        Parent contentView;
        try {
            contentView = FXMLLoader.load(getClass().getResource(resourceURL));
            Node screen = contentView.getParent();
            tabPane.setCenter(screen);

            tabPane.setRotate(90.0);
            tabPane.setMaxWidth(tabWidth);

            tabPane.setBottom(label);

            tab.setText("");
            tab.setGraphic(tabPane);

            tab.setOnSelectionChanged(onSelectionChangedEvent);

            if (containerPane!= null && resourceURL != null){
                AnchorPane.setTopAnchor(contentView, 0.0);
                AnchorPane.setBottomAnchor(contentView, 0.0);
                AnchorPane.setRightAnchor(contentView, 0.0);
                AnchorPane.setLeftAnchor(contentView, 0.0);
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureView();
        System.out.println("Passei aqui");
    }

    
}
