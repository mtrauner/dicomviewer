package at.spengergasse.hbgm.GUI;

import at.spengergasse.hbgm.interfaces.IInfoPanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;

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
