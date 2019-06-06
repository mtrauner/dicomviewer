package at.spengergasse.hbgm.dummy;

import at.spengergasse.hbgm.interfaces.IImagePanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IImagePanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;
import at.spengergasse.hbgm.GUI.MainWindow;

import javax.swing.*;
import java.net.URL;

public class DummyImagePanel implements IImagePanel {

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
        URL url = getClass().getResource("/homer.jpg");
        //return new JLabel(new ImageIcon(url));
        return new JLabel("dummy image panel");
    }
}
