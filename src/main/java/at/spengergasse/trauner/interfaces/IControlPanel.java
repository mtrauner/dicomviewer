package at.spengergasse.trauner.interfaces;

public interface IControlPanel {

    /**
     * Centre-Wert = Mittelwert der Pixelwerte
     * @return Centre
     */
    int GetCentre();

    /**
     * Width-Wert = maximaler Pixelwert
     * @return Width
     */
    int GetWidth();

    /**
     * Alpha-Wert
     * @return Alpha
     */
    int GetAlpha();
}