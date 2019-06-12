package at.spengergasse.hbgm.tools;

import at.spengergasse.hbgm.GUI.ImagePanel;
import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.interfaces.IImagePanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IPixelMapper;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static org.eclipse.persistence.config.CacheUsageIndirectionPolicy.Exception;

public class PixelMapper implements IPixelMapper {

    private Set<IObserver> observers = new HashSet<IObserver>();

    private LookupTable lt;
    private IImagePanel imgpanel;


    @Override
    public BufferedImage Map(Instance instance) throws Exception {
        lt = new LookupTable();
        DicomInputStream dcmIn = new DicomInputStream(instance.getDicomFile());
        DicomObject dcmObj = dcmIn.readDicomObject();
        short[] pixelData = dcmObj.getShorts(Tag.PixelData);
        short maxValue = pixelData[0];
        short minValue = pixelData[0];
        int columns = dcmObj.getInt(Tag.Columns);
        int rows = dcmObj.getInt(Tag.Rows);
        int pixels = columns * rows;
        int meanValue;
        int sum = 0;

        for(int i = 0; i<pixelData.length; i++){
            if(pixelData[i] > maxValue){
                maxValue = pixelData[i];
            }
        }
        for(int i = 0; i<pixelData.length; i++){
            if(pixelData[i] < minValue){
                minValue = pixelData[i];
            }
        }
        for(int i = 0; i<pixelData.length; i++){
            sum+=pixelData[i];
        }
        meanValue = sum/pixels;
        BufferedImage image = new BufferedImage(columns,rows,BufferedImage.TYPE_INT_ARGB);
        lt.setAlpha(255);
        lt.setCentre(meanValue);
        lt.setWidth(maxValue);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                image.setRGB(c, r, lt.Argb(pixelData[r * columns + c]));
            }
        }
        return image;
    }

    @Override
    public void Configure(Builder builder) {
        imgpanel = builder.getImagePanel();
        imgpanel.registerObserver(this);
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void changed(IObservable o) {

    }
}
