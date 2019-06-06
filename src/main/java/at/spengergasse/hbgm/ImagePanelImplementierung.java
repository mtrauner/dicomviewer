package at.spengergasse.hbgm;

import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.interfaces.*;
import at.spengergasse.hbgm.tools.Builder;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImagePanelImplementierung extends JPanel implements IImagePanel {

    private IPatientBrowser browser;
    private BufferedImage image;
    private IPixelMapper pixelmapper;

    @Override
    public void Configure(Builder builder) {
        browser = builder.getPatientBrowser();
        pixelmapper = builder.getPixelMapper();
        browser.registerObserver(this);
    }

    protected void paintComponent(){

    }
    @Override
    public JComponent UIComponent() {
        return null;
    }

    @Override
    public void registerObserver(IObserver o) {

    }

    @Override
    public void removeObserver(IObserver o) {

    }

    @Override
    public void changed(IObservable o) {
        //hole ausgwählte Instaz
        Instance i = browser.GewaehlteInstanz();
        //---> Bild darstellen
        if(i !=null){
            try{
                image = pixelmapper.Map(i);
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }
}
