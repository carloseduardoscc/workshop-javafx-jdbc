package gui;

import application.Main;
import gui.utils.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;


    @FXML
    public void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction(){
        loadView2("gui/DepartmentList.fxml");
    }

    @FXML
    public void onMenuItemAboutAction(){
        loadView("gui/AboutView.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private synchronized void loadView (String absolutePath){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(absolutePath));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = ((VBox) ((ScrollPane) mainScene.getRoot()).getContent());

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
        }
        catch(IOException e){
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    //TEMPORÁRIO
    private synchronized void loadView2 (String absolutePath){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(absolutePath));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = ((VBox) ((ScrollPane) mainScene.getRoot()).getContent());

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            DepartmentViewController departmentViewController = loader.getController();
            departmentViewController.setDepartmentService(new DepartmentService());
            departmentViewController.updateTableView();
        }
        catch(IOException e){
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
