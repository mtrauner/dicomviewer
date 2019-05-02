package at.spengergasse.trauner.interfaces;

import at.spengergasse.trauner.entities.Instance;
import at.spengergasse.trauner.entities.Patient;
import at.spengergasse.trauner.entities.Series;
import at.spengergasse.trauner.entities.Study;

public interface IPatientBrowser {

    /**
     * Gibt ausgewählten Patienten im PatientBrowser zurück
     * @return Patient
     */
    Patient SelectedPatient();
    /**
     * Gibt ausgewählte Studie im PatientBrowser zurück
     * @return Studie
     */
    Study SelectedStudy();
    /**
     * Gibt ausgewählte Serie im PatientBrowser zurück
     * @return Serie
     */
    Series SelectedSeries();
    /**
     * Gibt ausgewähltes Bild im PatientBrowser zurück
     * @return Bild
     */
    Instance SelectedInstance();
}
