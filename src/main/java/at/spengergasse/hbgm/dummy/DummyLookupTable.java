package at.spengergasse.hbgm.dummy;

import at.spengergasse.hbgm.interfaces.*;
import at.spengergasse.hbgm.interfaces.IImagePanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;
import at.spengergasse.hbgm.GUI.MainWindow;

public class DummyLookupTable implements ILookupTable {


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
    public int Argb(int intensity) {
        return 0;
    }

    @Override
    public void Configure(Builder builder) {

    }
}
