package at.spengergasse.hbgm.dummy;

import at.spengergasse.hbgm.interfaces.IControlPanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IControlPanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;

import javax.swing.*;

public class DummyControlPanel implements IControlPanel {

    @Override
    public int getWindowCenter() {
        return 0;
    }

    @Override
    public int getWindowWidth() {
        return 0;
    }

    @Override
    public int getAlpha() {
        return 0;
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

    @Override
    public void Configure(Builder builder) {

    }

    @Override
    public JComponent UIComponent() {
        return null;
    }
}
