package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.mapper.CityDomainToEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messageCatalog.MessageCache;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.NotificationService;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

    @Autowired
    private final SendGridEmailService sendGridEmailService;

    private final CityRepository cityRepository;
    private final RegisterNewCityRulesValidator registerNewCityRulesValidator;

    public RegisterNewCityImpl(final CityRepository cityRepository, final RegisterNewCityRulesValidator registerNewCityRulesValidator, final SendGridEmailService sendGridEmailService) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.sendGridEmailService = sendGridEmailService;
    }

    @Override
    public void execute(final CityDomain domain) {

        registerNewCityRulesValidator.validate(domain);
        CityEntity cityEntity = CityDomainToEntityMapper.map(domain);
        cityRepository.save(cityEntity);

        // Notify the admin about the creation of the city
        // TODO: Notification building block
        // 1. Admin's mail is in a parametrized place (parameters building block)
        // 2. Mail subject is in a parametrized place (parameters building block)
        // 3. Mail content is in a parametrized place (parameters building block)

        String subject = MessageCache.getInstance().getUserMessage(MessageCode.MMAIL0001.getId());
        String content = TextHelper.replaceExceptionMessageParams(MessageCache.getInstance().getUserMessage(MessageCode.MMAIL0000.getId()), cityEntity.getName(), cityEntity.getState().getId().toString());

        sendGridEmailService.sendEmail(subject, content);
    }
}
