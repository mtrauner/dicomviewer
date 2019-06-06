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

import javax.swing.*;

public class DummyPatientBrowser implements IPatientBrowser {

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
        return new JLabel("dummy patient browser");
    }
}
