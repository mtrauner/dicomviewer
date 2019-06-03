package at.spengergasse.hbgm.interfaces;

/**
 * a control panel must provide the possibility to
 * adjust center, width and alpha value.
 * getters are provided to retrieve these values
 */
public interface IControlPanel extends IModuleBase, IModuleUI {
    int getWindowCenter();
    int getWindowWidth();
    int getAlpha();
}
