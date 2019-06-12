package at.spengergasse.hbgm.tools;

import at.spengergasse.hbgm.interfaces.IControlPanel;
import at.spengergasse.hbgm.interfaces.ILookupTable;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;

import java.util.HashSet;
import java.util.Set;

public class LookupTable implements ILookupTable {

    private int width;
    private int centre;
    private int alpha;

    private IControlPanel cp;

    private Set<IObserver> observers = new HashSet<>();

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
        cp = builder.getControlPanel();
        cp.registerObserver(this);
        width = cp.getWindowWidth();
        centre = cp.getWindowCenter();
        alpha = cp.getAlpha();
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void changed(IObservable o) {

    }
}
