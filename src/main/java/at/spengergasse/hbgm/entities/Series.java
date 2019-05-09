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
@Table (name = "s_series")
public class Series {

    @Id
    @Column (name = "s_id")
    private String sID;
    @Column (name = "s_beschreibung")
    private String beschreibung;
    @Column (name = "s_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "s_id")
    private List<Instance> instanzenListe = new ArrayList<Instance>();

    public Series(){}

    public Series(DicomObject dcm){

        sID = dcm.getString(Tag.SeriesInstanceUID);
        beschreibung = dcm.getString(Tag.SeriesDescription);
        datum = dcm.getDate(Tag.SeriesDate);
    }

    public Instance FindeInstanz(String InstanzID){
        if(instanzenListe != null){
            for(Instance instance : instanzenListe){
                if(Objects.equals(instance.getInID(),InstanzID)){
                    return instance;
                }
            }
        }
        return null;
    }

    public void InstanzHzfg(Instance instanz){ instanzenListe.add(instanz);
    }

    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return String.format("Serie[UID=%s,Beschreibung=%s,Datum=%s]", sID,beschreibung,dateFormat.format(datum));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return Objects.equals(sID, series.sID) &&
                Objects.equals(beschreibung, series.beschreibung) &&
                Objects.equals(datum, series.datum) &&
                Objects.equals(instanzenListe, series.instanzenListe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sID, beschreibung, datum, instanzenListe);
    }

    public String getSID() {
        return sID;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Date getDatum() {
        return datum;
    }

    public List<Instance> getInstanzenListe() {
        return instanzenListe;
    }

    public void setSID(String id) {
        this.sID = id;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
