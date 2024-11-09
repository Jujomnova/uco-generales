package co.edu.uco.ucobet.generales.domain.state;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

import java.util.UUID;

public class StateDomain extends Domain {

    private String name;
    private CountryDomain country;

    private StateDomain(final UUID id, final String name, final CountryDomain country) {
        super(id);
        setName(name);
        setCountry(country);
    }

    public static StateDomain create(final UUID id, final String name, final CountryDomain country) {
        return new StateDomain(id, name, country);
    }

    public static StateDomain create(final UUID id, final String name) {
        return new StateDomain(id, name, CountryDomain.create());
    }

    public static StateDomain create(final UUID id) {
        return new StateDomain(id, TextHelper.EMPTY, CountryDomain.create());
    }

    public static StateDomain create() {
        return new StateDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, CountryDomain.create());
    }

    public final String getName() {
        return name;
    }

    private void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public final CountryDomain getCountry() {
        return country;
    }

    private void setCountry(final CountryDomain country) {
        this.country = ObjectHelper.getDefault(country, CountryDomain.create());
    }
}