package at.spengergasse.trauner;

import at.spengergasse.trauner.GUI.MainWindow;
import at.spengergasse.trauner.entities.Patient;
import at.spengergasse.trauner.entities.Study;

import javax.swing.*;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ){

        MainWindow mw = new MainWindow();
        mw.setSize(1000,800);
        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mw.setVisible(true);

    }
}
