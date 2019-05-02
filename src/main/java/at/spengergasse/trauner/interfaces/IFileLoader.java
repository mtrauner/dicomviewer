package at.spengergasse.trauner.interfaces;

import java.io.File;

public interface IFileLoader {

    /**
     * Lade DICOM-Dateien aus Verzeichnis
     * @param f Verzeichnis
     */
    void LoadFolder(File f);
}
