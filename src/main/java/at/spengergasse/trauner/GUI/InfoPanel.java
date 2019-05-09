package at.spengergasse.trauner.GUI;

import at.spengergasse.trauner.interfaces.IInfoPanel;
import at.spengergasse.trauner.interfaces.IObservable;
import at.spengergasse.trauner.interfaces.IObserver;
import at.spengergasse.trauner.tools.Builder;

import javax.swing.*;

public class InfoPanel extends JPanel implements IInfoPanel {
    @Override
    public void Configure(Builder builder) {

    }

    @Override
    public JComponent UIComponent() {
        return null;
    }

    @Override
    public void registerObserver(IObserver o) {

    }

    @Override
    public void removeObserver(IObserver o) {

    }

    @Override
    public void changed(IObservable o) {

    }
}
