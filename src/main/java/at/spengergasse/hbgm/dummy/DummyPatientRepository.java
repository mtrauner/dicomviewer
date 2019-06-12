package at.spengergasse.hbgm.dummy;

import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.entities.Patient;
import at.spengergasse.hbgm.entities.Series;
import at.spengergasse.hbgm.entities.Study;
import at.spengergasse.hbgm.interfaces.*;
import at.spengergasse.hbgm.interfaces.IImagePanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;
import at.spengergasse.hbgm.GUI.MainWindow;


import java.util.List;

public class DummyPatientRepository implements IPatientRepository {

    @Override
    public void registerObserver(IObserver o) {

    }

    @Override
    public void removeObserver(IObserver o) {

    }

    @Override
    public void changed(IObservable o) {

    }

    @Override
    public List<Patient> GetPatients() throws Exception {
        return null;
    }

    @Override
    public void Hinzufuegen(Patient p) throws Exception {

    }

    @Override
    public void Entfernen(Patient p) throws Exception {

    }

    @Override
    public void Configure(Builder builder) {

    }
}
