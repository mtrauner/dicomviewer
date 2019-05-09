package at.spengergasse.trauner.tools;

import at.spengergasse.trauner.interfaces.ILookupTable;
import at.spengergasse.trauner.interfaces.IObservable;
import at.spengergasse.trauner.interfaces.IObserver;

public class LookupTable implements ILookupTable {

    private int width;
    private int centre;
    private int alpha;

    public int Argb(int intensity){
        int y = (intensity-centre+width/2)*255/width;
        if(y > 255){
            y = 255;
        }
        if(y < 0){
            y = 0;
        }
        return alpha << 24 | y << 16| y << 8 | y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width > 0) {
            this.width = width;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public int getCentre() {
        return centre;
    }

    public void setCentre(int centre) {
        this.centre = centre;
    }
    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        if(alpha >= 0 && alpha <= 255) {
            this.alpha = alpha;
        }
        else{
            throw new IllegalArgumentException();
        }
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
