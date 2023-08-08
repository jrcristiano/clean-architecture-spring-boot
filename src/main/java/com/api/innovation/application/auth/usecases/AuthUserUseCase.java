package com.api.innovation.application.auth.usecases;

import org.springframework.stereotype.Component;

import com.api.innovation.application.auth.dto.AuthDTO;
import com.api.innovation.application.users.services.GetUserByEmailService;
import com.api.innovation.infra.config.security.token.AuthToken;
import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.databases.hibernate.users.utils.BcryptPassword;
import com.api.innovation.infra.handlers.exceptions.UnauthorizedErrorException;
import com.api.innovation.infra.utils.token.TokenUtil;

@Component
public class AuthUserUseCase {

    private GetUserByEmailService getUserByEmailService;

    public AuthUserUseCase(GetUserByEmailService getUserByEmailService) {
        this.getUserByEmailService = getUserByEmailService;
    }

    public AuthToken execute(AuthDTO authDTO) {
		User user = getUserByEmailService.execute(authDTO.getEmail()).get();

        Boolean checkPassword = BcryptPassword.passwordMatches(authDTO.getPassword(), user.getPassword());
        if (!checkPassword) {
            throw new UnauthorizedErrorException("Incorrect password, please try again.");
        } 

        user.setPassword(null);

        AuthToken token = TokenUtil.encodeToken(user);

        System.out.println(token);
        
        return token;
	}
    
}
