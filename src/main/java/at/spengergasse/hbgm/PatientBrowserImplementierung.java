package at.spengergasse.hbgm;

import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.entities.Patient;
import at.spengergasse.hbgm.entities.Series;
import at.spengergasse.hbgm.entities.Study;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IPatientBrowser;
import at.spengergasse.hbgm.tools.Builder;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class PatientBrowserImplementierung extends JTree implements IPatientBrowser {
    private Set<IObserver> meineObserver = new HashSet<>();

    public PatientBrowserImplementierung(){
        this.addTreeSelectionListener(x ->{
            //Benachrichtigung aller Observer
            for(IObserver o: meineObserver){
                o.changed(this);
            }
        });
    }

    @Override
    public Patient GewaehlterPatient() {
        return null;
    }

    @Override
    public Study GewaehlteStudie() {
        return null;
    }

    @Override
    public Series GewaehlteSerie() {
        return null;
    }

    @Override
    public Instance GewaehlteInstanz() {
        return null;
    }

    @Override
    public void Configure(Builder builder) {

    }

    @Override
    public JComponent UIComponent() {
        return this;
    }

    @Override
    public void registerObserver(IObserver o) {
        meineObserver.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        meineObserver.remove(o);
    }

    @Override
    public void changed(IObservable o) {


    }
}
