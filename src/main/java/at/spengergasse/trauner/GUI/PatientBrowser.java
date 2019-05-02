package at.spengergasse.trauner.GUI;

import at.spengergasse.trauner.entities.Instance;
import at.spengergasse.trauner.entities.Patient;
import at.spengergasse.trauner.entities.Series;
import at.spengergasse.trauner.entities.Study;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.text.SimpleDateFormat;

public class PatientBrowser extends JTree {
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel model;

    PatientBrowser(){
        rootNode = new DefaultMutableTreeNode();
        model = new DefaultTreeModel(rootNode);
        this.setModel(model);
        this.setCellRenderer(new Renderer());
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
