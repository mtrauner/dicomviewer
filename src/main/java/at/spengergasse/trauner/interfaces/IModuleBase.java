package at.spengergasse.trauner.interfaces;


/**
 * base interface for all module_interfaces:
 * essentially every module shall implement oberver- and observable
 * functionality.
 * Additionally Configure(...) is defined which is called after
 * UI is assembled.
 */
public interface IModuleBase extends IObserver, IObservable{
    /**
     * Configure will be called by the central builder instance.
     * each module can get access to each other module via the builder.
     * @param builder builder
     */
    public void Configure(Builder builder);
}
