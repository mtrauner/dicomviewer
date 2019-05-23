package at.spengergasse.hbgm.tools;

import at.spengergasse.hbgm.interfaces.*;

/**
 * the builder is a central module which wires all the other modules
 */
public class Builder {
    // references to all the components of the viewer
    // must be set before calling Configure
    private IControlPanel controlPanel;
    private IFileLoader fileLoader;
    private IImagePanel imagePanel;
    private IInfoPanel infoPanel;
    private ILookupTable lookupTable;
    private IPatientRepository patientRepository;
    private IPatientBrowser patientBrowser;
    private IPixelMapper pixelMapper;

    public void Configure() throws Exception {
        if (controlPanel == null
                || fileLoader == null
                || imagePanel == null
                || infoPanel == null
                || lookupTable == null
                || patientRepository == null
                || pixelMapper == null
                || patientBrowser == null){
            throw new Exception("some modules missing");
        } else {
            controlPanel.Configure(this);
            fileLoader.Configure(this);
            imagePanel.Configure(this);
            infoPanel.Configure(this);
            lookupTable.Configure(this);
            patientRepository.Configure(this);
            pixelMapper.Configure(this);
            patientBrowser.Configure(this);
            patientBrowser.changed(patientRepository);
        }

    }

    /////////////////////////////////////////////////////////////
    // getters and setters for all module_interfaces
    /////////////////////////////////////////////////////////////
    public IControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(IControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public IFileLoader getFileLoader() {
        return fileLoader;
    }

    public void setFileLoader(IFileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    public IImagePanel getImagePanel() {
        return imagePanel;
    }

    public void setImagePanel(IImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    public IInfoPanel getInfoPanel() {
        return infoPanel;
    }

    public void setInfoPanel(IInfoPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    public ILookupTable getLookupTable() {
        return lookupTable;
    }

    public void setLookupTable(ILookupTable lookupTable) {
        this.lookupTable = lookupTable;
    }

    public IPatientRepository getPatientRepository() {
        return patientRepository;
    }

    public void setPatientRepository(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public IPatientBrowser getPatientBrowser() {
        return patientBrowser;
    }

    public void setPatientBrowser(IPatientBrowser patientBrowser) {
        this.patientBrowser = patientBrowser;
    }

    public IPixelMapper getPixelMapper() {
        return pixelMapper;
    }

    public void setPixelMapper(IPixelMapper pixelMapper) {
        this.pixelMapper = pixelMapper;
    }

}
