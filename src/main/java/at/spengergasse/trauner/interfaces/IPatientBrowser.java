package at.spengergasse.trauner.interfaces;


import at.spengergasse.trauner.entities.Instance;
import at.spengergasse.trauner.entities.Patient;
import at.spengergasse.trauner.entities.Series;
import at.spengergasse.trauner.entities.Study;

/**
 * a patient browser shows all the patients, studies, ...
 * available in the patient repository.
 * it must actively retrieve this information from the patient repository
 */
public interface IPatientBrowser extends IModuleBase, IModuleUI {
    /**
     * return patient which is currently selected
     * or which is owner of the currently selected object.
     * @return selected patient or null if none
     */
    Patient GewaehlterPatient();

    /**
     * return study which is currently selected
     * or which is owner of the currently selected object;
     * (returns null if selected object is a patient)
     * @return selected study or null if none
     */
    Study GewaehlteStudie();

    /**
     * return series which is currently selected
     * or which is owner of the currently selected Instance;
     * (returns null if selected object is a patient or a study)
     * @return selected series or null if none
     */
    Series GewaehlteSerie();

    /**
     * return Instance which is currently selected
     * (returns null if selected object is a patient, study or series)
     * @return selected series or null if none
     */
    Instance GewaehlteInstanz();
}
