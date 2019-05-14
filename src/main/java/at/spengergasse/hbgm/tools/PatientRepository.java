package at.spengergasse.hbgm.tools;

import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.entities.Patient;
import at.spengergasse.hbgm.entities.Series;
import at.spengergasse.hbgm.entities.Study;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IPatientRepository;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientRepository implements IPatientRepository {

    private List<Patient> patientList = new ArrayList<>();

    public void Persist(String directoryPath) throws IOException {
        patientList = LoadPatients(directoryPath);
        EntityManager em = Persistence
                .createEntityManagerFactory("viewer")
                .createEntityManager();

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }

    public List<Patient> GetPatients(){
        EntityManager em = Persistence
                .createEntityManagerFactory("viewer")
                .createEntityManager();
        TypedQuery<Patient> query = em
                .createNamedQuery("Patient.findAll",Patient.class);
        patientList = query.getResultList();
        em.close();
        return patientList;
    }

    @Override
    public void Hinzufuegen(Patient p) throws Exception {

    }

    @Override
    public void Entfernen(Patient p) throws Exception {

    }

    public List<Patient> LoadPatients(String path) throws IOException {

        File directory = new File(path);
        List<File> fileList = FindDicomFiles(directory);
        for (File f: fileList) {
            DicomInputStream dcmIn = new DicomInputStream(f);
            DicomObject dcmObj = dcmIn.readDicomObject();

            Patient patient = FindPatient(dcmObj.getString(Tag.PatientID));
            if(patient == null){
                patient = new Patient(dcmObj);
                patientList.add(patient);
            }
            Study study = patient.FindeStudie(dcmObj.getString(Tag.StudyInstanceUID));
            if(study == null){
                study = new Study(dcmObj);
                patient.StudieHzfg(study);
            }
            Series series = study.FindeSerie(dcmObj.getString(Tag.SeriesInstanceUID));
            if(series == null){
                series = new Series(dcmObj);
                study.SerieHzfg(series);
            }
            Instance instance = series.FindeInstanz(dcmObj.getString(Tag.SOPInstanceUID));
            if(instance == null){
                instance = new Instance(dcmObj,f);
                series.InstanzHzfg(instance);
            }
        }
        return patientList;
    }

    private Patient FindPatient(String patID){
        if(patientList != null) {
            for (Patient patient : patientList) {

                if (Objects.equals(patient.getId(), patID)) {
                    return patient;
                }
            }
        }
        return null;
    }

    private List<File> FindDicomFiles(File dir){
        List<File> files = new ArrayList<>();
        for(File f : Objects.requireNonNull(dir.listFiles())){
            if (f.isDirectory())
                files.addAll(FindDicomFiles(f));
            else{
                if (IsDicom(f))
                    files.add(f);
            }
        }
        return files;
    }

    private static boolean IsDicom(File f) {
        return f.getName().toLowerCase().endsWith(".dcm");
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
