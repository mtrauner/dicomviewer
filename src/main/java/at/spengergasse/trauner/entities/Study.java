package at.spengergasse.trauner.entities;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "st_studies")
public class Study {

    @Id
    @Column (name = "st_id")
    private String stID;
    @Column (name = "st_beschreibung")
    private String beschreibung;
    @Column (name = "st_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "st_id")
    private List<Series> serienListe = new ArrayList<Series>();

    public Study(){}

    public Study(DicomObject dcm){
        stID = dcm.getString(Tag.StudyInstanceUID);
        beschreibung = dcm.getString(Tag.StudyDescription);
        datum = dcm.getDate(Tag.StudyDate);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return String.format("Studie[UID=%s,Beschreibung=%s,Datum=%s]", stID,beschreibung,dateFormat.format(datum));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Study study = (Study) o;
        return Objects.equals(stID, study.stID) &&
                Objects.equals(beschreibung, study.beschreibung) &&
                Objects.equals(datum, study.datum) &&
                Objects.equals(serienListe, study.serienListe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stID, beschreibung, datum, serienListe);
    }

    public Series FindeSerie(String SeriesID){
        if(serienListe != null){
            for(Series serie : serienListe){
                if(Objects.equals(serie.getSID(),SeriesID)){
                    return serie;
                }
            }
        }
        return null;
    }

    public void SerieHzfg(Series serie) { serienListe.add(serie);
    }

    public String getStID() {
        return stID;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Date getDatum() {
        return datum;
    }

    public List<Series> getSerienListe() {
        return serienListe;
    }

    public void setStID(String id) {
        this.stID = id;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
