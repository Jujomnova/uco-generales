package co.edu.uco.ucobet.generales.application.primaryport.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class GetStateDTO {

    private UUID stateId;
    private UUID countryId;
    private String stateName;

    private GetStateDTO(final UUID stateId, final String name, final UUID countryId) {
        setStateId(stateId);
        setStateName(name);
        setCountryId(countryId);
    }

    public static GetStateDTO create(final UUID stateId, final String name, final UUID countryId) {
        return new GetStateDTO(stateId, name, countryId);
    }

    public UUID getStateId() {
        return stateId;
    }

    public String getStateName() {
        return stateName;
    }

    private void setStateId(final UUID stateId) {
        this.stateId = UUIDHelper.getDefault(stateId, UUIDHelper.getDefault());
    }

    private void setStateName(final String name) {
        this.stateName = TextHelper.applyTrim(name);
    }

    public UUID getCountryId() {
        return countryId;
    }

    private void setCountryId(final UUID countryId) {
        this.countryId = UUIDHelper.getDefault(countryId, UUIDHelper.getDefault());
    }
}
