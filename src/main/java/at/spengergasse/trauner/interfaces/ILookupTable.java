package at.spengergasse.trauner.interfaces;

/**
 * a lookup table calculates the alpha-rgb value from an intensity
 * value. The lookup table must actively acquire other used values
 *  like center, width, alpha
 */
public interface ILookupTable extends IModuleBase {
    /**
     * calculate alpha-rgb from intensity value
     * @param intensity intensity
     * @return alpha-rgb value
     */
    int Argb(int intensity);


}
