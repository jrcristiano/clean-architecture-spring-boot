package com.api.innovation.presentation.controllers.auth;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.innovation.application.auth.dto.AuthDTO;
import com.api.innovation.application.auth.usecases.AuthUserUseCase;
import com.api.innovation.infra.config.security.token.AuthToken;
import com.api.innovation.infra.handlers.exceptions.InternalServerErrorException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController()
@RequestMapping("/api/auth")
public class AuthController {

    private AuthUserUseCase authUserUseCase;

    public AuthController(AuthUserUseCase authUserUseCase) {
        this.authUserUseCase = authUserUseCase;
    }
    
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de dados"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping()
    public ResponseEntity<AuthToken> authenticate(@RequestBody @Valid AuthDTO authDTO) {
        try {
            AuthToken token = authUserUseCase.execute(authDTO);
            return ResponseEntity.ok().body(token);

        } catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
    }
}
