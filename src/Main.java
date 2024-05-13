/**
 * @author <Martin Delahousse - s4034308>
 */

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import controller.loginController;

public class Main extends Application {

    static Manager manager;

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLs/Login.fxml"));
        Parent root = loader.load();
        loginController LoginController = loader.getController();
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("ICM");
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        //Create Scanner & Manager
//        Scanner in = new Scanner(System.in);
//        manager = new Manager();
//        String command;
//
//        //Intercept program stop to properly save data
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> manager.shutdown()));
//
//        //Quick function to display welcome information
//        welcome();
//
//        //Program loop
//        do {
//            command = in.nextLine();
//        } while (manager.exec(command));
//    }
//
//    public static void welcome() {
//        Printer.hint("Welcome to our insurance claim helper");
//        Printer.hint("------------------------------------------");
//        manager.exec("help");
//    }

}
