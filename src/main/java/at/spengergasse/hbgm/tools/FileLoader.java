package at.spengergasse.hbgm.tools;

import at.spengergasse.hbgm.entities.Instance;
import at.spengergasse.hbgm.entities.Patient;
import at.spengergasse.hbgm.entities.Series;
import at.spengergasse.hbgm.entities.Study;
import at.spengergasse.hbgm.interfaces.IFileLoader;
import at.spengergasse.hbgm.interfaces.IObservable;
import at.spengergasse.hbgm.interfaces.IObserver;
import at.spengergasse.hbgm.interfaces.IPatientRepository;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;

import java.io.File;
import java.util.*;

public class FileLoader implements IFileLoader {

    private List<Patient> patientList;
    private IPatientRepository patientRepository;
    private Set<IObserver> observers = new HashSet<>();

    @Override
    public void LadeVerzeichnis(File folder) throws Exception {

        List<File> dcmFiles = new ArrayList<>();
        for(File file : Objects.requireNonNull(folder.listFiles())){
           if(IsDicom(file)){
               dcmFiles.add(file);
           }
        }

        for (File f: dcmFiles) {
            DicomInputStream dcmIn = new DicomInputStream(f);
            DicomObject dcmObj = dcmIn.readDicomObject();

            Patient patient = FindPatient(dcmObj.getString(Tag.PatientID));
            if(patient == null){
                patient = new Patient(dcmObj);
                patientRepository.Hinzufuegen(patient);
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

    @Override
    public void Configure(Builder builder) {
        patientRepository = builder.getPatientRepository();
        patientRepository.registerObserver(this);
        try {
            patientList = patientRepository.GetPatients();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void changed(IObservable o) {

    }

    private static boolean IsDicom(File f) {
        return f.getName().toLowerCase().endsWith(".dcm");
    }
}
