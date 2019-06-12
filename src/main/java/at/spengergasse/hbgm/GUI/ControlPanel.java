package at.spengergasse.hbgm.GUI;

import at.spengergasse.hbgm.interfaces.IControlPanel;
import at.spengergasse.hbgm.interfaces.IImagePanel;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.tools.Builder;

import javax.persistence.Convert;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class ControlPanel extends JTree implements IControlPanel {
    private Set<IObserver> observers = new HashSet<>();

    private IImagePanel imgpanel;

    public  ControlPanel(){
        this.addTreeSelectionListener(x ->{
            //Benachrichtigung aller Observer
            for(IObserver o: observers){
                o.changed(this);
            }
        });
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
        return this;
        /*
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
        //grid.addLayoutComponent("center",center);
        //grid.addLayoutComponent("alpha",alpha);
        JFrame meinJFrame = new JFrame();
        meinJFrame.setSize(300, 100);
        meinJFrame.setTitle("JSlider Beispiel");
        JPanel meinPanel = new JPanel();

        // JSlider-Objekt wird erzeugt
        JSlider meinSlider = new JSlider();

        // Mindestwert wird gesetzt
        meinSlider.setMinimum(0);
        // Maximalwert wird gesetzt
        meinSlider.setMaximum(20);

        // Die Abstände zwischen den
        // Teilmarkierungen werden festgelegt
        meinSlider.setMajorTickSpacing(5);
        meinSlider.setMinorTickSpacing(1);

        // Standardmarkierungen werden erzeugt
        meinSlider.createStandardLabels(1);

        // Zeichnen der Markierungen wird aktiviert
        meinSlider.setPaintTicks(true);

        // Zeichnen der Labels wird aktiviert
        meinSlider.setPaintLabels(true);

        // Schiebebalken wird auf den Wert 9 gesetzt
        meinSlider.setValue(9);

        // Schiebebalken wird dem Panel hinzugefügt
        meinPanel.add(meinSlider);
        meinPanel.add(alpha);

        meinJFrame.add(meinPanel);
        meinJFrame.setVisible(true);

        panel.setLayout(grid);
        return meinPanel;
/*/
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
