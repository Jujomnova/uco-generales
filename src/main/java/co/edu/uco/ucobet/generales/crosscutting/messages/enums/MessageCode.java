package co.edu.uco.ucobet.generales.crosscutting.messages.enums;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public enum MessageCode {

    M0000(MessageCategory.ERROR, MessageType.TECHNICAL, "M0000", true),
    M0001(MessageCategory.ERROR, MessageType.TECHNICAL, "M0001", true),
    M0002(MessageCategory.ERROR, MessageType.TECHNICAL, "M0002", true),
    M0003(MessageCategory.ERROR, MessageType.TECHNICAL, "M0003", true),
    M0004(MessageCategory.ERROR, MessageType.TECHNICAL, "M0004", false),
    M0005(MessageCategory.ERROR, MessageType.TECHNICAL, "M0005", true),
    M0006(MessageCategory.ERROR, MessageType.TECHNICAL, "M0006", true),
    M0007(MessageCategory.ERROR, MessageType.TECHNICAL, "M0007", true),
    M0008(MessageCategory.ERROR, MessageType.TECHNICAL, "M0008", true),
    M0009(MessageCategory.ERROR, MessageType.TECHNICAL, "M0009", true),
    M0010(MessageCategory.ERROR, MessageType.TECHNICAL, "M0010", true),
    M0011(MessageCategory.ERROR, MessageType.TECHNICAL, "M0011", true),

    MCOU0000(MessageCategory.ERROR, MessageType.BUSINESS, "MCOU0000", false),
    MCOU0001(MessageCategory.ERROR, MessageType.BUSINESS, "MCOU0001", false),
    MCOU0002(MessageCategory.ERROR, MessageType.BUSINESS, "MCOU0002", false),
    MCOU0003(MessageCategory.ERROR, MessageType.BUSINESS, "MCOU0003", false),
    MCOU0004(MessageCategory.ERROR, MessageType.BUSINESS, "MCOU0004", false),
    MCOU0005(MessageCategory.ERROR, MessageType.BUSINESS, "MCOU0005", false),
    MCOU0006(MessageCategory.ERROR, MessageType.BUSINESS, "MCOU0006", false),

    MSTA0000(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0000", false),
    MSTA0001(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0001", false),
    MSTA0002(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0002", false),
    MSTA0003(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0003", false),
    MSTA0004(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0004", false),
    MSTA0005(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0005", false),
    MSTA0006(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0006", false),
    MSTA0007(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0007", false),
    MSTA0008(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0008", false),
    MSTA0009(MessageCategory.ERROR, MessageType.BUSINESS, "MSTA0009", false),
    MSTA0010(MessageCategory.SUCCESS, MessageType.BUSINESS, "MSTA0010", false),

    MCIT0000(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0000", false),
    MCIT0001(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0001", false),
    MCIT0002(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0002", false),
    MCIT0003(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0003", false),
    MCIT0004(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0004", false),
    MCIT0005(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0005", false),
    MCIT0006(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0006", false),
    MCIT0007(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0007", false),
    MCIT0008(MessageCategory.ERROR, MessageType.TECHNICAL, "MCIT0008", true),
    MCIT0009(MessageCategory.SUCCESS, MessageType.BUSINESS, "MCIT0009", false),
    MCIT0010(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0010", false),
    MCIT0011(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0011", false),
    MCIT0012(MessageCategory.ERROR, MessageType.BUSINESS, "MCIT0012", false),

    MMAIL0000(MessageCategory.INFO, MessageType.BUSINESS, "MMAIL0000", false),
    MMAIL0001(MessageCategory.INFO, MessageType.BUSINESS, "MMAIL0001", false),
    MMAIL0002(MessageCategory.ERROR, MessageType.BUSINESS, "MMAIL0002", false),
    ;

    private MessageCode(MessageCategory category, MessageType type, String id, final boolean isBase)
    {
        setCategory(category);
        setType(type);
        setId(id);
        setBase(isBase);
    }

    private MessageCategory category;
    private MessageType type;
    private String id;
    private boolean isBase;

    public MessageCategory getCategory() {
        return category;
    }

    private void setCategory(MessageCategory category) {
        this.category = category;
    }

    public MessageType getType() {
        return type;
    }

    private void setType(MessageType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public boolean isBase() {
        return isBase;
    }

    private void setBase(boolean isBase) {
        this.isBase = isBase;
    }

    public String getFullIdentifier()
    {
        return TextHelper.concatenate(getCategory().name(), TextHelper.UNDERSCORE, getType().name(), TextHelper.UNDERSCORE, getId());
    }
}
