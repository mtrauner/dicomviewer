package at.spengergasse.hbgm.GUI;

import at.spengergasse.hbgm.interfaces.IInfoPanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IPatientBrowser;
import at.spengergasse.hbgm.tools.Builder;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class InfoPanel extends JPanel implements IInfoPanel {

    private IPatientBrowser browser;

    public InfoPanel(){

    }

    @Override
    public void Configure(Builder builder) {
        browser = builder.getPatientBrowser();
        browser.registerObserver(this);
    }

    @Override
    public JComponent UIComponent() {
        return this;
    }

    @Override
    public void registerObserver(IObserver o) {

    }

    @Override
    public void removeObserver(IObserver o) {

    }

    @Override
    public void changed(IObservable o) {
        browser.GewaehlteInstanz();
    }
}
