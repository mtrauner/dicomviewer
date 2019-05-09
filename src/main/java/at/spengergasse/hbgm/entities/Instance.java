package at.spengergasse.hbgm.entities;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.util.Objects;

@Entity
@Table (name = "i_instances")
public class Instance {

    @Id
    @Column (name = "i_id")
    private String inID;
    @Column (name = "i_file")
    private File dicomFile;
    @Column (name = "i_rows")
    private int rows;
    @Column (name = "i_instanceNumber")
    private int instanceNumber;
    @Column (name = "i_columns")
    private int columns;
    @Column (name = "i_minValue")
    private short minValue;
    @Column (name = "i_maxValue")
    private short maxValue;
    @Column (name = "i_transferSyntax")
    private String transferSyntax;
    @Column (name = "i_fileName")
    private String fileName;

    public Instance (){}

    public Instance(DicomObject dcm, File dicomFile){

        this.dicomFile = dicomFile;

        inID = dcm.getString(Tag.SOPInstanceUID);
        instanceNumber = dcm.getInt(Tag.InstanceNumber);
        rows = dcm.getInt(Tag.Rows);
        columns = dcm.getInt(Tag.Columns);
        minValue = (short)dcm.getInt(Tag.SmallestImagePixelValue);
        maxValue = (short)dcm.getInt(Tag.LargestImagePixelValue);
        transferSyntax = dcm.getString(Tag.TransferSyntaxUID);
        fileName = dicomFile.getName();
    }

    @Override
    public String toString(){
        return String.format("Instanz[UID=%s,Instanz-Nummer=%s,File-Name=%s,Auflösung=%s x %s,max. Pixelwert=%s,Transfer-Syntax=%s]", inID,instanceNumber,fileName,rows,columns,maxValue,transferSyntax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instance instance = (Instance) o;
        return rows == instance.rows &&
                instanceNumber == instance.instanceNumber &&
                columns == instance.columns &&
                minValue == instance.minValue &&
                maxValue == instance.maxValue &&
                Objects.equals(inID, instance.inID) &&
                Objects.equals(dicomFile, instance.dicomFile) &&
                Objects.equals(transferSyntax, instance.transferSyntax) &&
                Objects.equals(fileName, instance.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inID, dicomFile, rows, instanceNumber, columns, minValue, maxValue, transferSyntax, fileName);
    }

    public String getInID() {
        return inID;
    }

    public void setInID(String id) {
        this.inID = id;
    }

    public File getDicomFile() {
        return dicomFile;
    }

    public void setDicomFile(File dicomFile) {
        this.dicomFile = dicomFile;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public short getMinValue() {
        return minValue;
    }

    public void setMinValue(short minValue) {
        this.minValue = minValue;
    }

    public short getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(short maxValue) {
        this.maxValue = maxValue;
    }

    public int getInstanceNumber() { return instanceNumber; }

    public void setInstanceNumber(int instanceNumber) { this.instanceNumber = instanceNumber; }

    public String getTransferSyntax() { return transferSyntax; }

    public void setTransferSyntax(String transferSyntax) { this.transferSyntax = transferSyntax; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }
}
