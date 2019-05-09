package at.spengergasse.trauner.tools;

import at.spengergasse.trauner.entities.Instance;
import at.spengergasse.trauner.interfaces.IObservable;
import at.spengergasse.trauner.interfaces.IObserver;
import at.spengergasse.trauner.interfaces.IPixelMapper;

import java.awt.image.BufferedImage;

public class PixelMapper implements IPixelMapper {
    @Override
    public BufferedImage Map(Instance instance) throws Exception {
        return null;
    }

    @Override
    public void Configure(Builder builder) {

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
