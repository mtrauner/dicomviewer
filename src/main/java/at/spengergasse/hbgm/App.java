package at.spengergasse.hbgm;

import at.spengergasse.hbgm.GUI.MainWindow;

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
