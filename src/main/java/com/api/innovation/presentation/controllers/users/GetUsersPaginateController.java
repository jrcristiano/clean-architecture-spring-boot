package com.api.innovation.presentation.controllers.users;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.users.dto.responses.UserDTO;
import com.api.innovation.application.users.usecases.GetUsersPaginateUseCase;
import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/users")
public class GetUsersPaginateController {

	private final GetUsersPaginateUseCase getUsersPaginateUseCase;

	public GetUsersPaginateController(GetUsersPaginateUseCase getUsersPaginateUseCase) {
		this.getUsersPaginateUseCase = getUsersPaginateUseCase;
	}

	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de dados"),
    })	
	@GetMapping
	public Page<UserDTO> execute(
		@RequestParam(name = "page", required = false, defaultValue = "1") String page,
		@RequestParam(name = "limit", required = false, defaultValue = "10") String limit,
		@RequestParam(name = "orderBy", required = false, defaultValue = "desc") String orderBy,
		@RequestParam(name = "sortBy", required = false, defaultValue = "createdAt") String sortBy
	) {
		try {
			Page<User> users = getUsersPaginateUseCase.execute(
				page,
				limit,
				orderBy,
				sortBy
			);

			return users.map(user -> new UserDTO().convertToDTO(user));
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
