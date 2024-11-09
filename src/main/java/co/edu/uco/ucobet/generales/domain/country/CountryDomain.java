package co.edu.uco.ucobet.generales.domain.country;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.Domain;

import java.util.UUID;

public class CountryDomain extends Domain {

    private String name;

    private CountryDomain(final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public static CountryDomain create(final UUID id, final String name) {
        return new CountryDomain(id, name);
    }

    public static CountryDomain create(final UUID id) {
        return new CountryDomain(id, TextHelper.EMPTY);
    }

    public static CountryDomain create() {
        return new CountryDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
    }

    public final String getName() {
        return name;
    }

    private void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }
}
