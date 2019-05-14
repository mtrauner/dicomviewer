package at.spengergasse.hbgm.entities;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "p_patienten")
//JPQL
@NamedQuery(name="Patient.findAll", query="select p from Patient p")
public class Patient {

    @Id
    @Column (name = "p_id")
    private String id;
    @Column (name = "p_name")
    private String name;
    @Column (name = "p_gebDat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gebDatum;
    @Column (name = "p_geschlecht")
    private String geschlecht;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id")
    private List<Study> studienListe = new ArrayList<Study>();

    public Patient(){}

    public Patient(DicomObject dcm){
        id = dcm.getString(Tag.PatientID);
        name = dcm.getString(Tag.PatientName);
        gebDatum = dcm.getDate(Tag.PatientBirthDate);
        geschlecht = dcm.getString(Tag.PatientSex);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return String.format("Patient[UID=%s,Name=%s,Geburtsdatum=%s,Geschlecht=%s]",id,name,dateFormat.format(gebDatum),geschlecht);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return geschlecht == patient.geschlecht &&
                Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(gebDatum, patient.gebDatum) &&
                Objects.equals(studienListe, patient.studienListe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gebDatum, geschlecht, studienListe);
    }

    public Study FindeStudie(String StudienID){
        if(studienListe != null){
            for(Study studie : studienListe){
                if(Objects.equals(studie.getStID(),StudienID)){
                    return studie;
                }
            }
        }
        return null;
    }

    public void StudieHzfg(Study studie){ studienListe.add(studie);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getGebDatum() {
        return gebDatum;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public List<Study> getStudienListe() {
        return studienListe;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGebDatum(Date gebDatum) {
        this.gebDatum = gebDatum;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }
}
