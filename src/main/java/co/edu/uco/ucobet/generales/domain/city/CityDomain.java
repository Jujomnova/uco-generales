package co.edu.uco.ucobet.generales.domain.city;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

import java.util.UUID;

public class CityDomain extends Domain {

    private String name;
    private StateDomain state;

    private CityDomain(final UUID id, final String name, final StateDomain state) {
        super(id);
        setName(name);
        setState(state);
    }

    public static CityDomain create(final UUID id, final String name, final StateDomain state) {
        return new CityDomain(id, name, state);
    }

    public static CityDomain create(final UUID id, final String name) {
        return new CityDomain(id, name, StateDomain.create());
    }

    public static CityDomain create(final UUID id) {
        return new CityDomain(id, TextHelper.EMPTY, StateDomain.create());
    }

    public static CityDomain create() {
        return new CityDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create());
    }

    public final String getName() {
        return name;
    }

    private void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public final StateDomain getState() {
        return state;
    }

    private void setState(final StateDomain state) {
        this.state = ObjectHelper.getDefault(state, StateDomain.create());
    }
}
