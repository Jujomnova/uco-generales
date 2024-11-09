package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.data.sql.repository;

import co.edu.uco.ucobet.generales.application.secondaryport.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.repository.CityRepositoryCustom;
import co.edu.uco.ucobet.generales.crosscutting.exception.RepositoryUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public final class CityRepositoryCustomImpl implements CityRepositoryCustom {

    private final EntityManager entityManager;

    public CityRepositoryCustomImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CityEntity> findByNameAndState(final String name, final StateEntity state) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(CityEntity.class);
            var result = query.from(CityEntity.class);

            var predicates = new ArrayList<>();

            if (!TextHelper.isNull(name) && !ObjectHelper.isNull(state)) {
                if (!TextHelper.isEmpty(name)) {
                    predicates.add(criteriaBuilder.equal(result.get("name"), name));
                }
                if (!UUIDHelper.isDefault(state.getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("state"), state.getId()));
                }
            }
            query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getResultList();
        } catch (final Exception exception) {
            throw RepositoryUcobetException.create(
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0008)
            );
        }
    }
}
