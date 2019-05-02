package at.spengergasse.trauner.interfaces;

import at.spengergasse.trauner.entities.Patient;

import java.util.List;

public interface IPatientRepository {

    /**
     * Gibt Collection mit allen Patienten zurück
     * @return Liste von Patienten
     */
    List<Patient> GetPatients();
    /**
     * Füge Patient zur Liste hinzu
     * @param p Hinzuzufügender Patient
     */
    void AddPatient(Patient p);
    /**
     * Lösche Patienten aus Liste
     * @param p Zu löschender Patient
     */
    void RemovePatient(Patient p);
}
