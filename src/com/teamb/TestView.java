package com.teamb;

import com.teamb.controller.EventController;
import com.teamb.controller.LoginViewController;
import com.teamb.controller.StaffEventProfileController;
import com.teamb.view.EventView;
import com.teamb.view.LoginView;
import com.teamb.view.StaffEventProfileView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.teamb.model.Event;

public class TestView extends Application{
    Stage newStage;

    @Override
    public void start(Stage primaryStage) {

        newStage = primaryStage;
        //LoginView lginView = new LoginView(newStage);
        Event event = new Event(19844930, "Call of duty", "Blah blh", 8, 67);
        StaffEventProfileController sc =  new StaffEventProfileController(newStage, event);

        Scene scene = new Scene(sc.GetView().GetRootPane(), 720, 540);

        primaryStage.setTitle("Volunteerize");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

