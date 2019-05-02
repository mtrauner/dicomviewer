package at.spengergasse.trauner.interfaces;

import at.spengergasse.trauner.entities.Instance;

import java.awt.image.BufferedImage;

public interface IPixelMapper {

    /**
     * Erstellt Bild aus DICOM-Bild
     * @param i ausgewähltes DICOM-Bild
     * @return Bild
     */
    BufferedImage map(Instance i);
}
