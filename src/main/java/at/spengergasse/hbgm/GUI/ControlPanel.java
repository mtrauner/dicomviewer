package at.spengergasse.hbgm.GUI;

import at.spengergasse.hbgm.interfaces.IControlPanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.HashSet;
import java.util.Set;

public class ControlPanel extends JPanel implements IControlPanel {

    public ControlPanel(){

    }

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

    }
}
