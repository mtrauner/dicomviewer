package at.spengergasse.hbgm.dummy;

import at.spengergasse.hbgm.interfaces.IFileLoader;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;
import at.spengergasse.hbgm.interfaces.IFileLoader;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;
import at.spengergasse.hbgm.GUI.MainWindow;

import java.io.File;

public class DummyFileLoader implements IFileLoader {
    @Override
    public void LadeVerzeichnis(File folder) throws Exception {

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
}
