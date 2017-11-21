package com.teamb.controller;

import com.teamb.view.BasicView;
import com.teamb.view.SignUpView;
import javafx.stage.Stage;

public class SignUpController extends BasicController {

    SignUpView view;

    public SignUpController(Stage s){
        super(s);
        view = new SignUpView(this);
    }
    @Override
    public BasicView GetView() {
        return view;
    }
}
