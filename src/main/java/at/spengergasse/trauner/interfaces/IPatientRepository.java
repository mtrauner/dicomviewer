package at.spengergasse.trauner.interfaces;


import at.spengergasse.trauner.entities.Patient;

import java.util.List;

/**
 * a patient repository maintains all the patient data
 * (and contained studies, series, instances)
 * which were already loaded by add() and not yet
 * removed by remove().
 * The data should be persisted in a database
 */
public interface IPatientRepository extends IModuleBase {

    /**
     * returns a list of all the patients (plus studies, ...)
     * known by this patient repository
     * @return reference to patient list
     * @throws Exception in case of database errors
     */
    List<Patient> GetPatients() throws Exception;

    /**
     * add a patient (plus contained studies, series, ...)
     * to the repository.
     * if the patient already exists in the repository
     * it must be ensured that all the studies, series, ...
     * are inserted in the existing patient's studies, series, ... lists
     * @param p patient to be added
     * @throws Exception in case of database errors
     */
    void Hinzufuegen(Patient p) throws Exception;

    /**
     * removes a patient and all his studies, series, instances
     * from the repository (and also from the database)
     * @param p reference to the patient to be removed
     * @throws Exception in case of database errors
     */
    void Entfernen(Patient p) throws Exception;
}
