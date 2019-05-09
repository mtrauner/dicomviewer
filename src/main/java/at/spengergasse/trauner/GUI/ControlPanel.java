package at.spengergasse.trauner.GUI;

import at.spengergasse.trauner.interfaces.IControlPanel;
import at.spengergasse.trauner.interfaces.IObservable;
import at.spengergasse.trauner.interfaces.IObserver;
import at.spengergasse.trauner.tools.Builder;

import javax.swing.*;

public class ControlPanel extends JPanel implements IControlPanel {
    @Override
    public int getCenter() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getAlpha() {
        return 0;
    }

    @Override
    public void Configure(Builder builder) {
//ugujgg
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
