package at.spengergasse.hbgm.GUI;

import at.spengergasse.hbgm.interfaces.IControlPanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class ControlPanel extends JPanel implements IControlPanel {


    public  ControlPanel(){

    }

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
    public void Configure(Builder builder) {

    }
    static final int FPS_MIN = 0;
    static final int FPS_MAX = 30;
    static final int FPS_INIT = 15;

    @Override
    public JComponent UIComponent() {
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout();
        grid.setColumns(1);
        grid.setRows(3);
        JSlider center = new JSlider(JSlider.HORIZONTAL,FPS_MIN,FPS_MAX,FPS_INIT);
        JSlider alpha = new JSlider(JSlider.HORIZONTAL,FPS_MIN,FPS_MAX,FPS_INIT);
        center.setSize(100,20);
        center.setMinimum(1);
        center.setMaximum(255);
        alpha.setSize(100,20);
        alpha.setMinimum(1);
        alpha.setMaximum(255);
        grid.addLayoutComponent("center",center);
        grid.addLayoutComponent("alpha",alpha);

        panel.setLayout(grid);
        return panel;

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
