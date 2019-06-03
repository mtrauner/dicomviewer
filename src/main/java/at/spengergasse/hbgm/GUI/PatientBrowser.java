package at.spengergasse.hbgm.GUI;

import at.spengergasse.hbgm.tools.Builder;
import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.entities.Patient;
import at.spengergasse.hbgm.entities.Series;
import at.spengergasse.hbgm.entities.Study;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IPatientBrowser;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class PatientBrowser implements IPatientBrowser {

    private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
    private DefaultTreeModel model = new DefaultTreeModel(rootNode);
    private Set<IObserver> observers = new HashSet<>();
    private JTree tree = new JTree();

    public PatientBrowser(){
       // tree.addTreeSelectionListener(x -> selectionChanged());
        tree.setModel(model);
        tree.setCellRenderer(new Renderer());
    }

    private void selectionChanged(){
        for (IObserver o :observers){
            o.changed(this);
        }
    }

    public void add(Patient p){
        // patient is the "user object" of this node
        DefaultMutableTreeNode patientNode
                = new DefaultMutableTreeNode(p);
        rootNode.add(patientNode);
        for (Study st : p.getStudienListe()){
            // study is "user object" of this node
            DefaultMutableTreeNode studyNode
                    = new DefaultMutableTreeNode(st);
            patientNode.add(studyNode);
            for (Series se : st.getSerienListe()){
                // series is "user object" of this node
                DefaultMutableTreeNode seriesNode
                        = new DefaultMutableTreeNode(se);
                studyNode.add(seriesNode);
                for(Instance i : se.getInstanzenListe()){
                    // instance is "user object" of this node
                    DefaultMutableTreeNode instanceNode
                            = new DefaultMutableTreeNode(i);
                    seriesNode.add(instanceNode);
                }
            }
        }
        model.reload();
    }

    @Override
    public Patient GewaehlterPatient() {
        return null;
    }

    @Override
    public Study GewaehlteStudie() {
        return null;
    }

    @Override
    public Series GewaehlteSerie() {
        return null;
    }

    @Override
    public Instance GewaehlteInstanz() {
        return null;
    }

    @Override
    public void Configure(Builder builder) {

    }

    @Override
    public JComponent UIComponent() {
        return tree;
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

    private static class Renderer extends DefaultTreeCellRenderer{
        @Override
        public Component getTreeCellRendererComponent(
                JTree tree, Object value, boolean sel,
                boolean expanded, boolean leaf, int row,
                boolean hasFocus) {
            System.out.println(value);
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
            Object userObject = node.getUserObject();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String display = "...";
            if (userObject instanceof Patient){
                Patient p = (Patient)userObject;
                display = p.getId() + " (" + p.getName()+")";
            }
            if (userObject instanceof Study){
                Study s = (Study)userObject;
                display = s.getBeschreibung() + ", " + dateFormat.format(s.getDatum());
            }
            if (userObject instanceof Series){
                Series se = (Series)userObject;
                display = se.getBeschreibung() + ", " + dateFormat.format(se.getDatum());
            }
            if (userObject instanceof Instance){
                Instance i = (Instance) userObject;
                display = i.getFileName();
            }

            return super.getTreeCellRendererComponent(tree, display, sel, expanded, leaf, row, hasFocus);
        }
    }

}
