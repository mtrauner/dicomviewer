package at.spengergasse.trauner.interfaces;

/**
 * An IObserver can register with one or more IObservable objects and shall
 * be notified if there are relevant changes
 *
 */
public interface IObserver {
    /**
     * will be called by the observable which was changed
     * @param o reference to the changed observable
     */
    void changed(IObservable o);
}
