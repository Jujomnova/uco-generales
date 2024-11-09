package co.edu.uco.ucobet.generales.application.primaryport.interactor;

public interface InteractorWithReturn<T, R> {
    R execute(T data);
}
