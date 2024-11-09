package co.edu.uco.ucobet.generales.application.primaryport.interactor;

public interface InteractorWithoutReturn<T> {
    void execute(T data);
}
