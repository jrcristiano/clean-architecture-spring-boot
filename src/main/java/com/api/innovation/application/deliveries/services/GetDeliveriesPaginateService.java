package com.api.innovation.application.deliveries.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.deliveries.models.Delivery;
import com.api.innovation.infra.databases.hibernate.deliveries.repositories.DeliveryRepository;
import com.api.innovation.infra.handlers.exceptions.BadRequestErrorException;

@Service
public class GetDeliveriesPaginateService {
    private DeliveryRepository deliveryRepository;

    public GetDeliveriesPaginateService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Page<Delivery> execute(
        String page,
        String limit,
        String orderBy,
        String sortBy
    ) {
        if (!page.matches("\\d+") || !limit.matches("\\d+")) {
            throw new BadRequestErrorException("PAGE and LIMIT parameters must be numeric.");
        }

        Sort orderBySort = orderBy.equals("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Integer parsedPageNumber = Integer.parseInt(page) - 1;
        Integer parsedPageLimit = Integer.parseInt(limit);

        if (parsedPageNumber < 0 || parsedPageLimit <= 0) {
            throw new BadRequestErrorException("PAGE and LIMIT parameters must be greater than zero.");
        }

        PageRequest pageRequest = PageRequest.of(
            parsedPageNumber,
            parsedPageLimit,
            orderBySort
        );

        return deliveryRepository.findAll(pageRequest);
    }
}