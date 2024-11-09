package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private List<String> messages = new ArrayList<>();
    private List<T> data;

    public void setMessages(List<String> mensajes) {
        this.messages = mensajes;
    }

    public void setData(List<T> datos) {
        this.data = datos;
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<T> getData() {
        return data;
    }
}
