package at.spengergasse.hbgm;

import at.spengergasse.hbgm.GUI.*;
import at.spengergasse.hbgm.tools.*;

import javax.swing.*;

public class App 
{
    public static void main( String[] args ) throws Exception {

        Builder builder = new Builder();
        builder.setInfoPanel(new InfoPanel());
        builder.setImagePanel(new ImagePanel());
        builder.setControlPanel(new ControlPanel());
        builder.setFileLoader(new FileLoader());
        builder.setLookupTable(new LookupTable());
        builder.setPixelMapper(new PixelMapper());
        builder.setPatientRepository(new PatientRepository());
        builder.setPatientBrowser(new PatientBrowser());
        builder.Configure();
        
        MainWindow mw = new MainWindow(builder);
        mw.setSize(1000,800);
        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mw.setVisible(true);
    }
}
