package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.mapper.CityDomainToEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messagecatalog.MessageCache;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

    private final SendGridEmailService sendGridEmailService;
    private final MessageCache messageCache;
    private final CityRepository cityRepository;
    private final RegisterNewCityRulesValidator registerNewCityRulesValidator;

    @Autowired
    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator,
                               final SendGridEmailService sendGridEmailService,
                               final MessageCache messageCache) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.sendGridEmailService = sendGridEmailService;
        this.messageCache = messageCache;
    }

    @Override
    public void execute(final CityDomain domain) {

        registerNewCityRulesValidator.validate(domain);
        CityEntity cityEntity = CityDomainToEntityMapper.map(domain);
        cityRepository.save(cityEntity);

        String subject = messageCache.getUserMessage(MessageCode.MMAIL0001.getId());
        String content = TextHelper.replaceExceptionMessageParams(messageCache.getUserMessage(MessageCode.MMAIL0000.getId()), cityEntity.getName(), cityEntity.getState().getId().toString());

        sendGridEmailService.sendEmail(subject, content);
    }
}
