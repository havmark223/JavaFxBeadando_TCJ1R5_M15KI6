package com.example.javafxbea;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ParhuzamosController extends SceneController implements Initializable {

    @FXML
    public Label firstThreadLabel;

    @FXML
    public Label secondThreadLabel;

    public void StartClicked(ActionEvent event) {
        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int prog=0;
                for(int i =0;i<10;i++)
                {
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();;
                    }
                    prog += 1;
                    String thread = "Érték: "+ prog;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            firstThreadLabel.setText(thread);
                        }
                    });
                }
            }
        });

        Thread taskThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int prog=0;
                for (int i = 0; i<10;i++)
                {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    prog+=1;
                    String thread ="Érték: "+ prog;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            secondThreadLabel.setText(thread);
                        }
                    });
                }
            }
        });

        taskThread.start();
        taskThread2.start();
    }
}
