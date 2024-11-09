package co.edu.uco.ucobet.generales.crosscutting.messages;

import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

public class Message {

    private MessageCode code;
    private String content;

    public Message(final MessageCode code, final String content)
    {
        setCode(code);
        setContent(content);
    }

    public MessageCode getCode() {
        return code;
    }

    public void setCode(MessageCode code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public final String getIdentifier()
    {
        return this.getCode().getFullIdentifier();
    }

    public final boolean isBase()
    {
        return getCode().isBase();
    }
}
