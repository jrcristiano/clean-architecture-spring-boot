package com.api.innovation.application.users.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.databases.hibernate.users.repositories.UserRepository;
import com.api.innovation.infra.handlers.exceptions.BadRequestErrorException;

@Service
public class GetUsersPaginateService {
	private UserRepository userRepository;

	public GetUsersPaginateService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Page<User> execute(
		String page,
		String limit,
		String orderBy,
		String sortBy
	) {
		if (!page.matches("\\d+") || !limit.matches("\\d+")) {
			throw new BadRequestErrorException("PAGE and LIMIT parameters must be numeric.");
		}

		Sort orderBySort = orderBy == "asc" ?
				Sort.by(sortBy).ascending() :
					Sort.by(sortBy).descending();

		Integer parsedPageNumber = Integer.parseInt(page) - 1;
		Integer parsedPageLimit = Integer.parseInt(limit);

		if (parsedPageNumber < 0 || parsedPageLimit <= 0) {
			throw new BadRequestErrorException("PAGE and LIMIT parameters must be greather than zero.");
		}

		PageRequest pageRequest = PageRequest.of(
			parsedPageNumber,
			parsedPageLimit,
			orderBySort
		);

		return userRepository.findAll(pageRequest);
	}
}
