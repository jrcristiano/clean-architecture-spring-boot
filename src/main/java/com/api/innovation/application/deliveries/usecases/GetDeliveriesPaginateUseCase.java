package com.api.innovation.application.deliveries.usecases;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.api.innovation.application.deliveries.services.GetDeliveriesPaginateService;
import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;

@Component
public class GetDeliveriesPaginateUseCase {
    private GetDeliveriesPaginateService getDeliveriesPaginateService;

    public GetDeliveriesPaginateUseCase(GetDeliveriesPaginateService getDeliveriesPaginateService) {
        this.getDeliveriesPaginateService = getDeliveriesPaginateService;
    }

    public Page<Delivery> execute(String page, String limit, String orderBy, String sortBy) {
        return this.getDeliveriesPaginateService.execute(page, limit, orderBy, sortBy);
    }
}
