package at.spengergasse.hbgm.GUI;

import at.spengergasse.hbgm.interfaces.*;
import at.spengergasse.hbgm.tools.Builder;
import at.spengergasse.hbgm.tools.LookupTable;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ImagePanel extends JPanel implements IImagePanel {

    private BufferedImage image;
    private File dcmFile;
    private IPatientBrowser browser;


    private void LoadImage(){
        try {
            dcmFile = new File("images/ABF2AD3A.dcm");
            LookupTable lt = new LookupTable();
            DicomInputStream dcmIn = new DicomInputStream(dcmFile);
            DicomObject dcmObj = dcmIn.readDicomObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImagePanel(){
        LoadImage();
        //this.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if(image != null){
            graphics.drawImage(image,0,0,this);
        }
    }

    @Override
    public void Configure(Builder builder) {
        browser = builder.getPatientBrowser();
        browser.registerObserver(this);
    }

    @Override
    public JComponent UIComponent() {
        return this;
    }

    @Override
    public void registerObserver(IObserver o) {

    }

    @Override
    public void removeObserver(IObserver o) {

    }

    @Override
    public void changed(IObservable o) {
        browser.GewaehlteInstanz();
    }
}
