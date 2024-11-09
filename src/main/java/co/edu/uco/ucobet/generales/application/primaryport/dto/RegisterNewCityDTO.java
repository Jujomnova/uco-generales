package co.edu.uco.ucobet.generales.application.primaryport.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class RegisterNewCityDTO {

    private UUID stateId;
    private String cityName;

    private RegisterNewCityDTO(final UUID stateId, final String name) {
        setStateId(stateId);
        setCityName(name);
    }

    public static RegisterNewCityDTO create(final UUID stateId, final String name) {
        return new RegisterNewCityDTO(stateId, name);
    }

    public UUID getStateId() {
        return stateId;
    }

    public String getName() {
        return cityName;
    }

    private void setStateId(final UUID stateId) {
        this.stateId = UUIDHelper.getDefault(stateId, UUIDHelper.getDefault());
    }

    private void setCityName(final String name) {
        this.cityName = TextHelper.applyTrim(name);
    }
}
