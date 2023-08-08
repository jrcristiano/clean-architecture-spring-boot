package com.api.innovation.presentation.controllers.clients;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.clients.dto.responses.ClientDTO;
import com.api.innovation.application.clients.usecases.GetClientsPaginateUseCase;
import com.api.innovation.infra.databases.hibernate.clients.models.Client;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/clients")
public class GetClientsPaginateController {
    private GetClientsPaginateUseCase getClientsPaginateUseCase;

	public GetClientsPaginateController(GetClientsPaginateUseCase getClientsPaginateUseCase) {
		this.getClientsPaginateUseCase = getClientsPaginateUseCase;
	}

	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de dados"),
    })
	@GetMapping
	public Page<ClientDTO> execute(
		@RequestParam(name = "page", required = false, defaultValue = "1") String page,
		@RequestParam(name = "limit", required = false, defaultValue = "10") String limit,
		@RequestParam(name = "orderBy", required = false, defaultValue = "desc") String orderBy,
		@RequestParam(name = "sortBy", required = false, defaultValue = "createdAt") String sortBy
	) {
		try {
			Page<Client> clients = getClientsPaginateUseCase.execute(
				page,
				limit,
				orderBy,
				sortBy
			);

			return clients.map(client -> new ClientDTO().convertToDTO(client));
			
		} catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
	}
}
