package at.spengergasse.hbgm.tools;

import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IPixelMapper;

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
